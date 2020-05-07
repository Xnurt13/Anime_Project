package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;



public class NewsPostGUI extends Container{
    JLabel addpost = new JLabel("Add post:");
    JLabel ltitle = new JLabel("title:");
    JTextField titletext = new JTextField("");
    JLabel lcontent = new JLabel("content:");
    JTextArea contenttext = new JTextArea("");
    JButton postBTN = new JButton("Add");
    JButton backBTN = new JButton("Back");



    public NewsPostGUI(){
        setLayout(null);
        setSize(700,700);


        addpost.setBounds(250, 15, 200, 30);
        add(addpost);

        ltitle.setBounds(30, 50, 80, 20);
        add(ltitle);
        titletext.setBounds(130, 50, 100, 20);
        add(titletext);


        lcontent.setBounds(30, 80, 80, 20);
        add(lcontent);
        contenttext.setBounds(130, 80, 200, 200);
        add(contenttext);

        backBTN.setBounds(250 , 390 , 150 , 30);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                Admin.frame.menu.setVisible(true);
            }
        });
        add(backBTN);

        postBTN.setBounds(250,340,150,30);
        postBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String titleStr = titletext.getText() ;
                String contextStr = contenttext.getText();
                if (titleStr.equals("")||contextStr.equals(""))
                    titletext.setText("empty post");
                else {
                    NewsPost temp = new NewsPost(titleStr, contextStr);
                    Admin.addNewsPost(temp);
                    titletext.setText("");
                    contenttext.setText("");
                }
            }
        });
        add(postBTN);
    }
}


