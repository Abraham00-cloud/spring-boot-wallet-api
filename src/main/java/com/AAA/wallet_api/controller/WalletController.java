package com.AAA.wallet_api.controller;


import com.AAA.wallet_api.dto.WalletTransactionRequestDto;
import com.AAA.wallet_api.dto.WalletTransactionResponseDto;
import com.AAA.wallet_api.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wallets")
@Tag(name = "Wallet API", description = "Operations for managing user funds and balances")
public class WalletController {

    private final WalletService service;

    @Operation(summary = "Create a new wallet", description = "Initializes a wallet with 0.00 balance for a given User ID")
    @PostMapping("/create/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public WalletTransactionResponseDto createWallet(@PathVariable String userId) {
        return service.createWallet(userId);
    }

    @Operation(summary = "Add funds", description = "Increases the wallet balance by the specified amount")
    @PostMapping("/{userId}/fund")
    public WalletTransactionResponseDto fund( @PathVariable String userId, WalletTransactionRequestDto requestDto ){
        return service.fundWallet(userId, requestDto);
    }

    @Operation(summary = "Debit funds", description = "Decreases the wallet balance by the specified amount")
    @PostMapping("/{userId}/debit")
    public WalletTransactionResponseDto debit(@PathVariable String userId, WalletTransactionRequestDto requestDto) {
        return service.debitWallet(userId, requestDto);
    }

    @Operation(summary = "Get Balance", description = "Returns the current status of the wallet")
    @GetMapping("/{userId}")
    public WalletTransactionResponseDto getDetails(@PathVariable String userId) {
        return service.getDetails(userId);
    }





}

