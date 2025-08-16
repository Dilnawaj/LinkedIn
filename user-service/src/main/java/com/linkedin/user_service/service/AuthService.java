package com.linkedin.user_service.service;

import com.linkedin.user_service.config.PasswordConfig;
import com.linkedin.user_service.dto.LoginRequestDto;
import com.linkedin.user_service.dto.SignupRequestDto;
import com.linkedin.user_service.dto.UserDto;
import com.linkedin.user_service.entity.User;
import com.linkedin.user_service.exception.CustomException;
import com.linkedin.user_service.repo.UserRepo;
import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepo userRepo;

    private final JwtService jwtService;

    private  final ModelMapper modelMapper;
    public UserDto signup(SignupRequestDto signupRequest) {

        boolean userExists = userRepo.existsByEmail( signupRequest.getEmail());

        if(userExists)
        {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "User already exists cannot signup");
        }

        User user= modelMapper.map(signupRequest, User.class);
   user.setPassword(PasswordConfig.hashPassword(signupRequest.getPassword()));

   return this.modelMapper.map(userRepo.save(user),UserDto.class);

    }

    public String login(LoginRequestDto loginRequestDto) {
User user = userRepo.findByEmail( loginRequestDto.getEmail()).orElseThrow(()->  new CustomException(HttpStatus.NOT_FOUND.value(), "User not found"));

boolean isPasswordMatched = PasswordConfig.checkPassword(loginRequestDto.getPassword(),user.getPassword());

        if(!isPasswordMatched)
        {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(),"incorrect password");
        }



return jwtService.generateAccessToken(user);
    }
}
