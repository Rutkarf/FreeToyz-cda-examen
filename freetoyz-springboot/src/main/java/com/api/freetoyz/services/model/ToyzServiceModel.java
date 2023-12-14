package com.api.freetoyz.services.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ToyzServiceModel {
    private Optional<Long> id;
    private String name;
    private String categories;
    private String description;
    private String cotation;
    private String quantite;
    private MultipartFile picture;

    public ToyzServiceModel(Long id, String name, String categories, String description, String cotation, String quantite, MultipartFile picture) {
        this.id = Optional.ofNullable(id);
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }

    public ToyzServiceModel(String name, String categories, String description, String cotation, String quantite, MultipartFile picture) {
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }


}
