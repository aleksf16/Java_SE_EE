package cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class cartController {


    @Autowired
    private cartRepository cartRepository;

    @PostMapping("cart")
    public void addCart(@RequestBody final List<cart> carts)
    {

        cartRepository.saveAll(carts);
    }

    @GetMapping("carts")
    public List<cart> findCarts()
    {
        return cartRepository.findAll();
    }

    @GetMapping("carts/{cartId}")
    public cart findCart(@PathVariable final String cartId)
    {
        return cartRepository.findById(cartId).orElseGet(cart::new);

    }

    @DeleteMapping("carts/delete/{cartId}")
    public void deleteById(@PathVariable final String cartId)
    {
        cartRepository.deleteById(cartId);
    }
}
