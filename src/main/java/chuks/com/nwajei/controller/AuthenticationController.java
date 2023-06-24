package chuks.com.nwajei.controller;

import chuks.com.nwajei.dto.LoginDto;
import chuks.com.nwajei.dto.RegisterRequestDto;
import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.services.authentication.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<PictureAppResponse<?>> registerUser(@Valid @RequestBody RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(userService.registerUser(registerRequestDto));
    }

    @PostMapping("/admin")
    public ResponseEntity<PictureAppResponse<?>> registerAdmin(@Valid @RequestBody RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(userService.registerAdmin(registerRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<PictureAppResponse<?>> login(@Valid @RequestBody LoginDto login){
        return ResponseEntity.ok(userService.login(login));
    }
}