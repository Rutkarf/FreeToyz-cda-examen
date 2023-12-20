package com.api.freetoyz.services.security;

import com.api.freetoyz.exception.AccountExistsException;
import com.api.freetoyz.repository.security.OwnerRepositoryModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

public interface JwtUserService extends UserService {
    String generateJwtForUser(UserDetails user);

    OwnerRepositoryModel save(String username, String password, String firstName, String lastName, String email, String location, String telephone, String description, String profilPicture, String adresse) throws AccountExistsException;

    UserDetails getUserFromJwt(String jwt);
}
//Remarque : Permet de découpler l'implémentation de la vérification utilisateur avec le JWT, peut-etre mocker dans
//les tests unitaires