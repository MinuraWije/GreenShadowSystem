package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTServiceImpl implements JWTService {
    @Value("${spring.jwtKey}")
    String jwtKey;
    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject );
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return genToken(new HashMap<>(), userDetails);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public String refreshToken(UserDetails userDetails) {
        return refreshToken(new HashMap<>(), userDetails);
    }
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolv){
        final Claims claims = getClaims(token);
        return claimsResolv.apply(claims);
    }
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(getKey()).build().parseClaimsJwt(token).getBody();
    }
    private Key getKey(){
        byte[] decodedJWT = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(decodedJWT);
    }
    private String genToken(Map<String, Object> genClaims, UserDetails userDetails){
        genClaims.put("role",userDetails.getAuthorities());
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000*600);
        return Jwts.builder().setClaims(genClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }
    private String refreshToken(Map<String, Object> genClaimsRefresh, UserDetails userDetails){
        genClaimsRefresh.put("role",userDetails.getAuthorities());
        Date now = new Date();
        Date refreshExpired = new Date(now.getTime() + 1000*600);
        return Jwts.builder().setClaims(genClaimsRefresh)
                .setSubject(userDetails.getUsername())
                .setExpiration(refreshExpired)
                .setIssuedAt(now)
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }
    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
    private Date getExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
}
