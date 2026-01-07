package com.franco.walletservice.service;

import com.franco.walletservice.dto.UserDTO;
import com.franco.walletservice.model.User;

public interface UserService {
    User saverUser(UserDTO user);
}
