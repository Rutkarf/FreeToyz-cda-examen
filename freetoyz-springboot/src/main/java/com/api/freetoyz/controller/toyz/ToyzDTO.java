package com.api.freetoyz.controller.toyz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToyzDTO {

    private Optional<Long> id;
    private String name;
    private String description;
    private String cotation;
    private String quantite;
    private String picture;


}
