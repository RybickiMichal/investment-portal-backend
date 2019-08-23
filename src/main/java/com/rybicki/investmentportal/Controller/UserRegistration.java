package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.User;
import com.rybicki.investmentportal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserRegistration {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/users/register")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(new String(Base64.getDecoder().decode(user.getPassword())));
        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), "USER", "");
        userService.addNewUser(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(user.getUsername()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/users/{username}")
    public boolean checkUsername(@PathVariable String username) {
        return userService.userExists(username);
    }

}

