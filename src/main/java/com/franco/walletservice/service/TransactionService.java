package com.franco.walletservice.service;

import com.franco.walletservice.dto.TransactionDTO;
import com.franco.walletservice.dto.TransactionResponseDTO;
import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO transferMoney(TransactionDTO transactionDTO);

    List<TransactionResponseDTO> transactionHistory(Long accountId);
}
