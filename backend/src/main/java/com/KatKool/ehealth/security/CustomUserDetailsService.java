package com.KatKool.ehealth.security;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

    @Component
    public class CustomUserDetailsService implements UserDetailsService {
        private final DoctorService doctorService;

        @Autowired
        public CustomUserDetailsService(DoctorService doctorService) {
            this.doctorService = doctorService;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            if (doctorService.existByUsername(username)) {
                Doctor user = doctorService.findByUsername(username);
                return new User(user.getUsername(), user.getPassword(), user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList()));
            }
            return null;
        }
    }
