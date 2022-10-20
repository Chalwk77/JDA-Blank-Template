package com.chalwk.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.chalwk.Main.getSettings;

public class FileIO {

    static String programPath = getProgramPath();

    private static void checkExists(File file) throws IOException {
        boolean exists = file.exists();
        if (!exists) {
            file.createNewFile();
        }
    }

    private static String getProgramPath() {
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory = currentDirectory.replace("\\", "/");
        return currentDirectory;
    }

    public static String readFile(String fileName) throws IOException {

        File f = new File(programPath + "/" + fileName);
        checkExists(f);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }

        reader.close();
        return stringBuilder.toString();
    }

    public static JSONArray getJSONArray(String fileName) throws IOException {
        String content = readFile(fileName);
        if (content.equals("")) {
            return new JSONArray();
        } else {
            return new JSONArray(content);
        }
    }

    public static JSONObject getJSONObject(String fileName) throws IOException {
        String content = readFile(fileName);
        if (content.equals("")) {
            return new JSONObject();
        } else {
            return new JSONObject(content);
        }
    }

    public static void writeJSONArray(JSONArray json, String fileName) throws IOException {
        //deleteFileIfTooBig(fileName);
        FileWriter fileWriter = new FileWriter(programPath + "/" + fileName);
        fileWriter.write(json.toString(4));
        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJSONObject(JSONArray json, String fileName) throws IOException {
        //deleteFileIfTooBig(fileName);
        FileWriter fileWriter = new FileWriter(programPath + "/" + fileName);
        fileWriter.write(json.toString(4));
        fileWriter.flush();
        fileWriter.close();
    }

    public static void deleteFileIfTooBig(String fileName) throws IOException {

        int maxFileSize = getSettings().getInt("max_file_size");

        Path path = new File(programPath).toPath();
        DirectoryStream<Path> stream = Files.newDirectoryStream(path, fileName);

        for (Path file : stream) {
            if (Files.isRegularFile(file)) {

                long size = Files.size(file); // size in bytes
                int sizeInKB = (int) (size / 1024);

                System.out.println("File size: " + sizeInKB);

                if (sizeInKB > maxFileSize) {
                    Files.delete(file);

                    System.out.println("File deleted: " + file + " (" + sizeInKB + "KB)");

                    File f = new File(programPath + "/" + fileName);
                    checkExists(f);
                }
            }
        }
        stream.close();
    }
}
