package com.strbanik.PostManager.dto.model;

import com.strbanik.PostManager.model.Address;
import com.strbanik.PostManager.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDto {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String website;

    @Valid
    private Address address;

    @Valid
    private Company company;
}
