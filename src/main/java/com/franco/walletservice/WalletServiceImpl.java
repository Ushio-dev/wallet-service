package com.franco.walletservice;

import com.franco.walletservice.dto.UserDTO;
import com.franco.walletservice.exception.AlreadyRegisteredException;
import com.franco.walletservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public User saverUser(UserDTO user) {
        if (walletRepository.existsByEmail(user.getEmail())) {
            throw new AlreadyRegisteredException("Email ya registrado");
        }

        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();

        return walletRepository.save(newUser);
    }
}
