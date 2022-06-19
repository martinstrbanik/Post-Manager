package com.strbanik.PostManager.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PostDto {
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    private String body;
    @NotNull
    private int userId;
}
