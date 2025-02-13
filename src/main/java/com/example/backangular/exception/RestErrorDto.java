package com.example.backangular.exception;

import lombok.Builder;

@Builder
public record RestErrorDto(
        int statusCode,
        String errorMessage
) {
}
