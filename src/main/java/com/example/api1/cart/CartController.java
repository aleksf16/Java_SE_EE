package com.example.api1.cart;

import com.example.api1.item.ItemRepository;
import com.example.api1.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;


    @PostMapping("carts")
    public void addCart(@RequestBody final List<Cart> cart) {

        cartRepository.saveAll(cart);
    }

    @GetMapping("carts")
    public List<CartDTO> findCarts() {

        return cartService.findAll();
    }

    @GetMapping("carts/{cartId}")
    public CartDTO findCart(@PathVariable final String cartId) {
       return cartService.findById(cartId);
    }

    @DeleteMapping("carts/{cartId}")
    public void deleteById(@PathVariable final String cartId) {
        cartRepository.deleteById(cartId);
    }
}
