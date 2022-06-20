package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<UserDto> getUsersFromExternalApi() {
        RestTemplate restTemplate =new RestTemplate();
        UserDto[] userDtos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", UserDto[].class);
        return Arrays.stream(userDtos).toList();
    }
}
