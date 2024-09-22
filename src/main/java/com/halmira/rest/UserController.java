package com.halmira.rest;

import com.halmira.model.User;
import com.halmira.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PatchMapping("/{id}/lock")
    public ResponseEntity<String> lockUserProfile(@PathVariable Long id, @RequestParam boolean lock)
    {
        userService.lockUserProfile(id, lock);
        return ResponseEntity.ok("User profile visibility updated");
    }



}