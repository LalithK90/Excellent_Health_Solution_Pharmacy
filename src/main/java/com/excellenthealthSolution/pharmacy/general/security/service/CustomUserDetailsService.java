package com.excellenthealthSolution.pharmacy.general.security.service;

        import com.excellenthealthSolution.pharmacy.general.security.CustomUserDetails;
        import com.excellenthealthSolution.pharmacy.general.security.entity.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByUserName(username);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        return optionalUser
                .map(CustomUserDetails::new).get();

    }
}
