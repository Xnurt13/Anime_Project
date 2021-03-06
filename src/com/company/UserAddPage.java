package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class UserAddPage extends Container {
    private JLabel labelId;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JButton addOrders;
    private JButton back;

    public UserAddPage(){
        setLayout(null);
        setSize(700,700);

        labelId=new JLabel("Id:");
        labelId.setBounds(100,150,120,40);
        add(labelId);

        Animes[]animes=null;
        ArrayList<Animes> list = User.listAnimes();
        animes = list.toArray(new Animes[list.size()]);

        JComboBox comboBox=new JComboBox(animes);
        comboBox.setBounds(230,150,250,40);
        add(comboBox);
        labelName=new JLabel("Name:");
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        addOrders=new JButton("ADD");
        addOrders.setForeground(black);
        addOrders.setBackground(gray);
        addOrders.setBounds(100,400,120,50);
        addOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Animes myAnimes = (Animes) comboBox.getSelectedItem();
                    Orders orders=new Orders(null,myAnimes.getId().intValue(),textName.getText(),textSurname.getText());
                    User.addOrders(orders);

                    textName.setText("");
                    textSurname.setText("");


                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(addOrders);

        back=new JButton("BACK");
        back.setBounds(360,400,120,50);
        back.setForeground(black);
        back.setBackground(gray);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.frame.addOrders.setVisible(false);
                User.frame.listPage.setVisible(false);
                User.frame.menu.setVisible(true);
                User.frame.repaint();
            }
        });
        add(back);
    }
}

