package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton list;
    public JButton delete;
    public JButton exit;
    public JButton post;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        addd = new JButton("Add");
        addd.setLocation(200, 150);
        addd.setSize(300, 30);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);

        list = new JButton("List");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(list);

        post = new JButton("New Post");
        post.setLocation(200, 230);
        post.setSize(300, 30);
        post.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Admin.frame.post.setVisible(true);
            }
        });
        add(post);

        delete= new JButton("Delete");
        delete.setLocation(200, 270);
        delete.setSize(300, 30);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setForeground(black);
        exit.setBackground(gray);
        exit.setBounds(200, 350, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}

