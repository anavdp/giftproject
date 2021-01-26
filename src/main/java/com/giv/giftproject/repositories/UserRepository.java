package com.giv.giftproject.repositories;

import com.giv.giftproject.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
