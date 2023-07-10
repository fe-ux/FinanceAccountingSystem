package com.aleynik.managementservice.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.UUID;

@Component
public class JwtUtils {
    @Value("${thisapp.app.jwtSecret}")
    private String jwtSecret;

    @Value("${thisapp.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public Boolean checkAdmin(HttpHeaders headers) {
        String token = headers.get("Authorization").get(0).substring("Bearer ".length());
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().get("role").toString().equals("ROLE_ADMIN");
    }

    public UUID getUUID(HttpHeaders headers) {
        String token = headers.get("Authorization").get(0).substring("Bearer ".length());
        return UUID.fromString(Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getId());
    }
}
