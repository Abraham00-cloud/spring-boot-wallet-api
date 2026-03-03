package com.AAA.wallet_api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDto(LocalDateTime timestamp, int status, String error, Map<String, String> validationErrors, String path) {
}
