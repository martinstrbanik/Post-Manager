package com.strbanik.PostManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Geo {

    @NotBlank
    private String lat;
    @NotBlank
    private String lng;

}
