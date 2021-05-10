package com.giv.giftproject.controllers;

import com.giv.giftproject.security.AuthenticationRequest;
import com.giv.giftproject.security.JwtService;
import com.giv.giftproject.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtService jwtService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String createToken(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        final AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        } catch (Exception e) {
            throw new Exception("Invalid authentication", e);
        }
        UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.createToken(userDetails);
        Cookie cookie = new Cookie("access-token", token); // name and value of the cookie
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "home";
    }

    @RequestMapping("/principal")
    public String toPrincipal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }

}