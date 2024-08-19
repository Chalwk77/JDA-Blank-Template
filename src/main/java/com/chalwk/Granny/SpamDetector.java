/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.Granny;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SpamDetector {
    private static final Map<Character, Integer> CHAR_LIMITS = new HashMap<>();
    private static final Map<String, Integer> WORD_LIMITS = new HashMap<>();

    static {
        // Set character repetition limits
        CHAR_LIMITS.put('!', 3);
        CHAR_LIMITS.put('#', 3);
        CHAR_LIMITS.put('@', 3);
        CHAR_LIMITS.put('$', 3);
        CHAR_LIMITS.put('%', 3);
        CHAR_LIMITS.put('?', 3);
        CHAR_LIMITS.put('*', 3);
        CHAR_LIMITS.put('^', 3);
        CHAR_LIMITS.put('~', 3);
        CHAR_LIMITS.put('+', 3);
        CHAR_LIMITS.put('=', 3);

        // Set word repetition limits
        WORD_LIMITS.put("hahaha", 3);
        WORD_LIMITS.put("hello", 3);
        WORD_LIMITS.put("spam", 2);
        WORD_LIMITS.put("bot", 2);
        WORD_LIMITS.put("money", 2);
        WORD_LIMITS.put("win", 2);
        WORD_LIMITS.put("prize", 2);
        WORD_LIMITS.put("free", 2);
        WORD_LIMITS.put("limited", 2);
        WORD_LIMITS.put("discount", 2);
        WORD_LIMITS.put("urgent", 2);
        WORD_LIMITS.put("now", 3);
    }

    public static boolean isSpam(String messageContent) {

        // Check character repetitions
        for (Map.Entry<Character, Integer> entry : CHAR_LIMITS.entrySet()) {
            char c = entry.getKey();
            int limit = entry.getValue();
            if (countOccurrences(messageContent, c) > limit) {
                return true;
            }
        }

        // Check word repetitions
        for (Map.Entry<String, Integer> entry : WORD_LIMITS.entrySet()) {
            String word = entry.getKey();
            int limit = entry.getValue();
            if (countOccurrences(messageContent, word) > limit) {
                return true;
            }
        }

        // Check for long sequences of repeated characters
        Pattern regex = Pattern.compile(".* (.)\\1{10}"); // Repeated character sequence at least 10 times
        return regex.matcher(messageContent).find();

        // If none of the checks detected spam, return false
    }

    private static int countOccurrences(String text, char c) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    private static int countOccurrences(String text, String word) {
        int count = 0;
        int wordLength = word.length();

        for (int i = 0; i < text.length() - wordLength + 1; i++) {
            if (text.substring(i, i + wordLength).equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }
}
