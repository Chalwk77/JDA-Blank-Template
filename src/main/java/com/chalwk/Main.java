/* Copyright (c) 2024, JDA Blank Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.chalwk;
import com.chalwk.bot.BotInitializer;

import java.io.IOException;

public class Main {

    public static void initializeBot() throws IOException {
        BotInitializer botInitializer = new BotInitializer();
        botInitializer.initializeBot();

        // For a future update:
        //GrannyGUI grannyGUI = new GrannyGUI();
        //grannyGUI.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            initializeBot();
        } catch (IOException e) {
            System.err.println("Error reading token or initializing the bot: " + e.getMessage());
        }
    }
}