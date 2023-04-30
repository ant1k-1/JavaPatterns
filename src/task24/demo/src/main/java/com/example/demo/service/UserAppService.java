package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserApp;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserAppService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserAppService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        System.out.println("\n\nUsername:"+ username +"\n\n");
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            return new UserApp(optionalUser.get());
        } else {
            throw new UsernameNotFoundException(String.format("Username: %s not found", username));
        }
    }
    @Transactional
    public User singUp(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        System.out.println("!!!!!!!!!!!!!!!!\n\n" + optionalUser + "\n\n");
        if (optionalUser.isEmpty()) {
            String password = user.getPassword();
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("ROLE_USER");
            return userRepository.save(user);
        }
        throw new IllegalStateException(String.format("User with username %s exists", user.getUsername()));
    }
}
