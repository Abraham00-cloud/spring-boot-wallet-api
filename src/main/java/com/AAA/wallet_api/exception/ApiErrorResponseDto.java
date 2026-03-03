package com.AAA.wallet_api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiErrorResponseDto(LocalDateTime timestamp, int status, String error, String message, String path) {
}
