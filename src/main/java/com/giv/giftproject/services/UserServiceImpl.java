package com.giv.giftproject.services;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User buscarUsuario(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
