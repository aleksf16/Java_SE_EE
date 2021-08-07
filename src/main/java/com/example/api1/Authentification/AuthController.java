package com.example.api1.Authentification;

import com.example.api1.user.User;
import com.example.api1.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthController {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    @Autowired
    public AuthController(JwtProvider jwtProvider, UserService userService) {
        this.jwtProvider = jwtProvider;
        this.userService = userService;
    }

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("auth")
    public AuthResponse auth(@RequestBody AuthRequest request){
        User userEntity = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUsername());
        return new AuthResponse(token);
    }
}
