package com.giv.giftproject.services;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User searchUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
	public User createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(user.getPassword().getEncryptedPassword());
        user.getPassword().setEncryptedPassword(encryptedPassword);
		return userRepository.save(user);
	}

    @Override
    public List<User> searchUsers() {
        return (List<User>) userRepository.findAll();
    }

}
