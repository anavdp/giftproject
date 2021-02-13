package com.giv.giftproject.repositories;

import com.giv.giftproject.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Integer> {

	@Query("from User u where u.email = :email")
	User findByEmail(@Param("email") String email);

}
