package ru.itis.dis301.trading.central.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.dis301.trading.central.model.User;
import ru.itis.dis301.trading.central.service.JwtService;

import java.io.IOException;

@Component("tokenAuthenticationFilter")
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String SECRET;

    @Autowired
    private JwtService jwtService;

    @Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FILTER ");
        HttpServletRequest request = servletRequest;
        // получаем токен
        //Authorization: Bearer <token>
        String bearerToken = request.getHeader("Authorization");
        System.out.println("Authorization: " + bearerToken);

        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            String token = bearerToken.substring(7);

            DecodedJWT decodedJWT;
            try {
                decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                        .build()
                        .verify(token);

                TokenAuthentication authentication = new TokenAuthentication(token);

                authentication.setAuthenticated(true);

                UserDetailsImpl userDetails = new UserDetailsImpl(
                        User.builder()
                                .role(decodedJWT.getClaim("role").asString())
                                .build());
                authentication.setUserDetails(userDetails);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (JWTVerificationException e) {
                //throw new AuthenticationCredentialsNotFoundException("bad jwt token");
            }

        }

        // отправили запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
