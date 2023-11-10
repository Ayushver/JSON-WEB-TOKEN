package com.example.JWT.service;

import com.example.JWT.model.User;
import com.example.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username (email in your case)
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username Not found: " + username));

        // Create and return UserDetails based on the user
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), // You can use email as the username
                user.getPassword(),
                user.getAuthorities()
        );
    }
}
