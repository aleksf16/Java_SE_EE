package com.example.api1.cart;

import com.example.api1.item.Item;
import com.example.api1.item.ItemRepository;
import com.example.api1.item.ItemService;
import com.example.api1.user.User;
import com.example.api1.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemService itemService;

    public CartDTO findById(String cartId) {

        int count = 0;

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Несуществующий Id " + cartId));

        String userId = cart.getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Несуществующий Id " + userId));

        cart.setUserName(user.getName());
        cart.setUserSurname(user.getSurname());

        List<Item> items;

        items = itemService.findItemByCartID(cartId);

        for (Item item : items) {
            count += item.getPrice();
        }
        CartDTO cartDTO = CartConverter.convertModelToDTO(cart, items);
        cartDTO.setCount(count);
        return cartDTO;
    }

    public List<CartDTO> findAll() {
        List<CartDTO> cartDTOs = new ArrayList<>();

        List<Cart> carts = cartRepository.findAll();


        for (Cart cart : carts) {
            int count = 0;

            String userId = cart.getUserId();

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Несуществующий Id " + userId));

            cart.setUserName(user.getName());
            cart.setUserSurname(user.getSurname());

            List<Item> items = itemService.findItemByCartID(cart.getId());
            CartDTO cartDTO = CartConverter.convertModelToDTO(cart, items);

            for (Item item : items) {
                count += item.getPrice();
            }

            cartDTO.setCount(count);
            cartDTOs.add(cartDTO);
        }
        return cartDTOs;
    }
}
