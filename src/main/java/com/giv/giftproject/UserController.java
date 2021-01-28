package com.giv.giftproject;
import javax.validation.Valid;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;
import com.giv.giftproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id, Model model) {
        final User user = userService.searchUser(id);
        model.addAttribute("title", "Usuario");
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value="/user")
    public String createUser(@RequestBody() @Valid UserDTO user, Model model) {
        userService.createUser(user);
        model.addAttribute("title", "Usuario");
        model.addAttribute("user", user);
        return "user";
    }



}