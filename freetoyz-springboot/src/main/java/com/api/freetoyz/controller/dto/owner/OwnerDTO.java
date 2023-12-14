package com.api.freetoyz.controller.dto.owner;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class OwnerDTO {
    private String username;
    private String password;
    private String pseudo;
    private String location;
    private String description;
    private String adresse;
    private MultipartFile profil_picture;

}

