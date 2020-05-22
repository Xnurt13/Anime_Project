package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Animes> animes;
    ArrayList<Orders> orders;
    ArrayList<UserData> users;
    UserData user;
    Orders order;
    Animes anime;
    Long id;
    Object smth;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Animes> animes, ArrayList<Orders> orders, ArrayList<UserData> users, UserData user, Orders order, Animes anime, Long id) {
        this.operationType = operationType;
        this.animes = animes;
        this.orders = orders;
        this.users = users;
        this.user = user;
        this.order = order;
        this.anime = anime;
        this.id = id;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setAnimes(ArrayList<Animes> animes) {
        this.animes = animes;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public void setUsers(ArrayList<UserData> users) {
        this.users = users;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setAnime(Animes anime) {
        this.anime = anime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Animes> getAnimes() {
        return animes;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public ArrayList<UserData> getUsers() {
        return users;
    }

    public UserData getUser() {
        return user;
    }

    public Orders getOrder() {
        return order;
    }

    public Animes getAnime() {
        return anime;
    }

    public Long getId() {
        return id;
    }

    public Object getSmth() {
        return smth;
    }

    public void setSmth(Object smth) {
        this.smth = smth;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", animes=" + animes +
                ", orders=" + orders +
                ", users=" + users +
                ", user=" + user +
                ", order=" + order +
                ", anime=" + anime +
                ", id=" + id +
                '}';
    }
}
