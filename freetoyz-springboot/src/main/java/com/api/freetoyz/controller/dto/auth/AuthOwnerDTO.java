package com.api.freetoyz.controller.auth;

import lombok.Data;

@Data
public class AuthOwnerDTO {

        private String password;
        private String userName;
        private String location;
        private String telephone;
        private String description;
        private String profilPicture;
        private String adresse;
}
