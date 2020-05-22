package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class UserMainMenu extends Container {
    public JButton addOrders;
    public JButton list;
    public JButton exit;
    public JButton Posts;
    public JButton chat;

    public UserMainMenu() {
        setSize(700, 700);
        setLayout(null);

        addOrders = new JButton("Registration for the event");
        addOrders.setLocation(200, 150);
        addOrders.setSize(300, 30);
        addOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User.frame.menu.setVisible(false);
                User.frame.listPage.setVisible(false);
                User.frame.addOrders.setVisible(true);
                User.frame.repaint();
            }
        });
        add(addOrders);

        list = new JButton("Queue for an event");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User.showListPage();
            }
        });
        add(list);

        /*chat = new JButton("Chat");
        chat.setBounds(200,290,300,30);
        chat.addActionListener((e)->{
            setVisible(false);
            User.frame.chatPage.setVisible(true);
        });
        add(chat);*/

        /*UPDATE GIT CHECK*/


        exit = new JButton("EXIT");
        exit.setBounds(200, 350, 300, 30);
        exit.setForeground(black);
        exit.setBackground(gray);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

        Posts = new JButton("Posts");
        Posts.setBounds(200, 240, 300, 30);
        Posts.addActionListener((e)->{
            setVisible(false);
            User.frame.checkPost.setVisible(true);
        });
        add(Posts);
    }
}


