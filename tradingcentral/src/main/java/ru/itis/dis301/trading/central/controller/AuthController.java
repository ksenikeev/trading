package ru.itis.dis301.trading.central.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis301.trading.central.config.AuthenticationRequest;
import ru.itis.dis301.trading.central.config.AuthenticationResponse;
import ru.itis.dis301.trading.central.model.User;

@RestController
public class AuthController {

    @Value("${jwt.secret}")
    private String SECRET;

    @PostMapping("/login")
    public ResponseEntity<?> authentificateByUserNameAndPassword(
            @RequestBody AuthenticationRequest authenticationRequest) {
        // validate user
        System.out.println("validate");

        User user = User.builder()
                .username("admin")
                .password("admin")
                .role("admin")
                .build();

        String token = JWT.create()
                .withSubject(user.getUsername())
                .withClaim("role", user.getRole())
                .sign(Algorithm.HMAC256(SECRET));

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(token,"");

        return ResponseEntity.ok(authenticationResponse);
    }
}
