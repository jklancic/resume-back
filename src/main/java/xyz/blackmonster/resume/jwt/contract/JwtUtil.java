package xyz.blackmonster.resume.jwt.contract;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;

import java.util.Date;
import java.util.Map;

public interface JwtUtil {
	
	String getUsernameFromToken(String token) throws JWTDecodeException;
	Date getExpirationDateFromToken(String token);
	Claim getClaimFromToken(String token, String name);
	Map<String, Claim> getAllClaimsFromToken(String token);
	String generateToken(String username);
	boolean validateToken(String token, String user);
}