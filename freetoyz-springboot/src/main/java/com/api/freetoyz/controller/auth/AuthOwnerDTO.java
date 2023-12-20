package com.api.freetoyz.controller.auth;

import lombok.Data;

@Data
public class AuthOwnerDTO {

        private String Password;
        private String Email;
        private String Location;
        private String Telephone;
        private String Description;
        private String ProfilPicture;
        private String Adresse;
}
