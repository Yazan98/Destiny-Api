package com.yazan98.destiny.server.config;

import com.yazan98.destiny.server.data.entity.user.Profile;
import com.yazan98.destiny.server.error.TokenErrorDetails;
import com.yazan98.destiny.server.service.UserService;
import com.yazan98.destiny.server.utils.JwtTokenUtil;
import io.jsonwebtoken.*;
import io.vortex.spring.boot.base.errors.ErrorDetails;
import io.vortex.spring.boot.base.errors.VortexAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 2:46 PM
 */

@Component
public class JwtTokenProvider {

    private String secretKey = "YT98";
    private long validityInMilliseconds = new Date(2022 , 1 , 1).getTime();
    private final UserService userDetailsService;

    @Autowired
    public JwtTokenProvider(UserService service) {
        this.userDetailsService = service;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Profile account) {
        Claims claims = Jwts.claims().setSubject(account.getUsername());

        claims.put("typ" ,  "JWT");
        claims.put("name" , account.getUsername());
        claims.put("activated" , account.getEnabled());
        claims.put("enabled" , true);
        claims.put("expired" , false);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return new JwtTokenUtil().getUsernameFromToken(token);
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) throws VortexAuthException {
        return new JwtTokenUtil().validateToken(token , userDetailsService);
    }

}