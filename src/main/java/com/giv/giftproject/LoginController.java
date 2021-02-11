package com.giv.giftproject;

import com.giv.giftproject.security.AuthenticationRequest;
import com.giv.giftproject.security.AuthenticationResponse;
import com.giv.giftproject.security.JwtService;
import com.giv.giftproject.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtService jwtService;


    @GetMapping(value="/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signin")
    public AuthenticationResponse createToken(@RequestParam Map<String,String> ar) throws Exception {
        final String username = ar.get("username");
        final String password = ar.get("password");
        final AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }
        UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.createToken(userDetails);
        return new AuthenticationResponse(token);
    }
}