/* Copyright (c) 2023, Discord Bot Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.template;

import com.template.listeners.CommandManager;
import com.template.listeners.EventListeners;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static com.template.util.Authentication.getToken;

public class Main {
    private ShardManager shardManager;

    public Main() throws LoginException, IOException {
        shardManager = buildBot();
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (LoginException | IOException e) {
            System.out.println("Failed to start bot: " + e.getMessage());
        }
    }

    @NotNull
    private ShardManager buildBot() throws IOException {
        String token = getToken();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Discord Bot Template"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT);

        shardManager = builder.build();
        shardManager.addEventListener(new EventListeners());

        CommandManager manager = new CommandManager();
        //manager.add(new CommandClassName());

        shardManager.addEventListener(manager);

        return shardManager;
    }
}
