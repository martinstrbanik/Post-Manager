package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.model.User;
import com.strbanik.PostManager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping(value = "/addUser")
    public void addPost(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
