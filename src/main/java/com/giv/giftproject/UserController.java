package com.giv.giftproject;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.dto.UserDTO;
import com.giv.giftproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

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
    public String createUser(@ModelAttribute @Valid UserDTO userDTO, Model model) {
        User user = convertDTOtoEntity(userDTO);
        user = userService.createUser(user);
        userDTO = convertEntityToDTO(user);
        model.addAttribute("title", "User");
        model.addAttribute("user", userDTO);
        return "login";
    }

    public User convertDTOtoEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user.setBirthdate(LocalDate.parse(userDTO.getBirthdate()));
        return user;
    }

    public UserDTO convertEntityToDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        userDTO.setBirthdate(user.getBirthdate().format(dtf));
        return userDTO;
    }
}