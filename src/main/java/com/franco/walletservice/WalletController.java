package com.franco.walletservice;

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

    private final WalletService walletService;

    @PostMapping("/user")
    public ResponseEntity<User> saveNewUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.saverUser(user));
    }
}
