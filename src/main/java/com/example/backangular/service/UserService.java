package com.example.backangular.service;


import com.example.backangular.dto.*;

public interface UserService {
    UserAuthResponseDto authUserByEmailPassword(UserAuthRequestDto userAuthRequestDto);
    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto);

    UserResponseDto getUser(String email);
}
