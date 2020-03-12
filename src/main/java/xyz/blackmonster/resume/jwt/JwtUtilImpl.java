package xyz.blackmonster.resume.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.blackmonster.resume.jwt.contract.JwtUtil;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtilImpl implements JwtUtil {

    private final int expirationTime;
    private final String secret;
    private final String issuer;

	@Autowired
    public JwtUtilImpl(@Value("${jwt.expiration}") int expirationTime, @Value("${jwt.secret}") String secret, @Value("${jwt.issuer}") String issuer) {
        this.expirationTime = expirationTime;
        this.secret = secret;
        this.issuer = issuer;
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        return verifyToken(token).getExpiresAt();
    }

    @Override
    public Claim getClaimFromToken(String token, String name) {
        return verifyToken(token).getClaim(name);
    }
    
    @Override
    public Map<String, Claim> getAllClaimsFromToken(String token) {
	    return verifyToken(token).getClaims();
    }

    @Override
    public String generateToken(String username) {
        Instant expiration = Instant.now().plus(expirationTime, ChronoUnit.MINUTES);

        return JWT.create()
                .withSubject(username)
                .withIssuer(issuer)
                .withExpiresAt(Date.from(expiration))
                .sign(getAlgorithm());
    }

    @Override
    public String getUsernameFromToken(String token) throws JWTDecodeException {
	    return verifyToken(token).getSubject();
    }

    @Override
    public boolean validateToken(String token, String user) {

        final String username = getUsernameFromToken(token);
        return (username.equals(user) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC512(secret);
    }

    private DecodedJWT verifyToken(String token) {
        return JWT.require(getAlgorithm()).build().verify(token);
    }
}