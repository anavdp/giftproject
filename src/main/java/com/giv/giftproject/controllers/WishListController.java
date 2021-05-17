package com.giv.giftproject.controllers;

import javax.validation.Valid;

import com.giv.giftproject.domain.model.dto.WishListDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WishListController {
    public String createWishList(@ModelAttribute @Valid WishListDTO wishlistDTO, Model model) {
        return "";
    }
}