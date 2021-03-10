package com.giv.giftproject.services;

import java.util.List;

import com.giv.giftproject.domain.model.Gift;

public interface GiftService {
    
    Gift createGift(Gift gift);

    List<Gift> searchGifts();
}
