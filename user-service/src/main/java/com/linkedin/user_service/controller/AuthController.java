package com.linkedin.user_service.controller;

import com.linkedin.user_service.dto.LoginRequestDto;
import com.linkedin.user_service.dto.SignupRequestDto;
import com.linkedin.user_service.dto.UserDto;
import com.linkedin.user_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> signUp(@RequestBody SignupRequestDto signupRequest)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signupRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDto));
    }

}
