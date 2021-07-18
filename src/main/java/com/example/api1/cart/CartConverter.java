package com.example.api1.cart;

import com.example.api1.item.Item;

import java.util.List;

public class CartConverter {

    public static CartDTO convertModelToDTO(Cart cart , List<Item> items) {

        return new CartDTO(cart.getId(),
                cart.getUserId(),
                cart.getUserName(),
                cart.getUserSurname(),
                items,
                cart.getCount());
    }
}
