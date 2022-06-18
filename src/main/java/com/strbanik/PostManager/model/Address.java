package com.strbanik.PostManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address {

    @NotBlank
    private String street;
    @NotBlank
    private String suite;
    @NotBlank
    private String city;
    @NotBlank
    private String zipcode;

    @Embedded
    @Valid
    private Geo geo;

}
