package com.example.api1.item;

import com.example.api1.cart.*;
import com.example.api1.user.User;
import com.example.api1.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;


    public List<Item> findItemByCartID(String cartId)
    {

        List<Item> items = new ArrayList<>();
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Несуществующий Id " + cartId));

        for (String id : cart.getItemsId()) {
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Несуществующий Id " + id));
            items.add(item);
        }

        return items;
    }
}
