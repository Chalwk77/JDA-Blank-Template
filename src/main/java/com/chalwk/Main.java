// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk;

import com.chalwk.commands.RenameThisCommand;
import com.chalwk.listeners.CommandManager;
import com.chalwk.listeners.EventListeners;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static com.chalwk.util.Authentication.getToken;
import static com.chalwk.util.FileIO.loadJSONFile;

public class Main {

    public static JSONObject settings;

    static {
        try {
            settings = loadJSONFile("settings.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final ShardManager shardManager;

    public Main() throws LoginException, IOException {

        String token = getToken();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Halo PC/CE"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT);

        shardManager = builder.build();
        shardManager.addEventListener(new EventListeners());

        CommandManager manager = new CommandManager();
        manager.add(new RenameThisCommand());

        shardManager.addEventListener(manager);
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (LoginException | IOException e) {
            System.out.println("Failed to start bot: " + e.getMessage());
            System.out.println("ERROR: Provided bot token is invalid.");
        }
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
}
