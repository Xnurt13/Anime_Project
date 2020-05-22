/*package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class UserChatPage extends Container {
    JTextArea chat;
    JTextField MessPlace;
    JButton send;
    JButton back;

    public UserChatPage(){
        setLayout(null);
        setSize(900,900);

        chat = new JTextArea();
        chat.setBounds(100,50,400,400);
        chat.setEditable(false);
        add(chat);

        MessPlace = new JTextField();
        MessPlace.setBounds(100,460,400,40);
        add(MessPlace);

        send = new JButton("Send");
        send.setBounds(30,510,150,30);
        send.addActionListener((e)->{
            User.send(MessPlace.getText());
           //chat.setText(User.read());
        });
        add(send);

        back = new JButton("Back");
        back.setBounds(250 , 600 , 150 , 30);
        back.addActionListener((e)->{
            setVisible(false);
            User.frame.menu.setVisible(true);
        });
        add(back);
    }

}
*/