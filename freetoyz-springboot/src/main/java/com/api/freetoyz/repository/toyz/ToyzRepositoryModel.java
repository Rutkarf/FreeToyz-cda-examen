package com.api.freetoyz.repository.toyz;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;


@Entity
@NoArgsConstructor

@Getter
@Setter
@Table(name="toys")
public class ToyzRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @Column(name="categories")
    private String categories;
    @Column(name="description")
    private String description;
    @Column(name="cotation")
    private String cotation;
    @Column(name="quantite")
    private String quantite;
    @Column(name="picture")
    private String picture;

    public ToyzRepositoryModel(int id, String name, String Categories, String description, String cotation, String quantite, String picture) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }

    public ToyzRepositoryModel(String name, String Categories, String description, String cotation, String quantite, String picture) {
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }
}
