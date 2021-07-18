package com.example.api1.cart;

import com.example.api1.item.Item;

import java.util.List;


public class CartDTO {

    public CartDTO(String id, String userId, String userName, String userSurname, List<Item> items, int count) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.items = items;
        this.count = count;
    }





    private String id;

    private String userId;
    private String userName;
    private String userSurname;

    private List<Item> items;

    private int count;

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }
}

