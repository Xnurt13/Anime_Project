package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


import static java.awt.Color.black;
import static java.awt.Color.gray;

public class UserPostPage extends Container {
    JLabel NP = new JLabel("NEW POSTS");
    JLabel lcontent = new JLabel("content:");
    JTextArea contenttext = new JTextArea("");
    JButton postBTN = new JButton("Refresh");
    JButton backBTN = new JButton("Back");
    JTextField comment = new JTextField("");
    JButton commentBTN = new JButton("Comment");
    private JComboBox comboBox;

    ArrayList<Comment> comments = new ArrayList<>();




    public UserPostPage(){
        setLayout(null);
        setSize(700,700);


        NP.setBounds(300, 5, 200, 30);
        NP.setForeground(black);
        NP.setBackground(gray);
        add(NP);

        comboBox = new JComboBox();
        comboBox.setBounds(150 , 30 , 180 , 30);
        comboBox.addActionListener((e)->{
            if(comboBox.getItemCount()!=0) {
                String temp ="\n-------COMMENTS-------\n";
                for (Comment c: comments)
                    temp+=c + "\n";
                contenttext.setText(((NewsPost) comboBox.getSelectedItem()).getContent()+temp);

            }
        });
        add(comboBox);

        lcontent.setBounds(30, 80, 80, 20);
        add(lcontent);
        contenttext.setBounds(130, 80, 440, 200);
        contenttext.setEditable(false);
        add(contenttext);

        comment.setBounds(130,340,440,40);
        add(comment);

        commentBTN.setBounds(30,390,150,30);
        commentBTN.addActionListener((e)->{
            User.addComment(((NewsPost)comboBox.getSelectedItem()).getId(),comment.getText(),User.accaunt);
        });
        add(commentBTN);

        backBTN.setBounds(250 , 490 , 150 , 30);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                User.frame.menu.setVisible(true);
            }
        });
        add(backBTN);

        postBTN.setBounds(250,440,150,30);
        postBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               load();
                }
        });
        add(postBTN);
    }
    private String load(){
        if(comboBox.getItemCount()!=0)
        comboBox.removeAllItems();
        String temp ="";
        ArrayList<NewsPost> tempNews = User.listPosts();
        for (NewsPost n: tempNews){
            comboBox.addItem(n);
            temp+=n.toString()+"\n";
        }
        comments = User.GetComments();
        return temp;
    }
}
