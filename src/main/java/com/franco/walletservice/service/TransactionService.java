package com.franco.walletservice.service;

import com.franco.walletservice.dto.TransactionDTO;
import com.franco.walletservice.dto.TransactionResponseDTO;

public interface TransactionService {
    TransactionResponseDTO transferMoney(TransactionDTO transactionDTO);
}
