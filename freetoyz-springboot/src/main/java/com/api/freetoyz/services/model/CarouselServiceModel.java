package com.api.freetoyz.services.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CarouselServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cotation")
    private String cotation;
    @Column(name = "quantite")
    private String quantite;
    @Column(name = "picture")
    private String picture;

    public CarouselServiceModel(String name, String description, String cotation, String quantite, String picture) {
        this.name = name;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }

}
