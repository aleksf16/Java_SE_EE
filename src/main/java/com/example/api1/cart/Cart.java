package com.example.api1.cart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {


    @Id
    private String id;

    private String userId;

    private String[] itemsId;

    private int count;


    public String[] getItemsId() { return itemsId; }


    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
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

