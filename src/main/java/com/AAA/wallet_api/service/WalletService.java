package com.AAA.wallet_api.service;

import com.AAA.wallet_api.dto.WalletTransactionRequestDto;
import com.AAA.wallet_api.dto.WalletTransactionResponseDto;
import com.AAA.wallet_api.mapper.WalletMapper;
import com.AAA.wallet_api.model.Wallet;
import com.AAA.wallet_api.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class WalletService {
    private final WalletRepository repository;
    private final WalletMapper mapper;

    public WalletTransactionResponseDto createWallet(String userId) {
        if (repository.findByUserId(userId).isPresent()) {
            throw new IllegalStateException("user already exists");
        }
        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(BigDecimal.ZERO);
        var savedWallet = repository.save(wallet);
        return mapper.toResponseDto(savedWallet);
    }

    @Transactional
    public WalletTransactionResponseDto fundWallet(String userId, WalletTransactionRequestDto requestDto) {
        var amount = requestDto.amount();
        validateAmount(amount);
        Wallet wallet = repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        wallet.setBalance(wallet.getBalance().add(amount));
        var savedWallet = repository.save(wallet);
        return mapper.toResponseDto(savedWallet);
    }

    @Transactional
    public WalletTransactionResponseDto debitWallet(String userId, WalletTransactionRequestDto requestDto) {
        var amount = requestDto.amount();
        validateAmount(amount);
        Wallet wallet = repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if (wallet.getBalance().compareTo(amount) < 0) {
            throw  new IllegalStateException("Insufficient funds");
        };
        wallet.setBalance(wallet.getBalance().subtract(amount));
        var savedWallet= repository.save(wallet);
        return mapper.toResponseDto(savedWallet);
    }

    public WalletTransactionResponseDto getDetails(String userId) {
        var wallet = repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return mapper.toResponseDto(wallet);
    }



    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw  new IllegalArgumentException("amount cannot be less than zero or empty");
        }
    }
}
