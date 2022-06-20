package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.model.User;
import com.strbanik.PostManager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    // Only used for testing
    @PostMapping(value = "/addUser")
    public void addPost(@Valid @RequestBody User user){
        userService.addUser(user);
    }

    // Only used for testing
    @GetMapping(value = "/getAllUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }



}
