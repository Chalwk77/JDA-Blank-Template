/* Copyright (c) 2023, Discord Bot Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.template.listeners;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListeners extends ListenerAdapter {

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        System.out.println("""
                _______________________________________________
                Copyright (c) 2023, Discord Bot Template. Jericho Crosby
                _______________________________________________""");
    }
}