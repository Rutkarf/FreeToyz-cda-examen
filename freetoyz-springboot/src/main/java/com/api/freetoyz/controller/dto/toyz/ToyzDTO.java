package com.api.freetoyz.controller.dto.toyz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToyzDTO {

    private Optional<Integer> id;
    private String name;
    private String categories;
    private String description;
    private String cotation;
    private String quantite;
    private String picture;

    public ToyzDTO(String name,String categories, String description, String cotation, String quantite, String picture) {
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }
}
