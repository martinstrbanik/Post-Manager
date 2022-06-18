package com.strbanik.PostManager.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String website;

    @Embedded
    @Valid
    private Address address;
    @Embedded
    @Valid
    private Company company;

}
