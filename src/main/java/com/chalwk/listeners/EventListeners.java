// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class EventListeners extends ListenerAdapter {

    @Override
    public void onGuildReady(@Nonnull GuildReadyEvent event) {
        System.out.println("Guild ready: " + event.getGuild().getName());
        System.out.println("Bot name: " + event.getJDA().getSelfUser().getName());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        User author = event.getAuthor();
        String name = author.getName();
        String message = event.getMessage().getContentRaw();

        // Ignore messages from bots
        if (!author.isBot()) {

        }
    }
}