package com.example.microservices.controller;

import com.example.microservices.entity.User;
import com.example.microservices.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }
    
    @PutMapping("{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @PatchMapping("{id}/restored")
    public User restore(@PathVariable Long id){
        return userService.restore(id);
    }
}
