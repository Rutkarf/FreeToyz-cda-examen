package com.api.freetoyz.controller.dto; // Declaración del paquete donde se encuentra la clase

import org.springframework.security.core.userdetails.UserDetails;


public class AuthResponseDto {
    private UserDetails user; // Declaración de un campo para almacenar los detalles del usuario autenticado
    private String token; // Declaración de un campo para almacenar el token de autenticación

    // Constructor de la clase que recibe los detalles del usuario y el token como parámetros
    public AuthResponseDto(UserDetails user, String token) {
        this.user = user;   // Inicialización del campo de detalles del usuario
        this.token = token; // Inicialización del campo de token
    }

    // Método getter para obtener los detalles del usuario
    public UserDetails getUser() {
        return user;
    }

    // Método setter para establecer los detalles del usuario
    public void setUser(UserDetails user) {
        this.user = user;
    }

    // Método getter para obtener el token de autenticación
    public String getToken() {
        return token;
    }

    // Método setter para establecer el token de autenticación
    public void setToken(String token) {
        this.token = token;
    }
}
