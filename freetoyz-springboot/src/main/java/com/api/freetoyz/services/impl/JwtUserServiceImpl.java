package com.api.freetoyz.services.impl;

import com.api.freetoyz.exception.AccountExistsException;
import com.api.freetoyz.repository.security.OwnerRepository;
import com.api.freetoyz.repository.security.OwnerRepositoryModel;
import com.api.freetoyz.services.security.JwtUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class JwtUserServiceImpl implements JwtUserService {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${jwt.signing.key}")
    String signingKey;


    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        OwnerRepositoryModel owner = ownerRepository.findByEmail(username);
        if (owner == null) {
            throw new UsernameNotFoundException("The owner could not be found");
        }
        return owner;
    }

    // USED FOR REGISTRATION

    @Override
    public Authentication authenticate(String username, String password) throws Exception {
        Authentication authentication = new
                UsernamePasswordAuthenticationToken(username, password);
        return authenticationConfiguration.getAuthenticationManager().authenticate(authentication);
    }

    //TODO elle était pas implementée soit tu envoi que username et password soit tu envoie toutes les données
    @Override
    public UserDetails save(String username, String password) throws AccountExistsException {
        UserDetails existingUser = ownerRepository.findByEmail(username);
        if (existingUser != null) {
            throw new AccountExistsException();
        }
        OwnerRepositoryModel owner = new OwnerRepositoryModel();
        owner.setEmail(username);
        owner.setPassword(passwordEncoder.encode(password));
        ownerRepository.save(owner);
        return owner;
    }


    @Override
    public OwnerRepositoryModel save(String username, String password, String firstName, String lastName, String email, String location, String telephone, String description, String profilPicture, String adresse) throws AccountExistsException {
        UserDetails existingUser = ownerRepository.findByEmail(email);
        if (existingUser != null) {
            throw new AccountExistsException();
        }

        OwnerRepositoryModel owner = new OwnerRepositoryModel();
        owner.setPassword(passwordEncoder.encode(password));
        owner.setEmail(email);
        owner.setLocation(location);
        owner.setTelephone(telephone);
        owner.setDescription(description);
        owner.setProfilPicture(profilPicture);
        owner.setAdresse(adresse);


        ownerRepository.save(owner);

        return owner;
    }


    //USED FOR AUTHENTIFICATION

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        System.out.println(signingKey);
        Claims claims =
                Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    @Override
    public String generateJwtForUser(UserDetails user) {
        if (user == null || user.getUsername() == null) {
            // Gérez le cas où user est null
            return null;
        }
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 1000);
        return
                Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, signingKey)
                        .compact();
    }


}
