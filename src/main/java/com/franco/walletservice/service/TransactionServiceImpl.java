package com.franco.walletservice.service;

import com.franco.walletservice.dto.TransactionDTO;
import com.franco.walletservice.dto.TransactionResponseDTO;
import com.franco.walletservice.exception.InsufficientFundsException;
import com.franco.walletservice.exception.NotSameCurrencyException;
import com.franco.walletservice.exception.UserNotFoundException;
import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Transaction;
import com.franco.walletservice.model.TransactionType;
import com.franco.walletservice.repository.AccountRepository;
import com.franco.walletservice.repository.TransactionRepository;
import com.franco.walletservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public TransactionResponseDTO transferMoney(TransactionDTO transactionDTO) {

        Account senderAccount = accountRepository.findById(transactionDTO.getAccountId())
                .orElseThrow(() -> new UserNotFoundException("No se encuentra la cuenta solicitante"));

        Account receiverAccount = accountRepository.findById(transactionDTO.getTargetAccountId())
                .orElseThrow(() -> new UserNotFoundException("No se encontro cuenta destino"));

        // consultar si el usuario tiene fondos suficientes
        if (senderAccount.getBalance().compareTo(transactionDTO.getAmount()) < 0) {
            throw new InsufficientFundsException("No hay fondos suficientes en la cuenta");
        }

        // verificar que la transferencia se haga a cuentas con la misma moneda
        if (senderAccount.getCurrency() != senderAccount.getCurrency()) {
            throw new NotSameCurrencyException("Ambas cuentas no tiene la misma moneda");
        }

        // realizar la transferencia
        // actualiza los datos
        senderAccount.setBalance(senderAccount.getBalance().subtract(transactionDTO.getAmount()));
        receiverAccount.setBalance(receiverAccount.getBalance().add(transactionDTO.getAmount()));


        Transaction transaction = Transaction.builder()
                .amount(transactionDTO.getAmount())
                .type(TransactionType.TRANSFER)
                .account(senderAccount)
                .timestamp(LocalDateTime.now())
                .targetAccount(receiverAccount)
                .build();

        transaction = transactionRepository.save(transaction);

        return TransactionResponseDTO.builder()
                .id(transaction.getId())
                .accountId(transaction.getAccount().getId())
                .targetAccountId(transaction.getTargetAccount().getId())
                .type(transactionDTO.getType())
                .amount(transaction.getAmount())
                .build();
    }

    @Override
    public List<TransactionResponseDTO> transactionHistory(Long accountId) {
        List<Transaction> transactions = transactionRepository.findByAccountUserId(accountId);
        List<TransactionResponseDTO> transactionResponseDTOS = new ArrayList<>();

        transactions.forEach(transaction -> {
            transactionResponseDTOS.add(new TransactionResponseDTO(
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getType(),
                    transaction.getAccount().getId(),
                    transaction.getTargetAccount().getId())
            );
        });

        return transactionResponseDTOS;
    }
}
