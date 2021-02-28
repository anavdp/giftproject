package com.giv.giftproject.controllers;

import javax.validation.Valid;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;
import com.giv.giftproject.services.Converter;
import com.giv.giftproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter converter;

    @GetMapping(value="/signup")
    public String userForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "newUser";
    }

    @PostMapping(value="/newUser")
    public String createUser(@ModelAttribute @Valid UserDTO userDTO, Model model) {
        User user = converter.convertDTOtoEntity(userDTO);
        user = userService.createUser(user);
        userDTO = converter.convertEntityToDTO(user);
        model.addAttribute("title", "User");
        model.addAttribute("user", userDTO);
        return "login";
    }

    @GetMapping(value="/users")
    public String getUserList(Model model) {
        final List<User> userList = userService.searchUsers();
        List<UserDTO> userDTOs = userList.stream()
            .map(user -> converter.convertEntityToDTO(user))
            .collect(Collectors.toList());
        model.addAttribute("users", userDTOs);
        return "users";
    }

}