package com.apiboard.handler;

import io.jsonwebtoken.*;

import java.util.Date;


public class JwtHandler {
    private String type ="Bearer";

    public String createToken(String encodeKey, String subject, long maxAgeSeconds){
        Date now = new Date();
        return type + Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+ maxAgeSeconds*1000L))
                .signWith(SignatureAlgorithm.ES256,encodeKey)
                .compact();
    }
   public String extractSubject(String encodeedKey, String token){
        return parse(encodeedKey, token).getBody().getSubject();
   }

   public boolean vaildate(String encodedKey, String token){
        try{
            parse(encodedKey, token);
            return  true;
        }catch(JwtException e)(
                return false;

        )
   }
   private Jws<Claims> parse(String key, String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(untype(token))
   }


   private String untype(String token){
        return token.substring(type.length());
   }
}

