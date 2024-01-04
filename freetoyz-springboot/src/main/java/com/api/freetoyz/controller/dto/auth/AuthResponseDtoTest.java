package com.api.freetoyz.controller.auth;

import com.api.freetoyz.repository.security.OwnerRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
public class AuthResponseDtoTest {

    private UserDetails user;
    private String token;
}
