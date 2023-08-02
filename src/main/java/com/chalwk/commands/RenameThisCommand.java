// Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk.commands;

import com.chalwk.listeners.CommandInterface;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class RenameThisCommand implements CommandInterface {

    @Override
    public String getName() {
        return "rename_this_command";
    }

    public String getRoleID() {
        return "role_id_here";
    }

    @Override
    public String getDescription() {
        return "description_here";
    }

    @Override
    public List<OptionData> getOptions() {
        return new ArrayList<>();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        //
        // Command code here
        //
    }
}
