package com.giv.giftproject;

import com.giv.giftproject.domain.model.dto.GiftDTO;
import com.giv.giftproject.services.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GiftController {
    
    @Autowired
    private GiftService giftService;

    @GetMapping(value = "/giftForm")
    public String giftForm(Model model) {
        model.addAttribute("gift", new GiftDTO());
        return "newGift";
    }

    @PostMapping(value="/gifts")
    public String createGift(@ModelAttribute GiftDTO gift, Model model) {
        giftService.createGift(gift);
        model.addAttribute("title", "Gifts");
        model.addAttribute("gift", gift);
        return "wishList";
    }
}