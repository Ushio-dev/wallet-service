package com.franco.walletservice.service;

import com.franco.walletservice.dto.AccountResponseDTO;
import com.franco.walletservice.exception.AlreadyRegisteredException;
import com.franco.walletservice.exception.UserNotFoundException;
import com.franco.walletservice.model.Account;
import com.franco.walletservice.dto.AccountDTO;
import com.franco.walletservice.repository.AccountRepository;
import com.franco.walletservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountResponseDTO createAccount(AccountDTO accountDTO) {

        if (!userRepository.existsById(accountDTO.getUserId())){
            throw new UserNotFoundException("No se encontro usuario");
        }

        if (accountRepository.existsByUserIdAndCurrency(accountDTO.getUserId(), accountDTO.getCurrency())) {
            throw new AlreadyRegisteredException("Cuenta ya existente");
        }

        // agregar la logica

        Account newAcount = Account.builder()
                .user(userRepository.findById(accountDTO.getUserId()).get())
                .currency(accountDTO.getCurrency())
                .build();

        Account account = accountRepository.save(newAcount);

        return AccountResponseDTO.builder()
                .id(account.getId())
                .currency(account.getCurrency())
                .userId(accountDTO.getUserId())
                .build();
    }
}
