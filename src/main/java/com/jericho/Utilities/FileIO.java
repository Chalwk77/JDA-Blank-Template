// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.jericho.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class FileIO {

    /**
     * Path to the resources' folder:
     * */
    private static final String path = "src/main/resources/";

    /**
     * Load a JSON file as a JSONArray:
     * @param file The name of the file to load.
     * @return The JSONArray of the file.
     * @throws IOException If the file cannot be found.
     * */
    public static JSONArray loadJSONArray(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path + file));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }
        String content = stringBuilder.toString();
        if (content.equals("")) {
            return new JSONArray();
        } else {
            return new JSONArray(content);
        }
    }

    /**
     * Load a JSON file as a JSONObject:
     * @param file The name of the file to load.
     * @return The JSONObject of the file.
     * @throws IOException If the file cannot be found.
     * */
    public static JSONObject loadJSONObject(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path + file));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }
        String content = stringBuilder.toString();
        if (content.equals("")) {
            return new JSONObject();
        } else {
            return new JSONObject(content);
        }
    }

    /**
     * Save a JSONArray to a file:
     * @param file The name of the file to save to.
     * @param json The JSONArray to save.
     * @throws IOException If the file cannot be found.
     * */
    public static void writeJSONFile(JSONArray json, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(path + file);
        fileWriter.write(json.toString(4));
        fileWriter.flush();
        fileWriter.close();
    }
}
