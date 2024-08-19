/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.util;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionPatterns {
    private static final Map<String, String> patterns = new HashMap<>();

    static {
        patterns.put("a", "[aA@]");
        patterns.put("b", "[bB]");
        patterns.put("c", "[cCkK]");
        patterns.put("d", "[dD]");
        patterns.put("e", "[eE3]");
        patterns.put("f", "[fF]");
        patterns.put("g", "[gG6]");
        patterns.put("h", "[hH]");
        patterns.put("i", "[iIl!1]");
        patterns.put("j", "[jJ]");
        patterns.put("k", "[cCkK]");
        patterns.put("l", "[lL1!i]");
        patterns.put("m", "[mM]");
        patterns.put("n", "[nN]");
        patterns.put("o", "[oO0]");
        patterns.put("p", "[pP]");
        patterns.put("q", "[qQ9]");
        patterns.put("r", "[rR]");
        patterns.put("s", "[sS$5]");
        patterns.put("t", "[tT7]");
        patterns.put("u", "[uUvV]");
        patterns.put("v", "[vVuU]");
        patterns.put("w", "[wW]");
        patterns.put("x", "[xX]");
        patterns.put("y", "[yY]");
        patterns.put("z", "[zZ2]");
    }

    public static Map<String, String> getPatterns() {
        return patterns;
    }
}