package com.franco.walletservice;

import com.franco.walletservice.dto.UserDTO;
import com.franco.walletservice.model.User;

public interface WalletService {
    User saverUser(UserDTO user);
}
