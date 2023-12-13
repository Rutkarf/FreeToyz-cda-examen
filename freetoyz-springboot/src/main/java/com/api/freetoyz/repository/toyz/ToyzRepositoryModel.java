package com.api.freetoyz.repository.toyz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="toys")
public class ToyzRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Optional id;
    @Column(name="name")
    private String name;

    public ToyzRepositoryModel(String name, String description, String cotation, String quantite, String picture) {
        this.name = name;
        this.description = description;
        this.cotation = cotation;
        this.quantite = quantite;
        this.picture = picture;
    }

    @Column(name="description")
    private String description;
    @Column(name="cotation")
    private String cotation;
    @Column(name="quantite")
    private String quantite;
    @Column(name="picture")
    private String picture;


}
