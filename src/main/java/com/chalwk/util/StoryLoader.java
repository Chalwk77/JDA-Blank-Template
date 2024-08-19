/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.util;

import net.dv8tion.jda.api.EmbedBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class StoryLoader {
    private static List<EmbedBuilder> grannyStoriesEmbeds;

    public static void loadStories() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("grannyStories.json"); // this line
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        JSONObject grannyStoriesJsonObject = new JSONObject(reader); // this line
        //JSONArray grannyStoriesJsonArray = grannyStoriesJsonObject.getJSONArray("grannyStories");

//        grannyStoriesEmbeds = new ArrayList<>();
//        for (int i = 0; i < grannyStoriesJsonArray.length(); i++) {
//            JSONObject storyObject = grannyStoriesJsonArray.getJSONObject(i);
//
//            EmbedBuilder embedBuilder = new EmbedBuilder();
//
//            embedBuilder.setTitle(storyObject.getString("title"));
//
//            JSONArray descriptionArray = storyObject.getJSONArray("description");
//            StringBuilder descriptionBuilder = new StringBuilder();
//            for (int j = 0; j < descriptionArray.length(); j++) {
//                descriptionBuilder.append(descriptionArray.getString(j)).append("\n");
//            }
//            embedBuilder.setDescription(descriptionBuilder.toString());
//
//            embedBuilder.setColor(Color.decode(storyObject.getString("color")));
//
//            grannyStoriesEmbeds.add(embedBuilder);
//        }
    }


    public static List<EmbedBuilder> getStories() {
        return grannyStoriesEmbeds;
    }
}
