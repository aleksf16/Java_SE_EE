package com.example.api1.cart;

import com.example.api1.item.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Cart {


    @Id
    private String id;

    private String userId;
    private String userName;
    private String userSurname;

    private String[] itemsId;

    private int count;


    public String[] getItemsId() { return itemsId; }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setItemsId(String[] itemsId) { this.itemsId = itemsId;}

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

