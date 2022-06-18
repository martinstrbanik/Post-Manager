package com.strbanik.PostManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Company {

    @NotBlank
    @Column( name = "company_name")
    private String name;
    @NotBlank
    private String catchPhrase;
    @NotBlank
    private String bs;
}
