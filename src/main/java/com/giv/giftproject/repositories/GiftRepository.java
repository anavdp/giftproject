package com.giv.giftproject.repositories;

import com.giv.giftproject.domain.model.Gift;
import org.springframework.data.repository.CrudRepository;

public interface GiftRepository extends CrudRepository<Gift, Integer> {
}
