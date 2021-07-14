package item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class itemController {

    @Autowired
    private itemRepository itemRepository;

    @PostMapping("item")
    public void addItem(@RequestBody final List<item> items)
    {
        itemRepository.saveAll(items);
    }

    @GetMapping("items")
    public List<item> findItems()
    {
        return itemRepository.findAll();
    }

    @GetMapping("item/{itemId}")
    public item findItem(@PathVariable final String itemId)
    {
        return itemRepository.findById(itemId).orElseGet(item::new);
    }

    @DeleteMapping("items/delete/{itemId}")
    public void deleteById(@PathVariable final String itemId)
    {
        itemRepository.deleteById(itemId);
    }

}
