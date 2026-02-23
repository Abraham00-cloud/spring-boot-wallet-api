package com.AAA.wallet_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WalletTransactionRequestDto(@NotNull @Positive BigDecimal amount) {
}
