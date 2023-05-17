package com.imretoth.CardSwapr.security.auth;

import com.imretoth.CardSwapr.security.service.JwtService;
import com.imretoth.CardSwapr.security.user.Role;
import com.imretoth.CardSwapr.security.user.User;
import com.imretoth.CardSwapr.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // create user
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.USER
        );
        // save to db
        userRepository.save(user);
        // return generated token
        return generateAndReturnToken(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        // if user authenticated, generate token and send it back
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return generateAndReturnToken(user);
    }

    private AuthenticationResponse generateAndReturnToken(User user) {
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
