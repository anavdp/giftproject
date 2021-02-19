package com.giv.giftproject;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;
import com.giv.giftproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/signup")
    public String userForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "newUser";
    }

    @GetMapping(value="/user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id, Model model) {
        final User user = userService.searchUser(id);
        model.addAttribute("title", "User");
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value="/users")
    public String createUser(@ModelAttribute @Valid UserDTO user, Model model) {
        userService.createUser(user);
        model.addAttribute("title", "User");
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping(value="/users")
    public String getuserList(Model model) {
        final List<User> userList = userService.searchUsers();
        model.addAttribute("users", userList);
        return "users";
    }

}