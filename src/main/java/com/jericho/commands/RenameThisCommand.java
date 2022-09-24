// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.jericho.commands;

import com.jericho.listeners.CommandInterface;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public class RenameThisCommand implements CommandInterface {

    @Override
    public String getName() {
        return "wb_add_word";
    }

    @Override
    public String getDescription() {
        return "Add a word to a lang file (Admin Only)";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.STRING, "word", "Add a new word").setRequired(true));
        data.add(new OptionData(OptionType.STRING, "language", "Language to add the word to.").setRequired(true));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

    }
}
