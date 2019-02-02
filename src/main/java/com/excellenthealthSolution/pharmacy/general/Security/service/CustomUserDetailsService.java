package com.excellenthealthSolution.pharmacy.general.Security.service;

import com.excellenthealthSolution.pharmacy.general.Security.CustomUserDetails;
import com.excellenthealthSolution.pharmacy.general.Security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByUserName(username);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        return optionalUser
                .map((User t) -> new CustomUserDetails(t)).get();

    }
}
