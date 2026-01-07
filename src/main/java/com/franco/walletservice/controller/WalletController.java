package com.franco.walletservice.controller;

import com.franco.walletservice.dto.AccountResponseDTO;
import com.franco.walletservice.model.Account;
import com.franco.walletservice.dto.AccountDTO;
import com.franco.walletservice.service.AccountService;
import com.franco.walletservice.service.UserService;
import com.franco.walletservice.dto.UserDTO;
import com.franco.walletservice.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class WalletController {

    private final UserService walletService;
    private final AccountService accountService;

    @PostMapping("/user")
    public ResponseEntity<User> saveNewUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.saverUser(user));
    }

    @PostMapping("/user/account")
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountDTO account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }
}
