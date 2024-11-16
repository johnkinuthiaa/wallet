package com.slippery.wallet.controller;

import com.slippery.wallet.dto.UserDto;
import com.slippery.wallet.models.User;
import com.slippery.wallet.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }
    @PostMapping("/register/user")
    public ResponseEntity<UserDto> registerUser(@RequestBody User userDetails){
        return ResponseEntity.ok(service.registerUser(userDetails));
    }
    @GetMapping("/home")
    public String getHome(){
        return "this is home";
    }
}
