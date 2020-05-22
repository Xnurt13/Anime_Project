package com.company;


import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public NewsPostGUI post;
    public AdminAddPage add;
    public AdminListPage list;
    public AdminDeletePage deletePage;
    public AdminMainMenu menu;
    public Welcome welcome;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);

        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        welcome = new Welcome();
        welcome.setLocation(0, 0);
        welcome.setVisible(true);
        add(welcome);

        add = new AdminAddPage();
        add.setLocation(0,0);
        add.setVisible(false);
        add(add);


        list = new AdminListPage();
        list.setLocation(0,0);
        list.setVisible(false);
        add(list);

        post = new NewsPostGUI();
        post.setLocation(0,0);
        post.setVisible(false);
        add(post);

        deletePage=new AdminDeletePage();
        deletePage.setLocation(0,0);

        deletePage.setVisible(false);
        add(deletePage);

        repaint();
    }
}

