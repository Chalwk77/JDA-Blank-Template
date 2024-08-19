/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class SwearWordLoader {
    private List<SwearWordPattern> swearWordPatterns;

    public SwearWordLoader(InputStream swearWordsStream) {
        swearWordPatterns = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(swearWordsStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String swearWord = line.trim();
                String regexPattern = createPattern(swearWord);
                swearWordPatterns.add(new SwearWordPattern(swearWord, regexPattern));
            }
        } catch (IOException e) {
            // Handle the exception
        }
    }

    private String createPattern(String word) {
        StringBuilder pattern = new StringBuilder();
        String spacePattern = "(?:\\s*)";

        for (char c : word.toCharArray()) {
            if (SubstitutionPatterns.getPatterns().containsKey(Character.toString(c))) {
                pattern.append(SubstitutionPatterns.getPatterns().get(Character.toString(c)));
            } else {
                pattern.append(Pattern.quote(Character.toString(c)));
            }
            pattern.append(spacePattern);
        }
        pattern.setLength(pattern.length() - spacePattern.length());

        return pattern.toString();
    }

    public List<SwearWordPattern> getSwearWordPatterns() {
        return swearWordPatterns;
    }
}