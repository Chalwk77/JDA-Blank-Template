// Copyright (c) 2023, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk.listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.chalwk.Main.settings;

public class CommandManager extends ListenerAdapter {

    private static final JSONObject commands_on_file = settings.getJSONObject("commands");

    private final List<CommandInterface> commands = new ArrayList<>();

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        for (Guild guild : event.getJDA().getGuilds()) {
            for (CommandInterface command : commands) {
                guild.upsertCommand(command.getName(), command.getDescription()).addOptions(command.getOptions()).queue();
            }
        }
    }

    public boolean hasPerm(SlashCommandInteractionEvent event, CommandInterface command) {

        String roleID = command.getRoleID(); // required role ID

        Member member = event.getMember(); // this member

        assert member != null;
        List<Role> roles = member.getRoles(); // this member's roles

        Guild guild = event.getGuild(); // current guild

        if (!roles.contains(guild.getRoleById(roleID))) {
            event.reply("You do not have permission to use this command.").setEphemeral(true).queue();
            return false;
        }
        return true;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for (CommandInterface command : commands) {
            String this_command = event.getName();
            if (this_command.equals(command.getName()) && (hasPerm(event, command))) {
                command.execute(event);
                return;
            }
        }
    }

    public void add(CommandInterface command) {
        commands.add(command);
    }
}
