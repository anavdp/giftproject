package com.giv.giftproject.services;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;
import com.giv.giftproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User searchUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
	public User createUser(UserDTO dto) {
        User user = new User(
            dto.getName(), 
            dto.getLastname(), 
            dto.getEmail(),
                LocalDate.parse(dto.getBirthdate()),
            dto.getPhoneNumber(), 
            dto.getGender(), 
            dto.getPronoun()
            );
		return userRepository.save(user);
	}



}
