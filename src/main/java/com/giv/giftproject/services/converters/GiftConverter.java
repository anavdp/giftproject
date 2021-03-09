package com.giv.giftproject.services.converters;

import com.giv.giftproject.domain.model.Gift;
import com.giv.giftproject.domain.model.dto.GiftDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GiftConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public Gift convertDTOtoEntity(GiftDTO giftDTO) {
        return modelMapper.map(giftDTO, Gift.class);
    }

    public GiftDTO convertEntitytoDTO(Gift gift){
        return modelMapper.map(gift, GiftDTO.class);
    }
}
