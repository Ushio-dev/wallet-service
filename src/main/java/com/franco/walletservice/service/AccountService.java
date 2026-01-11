package com.franco.walletservice.service;

import com.franco.walletservice.dto.AccountResponseDTO;
import com.franco.walletservice.dto.AccountDTO;
import com.franco.walletservice.model.User;

public interface AccountService {
    AccountResponseDTO createAccount(AccountDTO accountDTO);
}
