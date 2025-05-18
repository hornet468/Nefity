package com.nefity.Nefity.Auth;

import com.nefity.Nefity.Auth.dto.JwtAuthenticationDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtService {
    private static final Logger LOGGER = LogManager.getLogger(JwtService.class);
    @Value("db0f924387b9f45bcd487cb98a7a760b487378706079c3f2a9618822283f1a612c35f619290b1094c5abf05b50ea2913fbeb511dbabaa96eae5cd06c21992fcf")
    private String jwtSecret;

    public JwtAuthenticationDto generateAuthToken(String nickname) {
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(nickname));
        jwtDto.setRefreshToken(generateRefreshToken(nickname));
        return jwtDto;
    }

    public JwtAuthenticationDto refreshBaseToken(String nickname, String refreshToken) {
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(nickname));
        jwtDto.setRefreshToken(refreshToken);
        return jwtDto;
    }

    public String getNickNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return  true;
        } catch (ExpiredJwtException expEx) {
            LOGGER.error("Expired JwtException", expEx);
        } catch (UnsupportedJwtException expEx) {
            LOGGER.error("Unsupported JwtException", expEx);
        } catch (MalformedJwtException expEx) {
            LOGGER.error("Malformed JwtException" ,expEx);
        } catch (SecurityException expEx) {
            LOGGER.error("Security Exception" ,expEx);
        } catch (Exception expEx) {
            LOGGER.error("invalid token", expEx);
        }
        return  false;
    }

    public String generateJwtToken(String nickname) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(nickname)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }

    public String generateRefreshToken(String nickname) {
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(nickname)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }


    private SecretKey getSignKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(KeyBytes);
    }


}
