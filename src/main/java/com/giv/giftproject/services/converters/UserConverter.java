package com.giv.giftproject.services.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.giv.giftproject.domain.model.Password;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public User convertDTOtoEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user.setBirthdate(LocalDate.parse(userDTO.getBirthdate()));
        user.setPassword(new Password(user, userDTO.getPassword()));
        return user;
    }

    public UserDTO convertEntityToDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        userDTO.setBirthdate(user.getBirthdate().format(dtf));
        return userDTO;
    }
}
