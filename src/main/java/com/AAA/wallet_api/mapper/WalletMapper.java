package com.AAA.wallet_api.mapper;

import com.AAA.wallet_api.dto.WalletTransactionRequestDto;
import com.AAA.wallet_api.dto.WalletTransactionResponseDto;
import com.AAA.wallet_api.model.Wallet;
import org.springframework.stereotype.Service;

@Service
public class WalletMapper {
    public Wallet toWallet(WalletTransactionRequestDto requestDto) {
        Wallet wallet = new Wallet();
        wallet.setBalance(requestDto.amount());
        return wallet;
    }

    public WalletTransactionResponseDto toResponseDto(Wallet wallet) {
        return new WalletTransactionResponseDto(wallet.getUserId(), wallet.getBalance());

    }
}
