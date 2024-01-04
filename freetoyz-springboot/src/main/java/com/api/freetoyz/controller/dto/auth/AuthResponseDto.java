package com.api.freetoyz.controller.auth; // Declaración del paquete donde se encuentra la clase

import com.api.freetoyz.repository.security.OwnerRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private OwnerRepositoryModel user;
    private String token;
//    public AuthResponseDto(UserDetails user, String token) {
//        this.user = user;
//        this.token = token;
//    }

}
