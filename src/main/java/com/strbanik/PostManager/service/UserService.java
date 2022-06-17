package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<UserDto> getAllUsers();
    List<UserDto> getUserFromExternalApi();

}
