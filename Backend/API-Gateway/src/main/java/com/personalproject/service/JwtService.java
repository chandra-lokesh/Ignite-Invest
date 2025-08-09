package com.personalproject.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    private SecretKey getKey() {
        System.out.println("entered getKey()");
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractEmail(String token) {
        // extract the username from jwt token
        System.out.println("entered extractEmail()");
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        System.out.println("entered extractClaim()");
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        System.out.println("entered extractAllClaims()");
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token) {
        final String userName = extractEmail(token);
        return (!isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        System.out.println("entered isTokenExpired()");
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        System.out.println("entered extractExpiration()");
        return extractClaim(token, Claims::getExpiration);
    }
}
