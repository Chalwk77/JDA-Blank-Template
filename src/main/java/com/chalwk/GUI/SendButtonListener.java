/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.GUI;

import com.chalwk.util.Authentication;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SendButtonListener implements ActionListener {

    private final JTextField messageInput;
    public SendButtonListener(JTextField messageInput) {
        this.messageInput = messageInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageInput.getText();
        if (!message.isEmpty()) {

            JDA api;
            try {
                api = JDABuilder.createLight(Authentication.getToken()).build();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            TextChannel channel = api.getTextChannelById("756065302701146123");
            channel.sendMessage(message).queue();
        }
    }
}
