package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.UserMapper;
import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.model.User;
import com.strbanik.PostManager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());

//        List<UserDto> userDtos = new ArrayList<>();
//        userDtos.add(getUserFromExternalApi(25));
//        userDtos.add(getUserFromExternalApi(11));
//        return userDtos;
    }

    @Override
    public UserDto getUserFromExternalApi(int userId) {
        RestTemplate restTemplate =new RestTemplate();
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + userId, UserDto.class);
    }
}
