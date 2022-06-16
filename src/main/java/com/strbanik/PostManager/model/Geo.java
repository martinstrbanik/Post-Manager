package com.strbanik.PostManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Geo {

    private String lat;
    private String lng;

}
