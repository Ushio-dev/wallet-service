package com.franco.walletservice.controller;

import com.franco.walletservice.dto.*;
import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Transaction;
import com.franco.walletservice.service.AccountService;
import com.franco.walletservice.service.TransactionService;
import com.franco.walletservice.service.UserService;
import com.franco.walletservice.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class WalletController {

    private final UserService walletService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @PostMapping("/user")
    public ResponseEntity<User> saveNewUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.saverUser(user));
    }

    @PostMapping("/user/account")
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountDTO account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@Valid @RequestBody TransactionDTO transaction) {
        // probar si funciona
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.transferMoney(transaction));
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<List<TransactionResponseDTO>> transactionHistory(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.transactionHistory(Long.parseLong(id)));
    }
}
