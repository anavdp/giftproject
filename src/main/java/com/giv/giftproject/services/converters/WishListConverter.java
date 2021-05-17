package com.giv.giftproject.services.converters;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.WishList;
import com.giv.giftproject.domain.model.dto.WishListDTO;
import com.giv.giftproject.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishListConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    public WishList convertDTOtoEntity(WishListDTO wishListDTO){
        WishList wishList = modelMapper.map(wishListDTO, WishList.class);
        User user = userService.searchUser(wishListDTO.getIdUser());
        wishList.getUsers().add(user);
        return wishList;
    }

}
