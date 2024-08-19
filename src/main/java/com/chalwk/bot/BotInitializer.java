/* Copyright (c) 2024, JDA Blank Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.chalwk.bot;

import com.chalwk.CommandManager.CommandInterface;
import com.chalwk.CommandManager.CommandListener;
import com.chalwk.events.MessageListener;
import com.chalwk.util.Authentication;
import com.chalwk.util.StoryLoader;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

import static org.reflections.Reflections.log;

public class BotInitializer {

    private final String token;

    public BotInitializer() throws IOException {
        this.token = Authentication.getToken();
    }

    public void initializeBot() throws IOException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(this.token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("The Chat"));
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT);

        ShardManager shardManager = builder.build();
        shardManager.addEventListener(new MessageListener());
        shardManager.addEventListener(loadCommands());

        StoryLoader.loadStories();
    }

    @NotNull
    private static CommandListener loadCommands() {
        CommandListener commands = new CommandListener();
        Reflections reflections = new Reflections("com.chalwk.commands");
        for (Class<?> commandClass : reflections.getSubTypesOf(CommandInterface.class)) {
            try {
                commands.add((CommandInterface) commandClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                log.warn("Failed to load command: " + commandClass.getName(), e, Level.WARNING);
            }
        }
        return commands;
    }
}
