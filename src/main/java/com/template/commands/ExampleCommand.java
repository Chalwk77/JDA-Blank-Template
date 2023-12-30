/* Copyright (c) 2023, Discord Bot Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.template.commands;

import com.template.listeners.CommandInterface;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommand implements CommandInterface {

    @Override
    public String getName() {
        return "command name here";
    }

    @Override
    public String getDescription() {
        return "command description here";
    }

    @Override
    public List<OptionData> getOptions() {
        return new ArrayList<>();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

    }
}