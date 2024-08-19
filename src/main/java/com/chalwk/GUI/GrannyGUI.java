package com.chalwk.GUI;/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GrannyGUI extends JFrame {

    public GrannyGUI() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea conversationView = new JTextArea();
        conversationView.setFont(new Font("Arial", Font.PLAIN, 16));
        conversationView.setBorder(new LineBorder(Color.GRAY));

        JTextField messageInput = new JTextField();
        messageInput.setFont(new Font("Arial", Font.PLAIN, 16));
        messageInput.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sendButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        sendButton.addActionListener(new SendButtonListener(messageInput));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Granny Chatbot");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);

        try {
            setIconImage(ImageIO.read(new File("C:\\Users\\Jeric\\IdeaProjects\\Granny\\icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(titlePanel, BorderLayout.NORTH);
        add(conversationView, BorderLayout.CENTER);
        add(messageInput, BorderLayout.SOUTH);
        add(sendButton, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
