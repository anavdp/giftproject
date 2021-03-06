package com.giv.giftproject.services;

import java.util.List;

import com.giv.giftproject.domain.model.Gift;
import com.giv.giftproject.repositories.GiftRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImpl implements GiftService {
    
    @Autowired
    private GiftRepository giftRepository;

    @Override
    public Gift createGift(Gift gift) {
        return giftRepository.save(gift);
    }

    @Override
    public List<Gift> searchGifts() {
        return (List<Gift>) giftRepository.findAll();
    }
}
