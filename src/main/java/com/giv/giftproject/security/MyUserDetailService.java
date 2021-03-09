package com.giv.giftproject.security;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.repositories.UserRepository;
import com.giv.giftproject.services.converters.UserConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return converter.convertEntityToDTO(user);
    }

}