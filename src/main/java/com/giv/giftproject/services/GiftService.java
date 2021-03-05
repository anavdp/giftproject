package com.giv.giftproject.services;

import java.util.List;

import com.giv.giftproject.domain.model.Gift;
import com.giv.giftproject.domain.model.dto.GiftDTO;

public interface GiftService {
    
    Gift createGift(GiftDTO gift);

    List<Gift> searchGifts();
}
