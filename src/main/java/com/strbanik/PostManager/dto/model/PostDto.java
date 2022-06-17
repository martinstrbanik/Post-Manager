package com.strbanik.PostManager.dto.model;

import com.strbanik.PostManager.model.Address;
import com.strbanik.PostManager.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PostDto {
    private int id;
    private String title;
    private String body;
    private int userId;
}
