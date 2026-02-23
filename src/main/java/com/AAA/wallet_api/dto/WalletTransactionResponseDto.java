package com.AAA.wallet_api.dto;

import java.math.BigDecimal;

public record WalletTransactionResponseDto(String userId, BigDecimal amount) {
}
