package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class UserListPage extends Container {

    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton buy;
    private JButton back;
    private JTextArea area;

    public UserListPage() {
        setLayout(null);
        setSize(700, 700);

        label = new JLabel("INSERT ID:");
        label.setBounds(250, 450, 80, 30);
        add(label);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        area.setEditable(false);
        add(area);


        textField = new JTextField("");
        textField.setBounds(340, 450, 100, 30);
        textField.setForeground(black);
        textField.setBackground(gray);
        add(textField);
        buy = new JButton("INSERT");
        buy.setBounds(150, 500, 100, 50);
        buy.setForeground(black);
        buy.setBackground(gray);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User.showMainMenu();

                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,
                        "PLEASENT PASTIME!!!");
            }

        });
        add(buy);

        back = new JButton("BACK");
        back.setBounds(550, 600, 100, 50);
        back.setForeground(black);
        back.setBackground(gray);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.showMainMenu();
            }
        });
        add(back);

    }

    public void updateArea(ArrayList<Orders> orders) {
        area.setText("");
        for (Orders ts : orders) {
            area.append(ts + "\n");
        }
        repaint();
    }
}

