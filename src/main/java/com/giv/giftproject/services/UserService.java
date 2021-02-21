package com.giv.giftproject.services;

import java.util.List;

import com.giv.giftproject.domain.model.User;

public interface UserService {

    User searchUser(int id);

    User createUser(User user);

    List<User> searchUsers();
}
