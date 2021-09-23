package ch.zli.m223.addressbook.service;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.RequestScoped;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@RequestScoped
public class AuthService {

    public String generateValidJwtToken(String username){
        return Jwt.issuer("https://zli.ch/issuer")
                .upn(username)
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2001-07-13")
                .expiresIn(Duration.ofHours(1))
                .sign();
    }
}
