package com.chalwk;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.TimerTask;

import static com.chalwk.Main.*;
import static com.chalwk.Utilities.FileIO.writeJSONObject;

public class Logger {

    private static final JSONObject settings = getSettings();

    static JDA jda = getJDA();

    public static class Task extends TimerTask {

        @Override
        public void run() {
            try {

                JSONObject logs = getLogs();

                for (String fileName : logs.keySet()) {

                    boolean update = false;
                    JSONArray logEntry = (JSONArray) logs.get(fileName);
                    for (int i = 0; i < logEntry.length(); i++) {

                        JSONArray entry = logEntry.getJSONArray(i);
                        boolean logged = entry.getBoolean(1);
                        if (!logged) {

                            Object embedObject = entry.get(0);
                            String channelID = entry.getString(2);
                            EmbedBuilder embed = new Embed().newEmbed(embedObject);

                            TextChannel channel = jda.getTextChannelById(channelID);
                            if (channel != null) {
                                channel.sendMessageEmbeds(embed.build()).queue();
                                entry.put(1, true);
                                update = true;
                            }
                        }
                    }
                    if (update) {
                        writeJSONObject(logEntry, "Logs/" + fileName);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
