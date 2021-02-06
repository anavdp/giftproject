package com.giv.giftproject.services;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;

public interface UserService {

    User searchUser(int id);

    User createUser(UserDTO user);

}
