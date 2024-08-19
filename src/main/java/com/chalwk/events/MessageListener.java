/* Copyright (c) 2024, JDA Blank Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.chalwk.events;

import com.chalwk.Granny.GrannyResponses;
import com.chalwk.Granny.SpamDetector;
import com.chalwk.Main;
import com.chalwk.enums.ResponseType;
import com.chalwk.features.CatFacts;
import com.chalwk.util.SwearWordLoader;
import com.chalwk.util.SwearWordPattern;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

public class MessageListener extends ListenerAdapter {

    private final SwearWordLoader swearWordLoader;

    public MessageListener() {
        InputStream swearWordsStream = Main.class.getClassLoader().getResourceAsStream("swearWords.txt");
        swearWordLoader = new SwearWordLoader(swearWordsStream);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }
        String message = event.getMessage().getContentRaw();

        if (containsLordName(message)) {
            event.getChannel().sendMessage(GrannyResponses.getRandomGrannyResponse(ResponseType.LORDS_NAME)).queue();
        } else {
            if (checkForSpam(event, message)) {
                event.getChannel().sendMessage(GrannyResponses.getRandomGrannyResponse(ResponseType.SPAM)).queue();
            } else if (checkForSwearWords(event, message)) {
                event.getChannel().sendMessage(GrannyResponses.getRandomGrannyResponse(ResponseType.SWEAR_WORD)).queue();
            } else if (CatFacts.shouldSendCatFact()) {
                String catFact = CatFacts.getRandomFact();
                event.getChannel().sendMessage(catFact).queue();
            }
        }
    }

    private boolean checkForSwearWords(@NotNull MessageReceivedEvent event, String message) {
        for (SwearWordPattern pattern : swearWordLoader.getSwearWordPatterns()) {
            if (pattern.matches(message)) {
                event.getMessage().delete().queue();
                return true;
            }
        }
        return false;
    }

    private boolean checkForSpam(@NotNull MessageReceivedEvent event, String message) {
        if (SpamDetector.isSpam(message)) {
            event.getMessage().delete().queue();
            return true;
        }
        return false;
    }

    private boolean containsLordName(String message) {
        return message.contains("God") || message.contains("Jesus");
    }
}