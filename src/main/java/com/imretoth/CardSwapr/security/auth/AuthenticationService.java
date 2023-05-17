package com.imretoth.CardSwapr.security.auth;

import com.imretoth.CardSwapr.security.service.JwtService;
import com.imretoth.CardSwapr.security.user.Role;
import com.imretoth.CardSwapr.security.user.User;
import com.imretoth.CardSwapr.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest regRequest) {
        // create user
        User user = new User(
                regRequest.getFirstName(),
                regRequest.getLastName(),
                regRequest.getEmail(),
                passwordEncoder.encode(regRequest.getPassword()),
                Role.USER
        );
        // save to db
        userRepository.save(user);
        // return generated token
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        return null;
    }
}
