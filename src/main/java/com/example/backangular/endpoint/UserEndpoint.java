package com.example.backangular.endpoint;


import com.example.backangular.dto.*;
import com.example.backangular.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserEndpoint {
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/auth")
    public ResponseEntity<UserAuthResponseDto> auth(@RequestBody UserAuthRequestDto userAuthRequestDto) {
        return ResponseEntity.ok(userServiceImpl.authUserByEmailPassword(userAuthRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return ResponseEntity.ok(userServiceImpl.register(userRegisterRequestDto));
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> getUser(@RequestParam String email) {
        return ResponseEntity.ok(userServiceImpl.getUser(email));
    }
}
