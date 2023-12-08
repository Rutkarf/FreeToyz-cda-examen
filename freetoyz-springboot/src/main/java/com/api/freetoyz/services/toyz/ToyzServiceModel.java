package com.api.freetoyz.services.toyz;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor

public class ToyzServiceModel {

    private Optional<Long> id;

    private String name;

    private String description;
    private String cotation;
    private String quantite;
    private String picture;

    public ToyzServiceModel(Optional id, String name, String description, String cotation, String quantite, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ToyServiceModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantite='" + quantite + '\'' +
                ", cotation='" + cotation + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
