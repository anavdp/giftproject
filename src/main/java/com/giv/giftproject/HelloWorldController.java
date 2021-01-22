package com.giv.giftproject;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public String helloWorld() {
        //llamar al servicio
        final User user = userService.buscarUsuario(1);

        return "helloWorld";
    }
}