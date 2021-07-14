package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private userRepository userRepository;

    @PostMapping("user")
    public void addUser(@RequestBody final List<user> users)
    {
        userRepository.saveAll(users);
    }

    @GetMapping("users")
    public List<user> findUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("user/{userId}")
    public user findUser(@PathVariable final String userId)
    {
        return userRepository.findById(userId).orElseGet(user::new);
    }

    @DeleteMapping("users/delete/{userId}")
    public void deleteById(@PathVariable final String userId)
    {
        userRepository.deleteById(userId);
    }


}
