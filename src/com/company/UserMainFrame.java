package com.company;

import javax.swing.*;
public class UserMainFrame extends JFrame {
    public UserAddPage addOrders;
    public UserMainMenu menu;
    public UserRegistr regitr;
    public UserListPage listPage;
    public UserAdd addUser;
    public UserPostPage checkPost;


    public UserMainFrame(){
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new UserMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addUser = new UserAdd();
        addUser.setLocation(0, 0);
        addUser.setVisible(true);
        add(addUser);

        listPage = new UserListPage();
        listPage.setLocation(0, 0);
        listPage.setVisible(false);
        add(listPage);


        regitr=new UserRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        addOrders = new UserAddPage();
        addOrders.setLocation(0,0);
        addOrders.setVisible(false);
        add(addOrders);

        checkPost = new UserPostPage();
        checkPost.setLocation(0,0);
        checkPost.setVisible(false);
        add(checkPost);

        repaint();
    }
}
