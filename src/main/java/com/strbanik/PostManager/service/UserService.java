package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsersFromExternalApi();

}
