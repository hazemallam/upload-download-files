package com.stc.uploaddownloadfiles.service.impl;

import com.stc.uploaddownloadfiles.model.entity.User;
import com.stc.uploaddownloadfiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    private  BCryptPasswordEncoder encoder;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        User user = userRepository.findUserByEmail(username)
                .orElseThrow(()-> new BadCredentialsException("User not found with username: " + username));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .disabled(user.getStatus().ordinal() != 1)
                .accountLocked(user.getStatus().ordinal() != 1)
                .build();

    }
}
