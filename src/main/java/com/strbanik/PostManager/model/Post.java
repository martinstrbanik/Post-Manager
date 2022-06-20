package com.strbanik.PostManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Post {

    @Id
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    private String body;
    @NotNull
    private int userId;





}
