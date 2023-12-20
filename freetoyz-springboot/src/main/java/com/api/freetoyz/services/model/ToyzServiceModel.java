package com.api.freetoyz.services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class ToyzServiceModel {
    private int id;
    private String name;
    private String categories;
    private String description;
    private String cotation;
    private String quantite;
    private MultipartFile picture;

    private String picturePath;

    public ToyzServiceModel(int id, String name, String categories, String description, String cotation, String quantite, MultipartFile picture) {
        this.id = id;
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

    public ToyzServiceModel(int id, String name, String categories, String description, String cotation, String quantite, String picturePath) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picturePath = picturePath;
    }

}
