/* Copyright (c) 2024, JDA Blank Template. Jericho Crosby <jericho.crosby227@gmail.com> */

package com.chalwk.commands;

import com.chalwk.CommandManager.CommandInterface;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommand implements CommandInterface {

    @Override
    public String getName() {
        return "test_command";
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