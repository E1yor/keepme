package uz.wiut.keepme.service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import uz.wiut.keepme.config.JwtConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import javax.security.auth.message.AuthException;

public class TokenHelperImpl implements TokenHelper {

    private final JwtConfig jwtConfig;

    public TokenHelperImpl(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public String generate(String sessionId) {
        return
                Jwts.builder().setClaims(new HashMap<String, Object>()).setSubject(sessionId).setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpireTime() * 1000))
                        .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();
    }

    @Override
    public String retrieveToken(String authorizationHeader) throws Exception {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        throw new Exception("Authorization token not found.");
    }

    @Override
    public String retrieveSessionId(String token) throws Exception {
        if (isExpired(token)) {
            throw new Exception("Token expired.");
        }
        return retrieveClaimFromToken(token, Claims::getSubject);
    }

    @Override
    public String generateRefreshToken(String sessionId) {
        return Jwts.builder().setClaims(new HashMap<>()).setSubject(sessionId).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpireTimeRefresh() * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();
    }

    @Override
    public String retrieveRefreshSessionId(String refreshToken) throws Exception {
        if (isExpired(refreshToken)) {
            throw new AuthException("Token expired.");
        }
        return retrieveClaimFromToken(refreshToken, Claims::getSubject);
    }

    private Boolean isExpired(String token) {
        final Date expiration = retrieveExpireTime(token);
        if (expiration != null) {
            return expiration.before(new Date());
        }
        return true;
    }

    private Date retrieveExpireTime(String token) {
        try {
            return retrieveClaimFromToken(token, Claims::getExpiration);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private <T> T retrieveClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody());
    }

}