package com.example.backangular.dto;

import lombok.Builder;


@Builder
public record UserAuthRequestDto(
        String email,
        String password
) {
}
