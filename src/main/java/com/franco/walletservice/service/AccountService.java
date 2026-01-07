package com.franco.walletservice.service;

import com.franco.walletservice.dto.AccountResponseDTO;
import com.franco.walletservice.dto.AccountDTO;

public interface AccountService {
    AccountResponseDTO createAccount(AccountDTO accountDTO);
}
