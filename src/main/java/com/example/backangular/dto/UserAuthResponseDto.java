package com.example.backangular.dto;

import lombok.Builder;


@Builder
public record UserAuthResponseDto(
        String token
) {
}
