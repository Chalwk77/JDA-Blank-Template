// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.jericho;

import com.jericho.Utilities.FileIO;
import com.jericho.listeners.CommandManager;
import com.jericho.commands.RenameThisCommand;
import com.jericho.listeners.EventListeners;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import org.json.JSONObject;

import javax.security.auth.login.LoginException;

import java.io.IOException;

public class Main {

    public static JSONObject settings;

     // Retrieves the settings from the settings.json file.
    static {
        try {
            settings = FileIO.loadJSONObject("settings.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final ShardManager shardManager;

    /**
     * Convenience method for printing to console:
     *
     * @param str The message to print to console.
     */
    public static void cprint(String str) {
        System.out.println(str);
    }

    /**
     * Returns the bot token:
     */
    public static String getToken() {
        return String.valueOf(settings.getString("token"));
    }

    /**
     * Loads environment variables and builds the bot shard manager:
     * @throws LoginException if the bot token is invalid.
     */
    public Main() throws LoginException {

        String token = getToken();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("YOU"));
        builder.enableIntents(
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT
        );

        shardManager = builder.build();
        shardManager.addEventListener(new EventListeners());

        CommandManager manager = new CommandManager();
        manager.add(new RenameThisCommand());

        shardManager.addEventListener(manager);
    }

    /**
     * Retrieves the shard manager:
     * @return The shardManager instance for the bot.
     */
    public ShardManager getShardManager() {
        return shardManager;
    }

    /**
     * Main static method:
     *
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        try {
            new Main();
        } catch (LoginException e) {
            cprint("ERROR: Provided bot token is invalid");
        }
    }
}
