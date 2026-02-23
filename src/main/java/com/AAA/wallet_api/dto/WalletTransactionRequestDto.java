package com.AAA.wallet_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WalletTransactionRequestDto(@NotNull(message = "Amount is required") @Positive(message = "amount cannot be less that zero") BigDecimal amount) {
}
