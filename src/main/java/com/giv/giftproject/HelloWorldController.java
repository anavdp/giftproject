package com.giv.giftproject;
import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public String helloWorld() {
        return "helloWorld";
    }

    
  @GetMapping(value="/user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id, Model model) {
        final User user = userService.buscarUsuario(id);
        model.addAttribute("title", "Usuario");
        model.addAttribute("user", user);
        return "user";
    }


}