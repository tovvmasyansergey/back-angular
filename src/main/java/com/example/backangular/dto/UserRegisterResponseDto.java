package com.example.backangular.dto;


import com.example.backangular.entity.UserType;
import lombok.Builder;


@Builder
public record UserRegisterResponseDto(
        int id,
        String name,
        String surname,
        String email,
        UserType type
) {
}
