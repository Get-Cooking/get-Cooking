package com.example.cooking.user;

import com.example.cooking.jwt.JwtService;
import com.example.cooking.user.dto.UserLoginDto;
import com.example.cooking.user.dto.UserRegisterDto;
import com.example.cooking.user.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @Async
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        UserResponseDto userResponseDto = userService.create(userRegisterDto);

        String token = jwtService.generateToken(userResponseDto.getEmail(), Collections.emptyMap());

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }
    @PostMapping(("/login"))
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginDto userLogin) {
        UserResponseDto userResponseDto = userService.login(userLogin);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }


}
