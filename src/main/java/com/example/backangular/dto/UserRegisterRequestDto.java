package com.example.backangular.dto;

import lombok.Builder;


@Builder
public record UserRegisterRequestDto(
        String name,
        String surname,
        String email,
        String password
) {
}
