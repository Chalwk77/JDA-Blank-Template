/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.util;

import java.util.regex.Pattern;

public class SwearWordPattern {

    private String swearWord;
    private Pattern pattern;

    public SwearWordPattern(String swearWord, String regexPattern) {
        this.pattern = Pattern.compile(regexPattern);
    }

    public boolean matches(String message) {
        return pattern.matcher(message).find();
    }
}
