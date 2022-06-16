package com.strbanik.PostManager.dto.mapper;

import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.model.Address;
import com.strbanik.PostManager.model.Company;
import com.strbanik.PostManager.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setPhone(user.getPhone())
                .setWebsite(user.getWebsite())
                .setAddress(user.getAddress())
                .setCompany(user.getCompany());

    }
}