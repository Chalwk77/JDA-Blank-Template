// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk;

import com.chalwk.Utilities.NewTimer;
import com.chalwk.commands.RenameThisCommand;
import com.chalwk.listeners.CommandManager;
import com.chalwk.listeners.EventListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.chalwk.Utilities.Authentication.getToken;
import static com.chalwk.Utilities.FileIO.getJSONArray;
import static com.chalwk.Utilities.FileIO.getJSONObject;

public class Main {

    public static JSONObject settings;
    private static ShardManager shardManager;

    /**
     * Loads environment variables and builds the bot shard manager:
     *
     * @throws LoginException if the bot token is invalid.
     */
    public Main() throws LoginException, IOException {

        String token = getToken();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Halo 1"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.MESSAGE_CONTENT);

        shardManager = builder.build();
        shardManager.addEventListener(new EventListeners());

        CommandManager manager = new CommandManager();
        manager.add(new RenameThisCommand());

        shardManager.addEventListener(manager);

        loadSettings();
        NewTimer.loggerTimer();
    }

    /**
     * Main static method:
     *
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        try {
            new Main();
        } catch (LoginException | IOException e) {
            System.out.println("ERROR: Provided bot token is invalid");
        }
    }

    public static void loadSettings() {
        try {
            settings = getJSONObject("bot_settings.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getProgramPath() {
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory = currentDirectory.replace("\\", "/");
        return currentDirectory;
    }

    public static JSONObject getLogs() throws IOException {

        JSONObject logs = new JSONObject();

        // Get the working directory path:
        String programPath = getProgramPath();

        // Get the path to the logs' directory:
        Path path = new File(programPath).toPath().resolve("Logs");

        DirectoryStream<Path> stream = Files.newDirectoryStream(path);

        for (Path file : stream) {
            String fileName = file.getFileName().toString();
            JSONArray log = getJSONArray("Logs/" + fileName);
            logs.put(fileName, log);
        }
        stream.close();

        return logs;
    }

    public static JSONObject getSettings() {
        return settings;
    }

    public static JDA getJDA() {
        return shardManager.getShards().get(0);
    }

    /**
     * Retrieves the shard manager:
     *
     * @return The shardManager instance for the bot.
     */
    public ShardManager getShardManager() {
        return shardManager;
    }
}
