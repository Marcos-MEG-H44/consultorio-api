package com.tuapp.consultorio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // CLAVE SECRETA
    private static final String SECRET =
            "miclavesupersecretamiclavesupersecretamiclave";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // GENERAR TOKEN
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // EXTRAER USERNAME
    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    // VALIDAR TOKEN
    public boolean isTokenValid(String token, String username) {

        String user = extractUsername(token);

        return user.equals(username);
    }

    // EXTRAER CLAIMS
    private Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}