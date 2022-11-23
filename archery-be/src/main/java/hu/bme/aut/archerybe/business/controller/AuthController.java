package hu.bme.aut.archerybe.business.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.aut.archerybe.config.jwt.JwtUtils;
import hu.bme.aut.archerybe.config.services.UserDetailsImpl;
import hu.bme.aut.archerybe.datamodel.dto.LoginRequest;
import hu.bme.aut.archerybe.datamodel.dto.SignupRequest;
import hu.bme.aut.archerybe.datamodel.entity.Authority;
import hu.bme.aut.archerybe.datamodel.entity.User;
import hu.bme.aut.archerybe.datamodel.entity.enums.Role;
import hu.bme.aut.archerybe.datamodel.repository.UserRepository;
import hu.bme.aut.archerybe.datamodel.response.JwtResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new ResponseEntity<>(
                new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles),
                HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.username())) {
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        } else if (userRepository.existsByEmail(signupRequest.email())) {
            return new ResponseEntity<>("Error: Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        User user = new User(
                signupRequest.username(),
                signupRequest.email(),
                passwordEncoder.encode(signupRequest.password()));

        Set<String> strRoles = signupRequest.roles();
        Set<Authority> authorities = new HashSet<>();

        if (strRoles == null) {
            authorities.add(new Authority(Role.ROLE_USER));
        } else {
            strRoles.forEach(role -> {
                if (role.equals("admin")) {
                    authorities.add(new Authority(Role.ROLE_ADMIN));
                } else {
                    authorities.add(new Authority(Role.ROLE_USER));
                }
            });
        }

        user.setAuthorities(authorities);
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
