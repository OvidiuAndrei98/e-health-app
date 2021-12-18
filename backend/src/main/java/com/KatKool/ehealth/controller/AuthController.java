package com.KatKool.ehealth.controller;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.login.LoginRequestDto;
import com.KatKool.ehealth.model.login.LoginResponseDto;
import com.KatKool.ehealth.security.JwtTokenService;
import com.KatKool.ehealth.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final DoctorService doctorService;
    private String password;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, DoctorService doctorService) throws BadCredentialsException {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.doctorService = doctorService;
    }

    @PostMapping("/sign-in/doctor")
    public ResponseEntity<?> userSignIn(@RequestBody LoginRequestDto data) {
        try {
            if (doctorService.existByUsername(data.getUsername())) {
                return ResponseEntity.ok(getResponseDto(data));
            }
            throw new BadCredentialsException("Invalid username/password");
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping("/register-doctor")
    public ResponseEntity<?> registerUser(@RequestBody @Valid Doctor doctor) {
        if (doctorService.existByUsername(doctor.getUsername())) {
            return ResponseEntity.badRequest().body("An account with this email already exists.");
        }
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorService.save(doctor);
        return ResponseEntity.ok("User has been registered successfully.");
    }

    public LoginResponseDto getAccountType(String email, String token, List<String> roles) {
        LoginResponseDto loginResponseDto;

        loginResponseDto = new LoginResponseDto(doctorService.findByUsername(email).getId(), roles, token, email);

        return loginResponseDto;
    }

    public LoginResponseDto getResponseDto(LoginRequestDto data) {
        String email = data.getUsername();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, data.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        password = authenticationToken.getCredentials().toString();
        List<String> roles = ((Authentication) authentication).getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String token = jwtTokenService.createToken(email, roles);

        return getAccountType(email, token, roles);
    }
}
