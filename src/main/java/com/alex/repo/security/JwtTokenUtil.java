package com.alex.repo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String tokenSecret;

    @Value("${jwt.tokenExpirationMsec}")
    private long tokenExpirationMsec;

    public String createToken(Authentication authentication) {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        Date expiryDate = new Date(new Date().getTime()
                + this.getTokenExpirationMsec());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, this.getTokenSecret())
                .compact();
    }

    public String createTokenWithUsername(String username) {
        Date expiryDate = new Date(new Date().getTime()
                + this.getTokenExpirationMsec());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, this.getTokenSecret())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(this.getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser()
                .setSigningKey(this.getTokenSecret())
                .parseClaimsJws(authToken);
            return true;
        } catch (Exception e){
            return false;
        }
//        } catch (SignatureException ex) {
//            log.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
//        }
//        return false;
    }

}
