package com.api.freetoyz.repository.carousel;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

@AllArgsConstructor
@Entity
public class CarouselToyzRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="cotation")
    private String cotation;
    @Column(name="quantite")
    private String quantite;
    @Column(name="picture")
    private String picture;
    public CarouselToyzRepositoryModel() {
    }

    public CarouselToyzRepositoryModel(String name, String description, String cotation , String quantite , String picture) {
        this.name = name;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }



}