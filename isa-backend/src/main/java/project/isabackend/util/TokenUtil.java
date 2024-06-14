package project.isabackend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtil {
    @Value("isa-app")
    private String APP_NAME;

    @Value("isaSecret")
    private String SECRET;

    @Value("1800000")
    private int EXPIRES_IN;
    @Value("Authorization")
    private String AUTH_HEADER;

    private static final String AUDIENCE_WEB = "web";

    public String getTokenFromCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, APP_NAME);
        if (cookie == null) {
            return null;
        } else {
            return cookie.getValue();
        }
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !getExpirationDate(token).before(new Date()));
    }

    public ResponseCookie getCookie(UserDetails userPrincipal) {
        String jwt = generateToken(userPrincipal.getUsername());
        return ResponseCookie.from(APP_NAME, jwt).path("").maxAge(24 * 60 * 60).httpOnly(true).build();
    }

    public ResponseCookie getCleanCookie() {
        return ResponseCookie.from(APP_NAME, null).path("").build();
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public Date getExpirationDate(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getExpiration();
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setIssuer(APP_NAME)
                .setAudience(AUDIENCE_WEB)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRES_IN))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}

