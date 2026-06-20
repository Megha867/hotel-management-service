package com.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
public class JwtUtil {

    private static String SECRET= "a8df73hF9s9s8df9sdf89sdf89sdf98sdf98sd";

    public static Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
