package com.surveysampling.userservice.service;

import com.surveysampling.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

/**
 * Created by janos_sechna on 3/31/17.
 */
@Service
public class JwtService {

    private static final String ISSUER = "com.surveysampling";

    @Value("${jwt.secretKey:}")
    String secretKey;

    public String tokenFor(User user) {
        Date expiration = Date.from(LocalDateTime.now().plusHours(2).toInstant(UTC));
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
