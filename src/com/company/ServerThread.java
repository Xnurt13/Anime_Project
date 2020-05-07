package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Add")) {
                    try {
                        Animes animes = pd.getAnime();
                        addAnimesToDb(animes);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("Add_T")){
                    try {
                        Orders orders= pd.getOrders().get(0);
                        addOrdersToDb(orders);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_N")){
                    try {
                        NewsPost post= (NewsPost) pd.getSmth();
                        addNewsPost(post);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

                else if(pd.getOperationType().equals("Add_com")){
                    try {
                        Comment comm = (Comment)pd.getSmth();
                        addComment(comm);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

                else if (pd.getOperationType().equals("List_Users")) {
                    ArrayList<UserData> users = getAllUsers();
                    PackageData resp = new PackageData();
                    resp.setUsers(users);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("Get_N")) {
                    ArrayList<NewsPost> posts = getAllPosts();
                    PackageData resp = new PackageData();
                    resp.setSmth(posts);
                    outputStream.writeObject(resp);
                }

                else if (pd.getOperationType().equals("Get_Comments")) {
                    ArrayList<Comment> allComments = getAllComments();
                    PackageData resp = new PackageData();
                    resp.setSmth(allComments);
                    outputStream.writeObject(resp);
                }

                else if (pd.getOperationType().equals("List")) {
                    ArrayList<Animes> animes = getAnimes();
                    PackageData resp = new PackageData();
                    resp.setAnimes(animes);
                    outputStream.writeObject(resp);
                }   else if (pd.getOperationType().equals("Add_User")) {
                    try {
                        UserData user = pd.getUser();
                        addUser(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("List_T")){
                    ArrayList<Orders>orders=getOrders();
                    PackageData pd2=new PackageData();
                    pd2.setOrders(orders);
                    outputStream.writeObject(pd2);
                }
                else if (pd.getOperationType().equals("Delete")) {
                    Long id = pd.getId();
                    deleteBookToDB(id);
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Orders> getOrders() {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                orders.add(new Orders(res.getLong("id"), res.getInt("animesId"), res.getString("name"), res.getString("surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }


    public void addUser(UserData user) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO userdata (login, password,telephoneNumber,id) VALUES(?,?,?,NULL)");
            pse.setString(1, user.getLogin());
            pse.setString(2, user.getPassword());
            pse.setString(3, user.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAnimesToDb(Animes animes) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into anime(id,name,time) values(null,?,?)");

            ps.setString(1,animes.getName());
            ps.setString(2,animes.getTime());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<UserData> getAllUsers() {
        ArrayList<UserData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from userdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new UserData(rs.getString("login"), rs.getString("password"),rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NewsPost> getAllPosts() {
        ArrayList<NewsPost> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from newspost");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new NewsPost(rs.getString("title"), rs.getString("content"),rs.getInt("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Comment> getAllComments(){
        ArrayList<Comment> allcomm = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * from comments");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                allcomm.add(new Comment(rs.getInt("post_id"),rs.getString("author"),rs.getString("comment")));
            }
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allcomm;
    }

    public void addNewsPost(NewsPost post){
        try {
            PreparedStatement ps=connection.prepareStatement("insert into newspost(id,title,content) values(null,?,?)");

            ps.setString(1,post.getTitle());
            ps.setString(2,post.getContent());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addComment(Comment comm){
        try {
            PreparedStatement ps=connection.prepareStatement("insert into comments(id,author,post_id,comment) values(null,?,?,?)");

            ps.setString(1,comm.getAuthor());
            ps.setInt(2,comm.getPostId());
            ps.setString(3,comm.getComment());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void addOrdersToDb(Orders orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into orders(id,animesId,name,surname) values(null,?,?,?)");

            ps.setInt(1,orders.getAnimesId());
            ps.setString(2,orders.getName());
            ps.setString(3,orders.getSurname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Animes> getAnimes() {
        ArrayList<Animes> animes = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM anime";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                animes.add(new Animes(res.getLong("id"),res.getString("name"),res.getString("time")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animes;
    }

    public void deleteBookToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM anime WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

