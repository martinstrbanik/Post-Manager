package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.UserMapper;
import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.model.User;
import com.strbanik.PostManager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

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
    }
}
