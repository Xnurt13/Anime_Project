package com.company;

import javax.lang.model.type.ArrayType;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

public class Server {
    public static Connection connection;

    static ArrayList<String> chat;

    public static void main(String[] args) {
        chat = new ArrayList<String>();
        try{
            connectToDb();
            ServerSocket ss = new ServerSocket(8999);

            while(true){
                System.out.println("waiting for client");
                Socket socket = ss.accept();
                System.out.println("new client connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/animes_project?serverTimezone=UTC",
                            "root",
                            "");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AdMess(String message){
        chat.add(message);
    }
    public static String[] ReadMess(){
        String[] temp = new String[chat.size()];
        for(int i=0; i<chat.size();i++){
            temp[i]=chat.get(i);
        }
        return temp;
    }
}


