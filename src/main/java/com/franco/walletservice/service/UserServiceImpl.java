package com.franco.walletservice.service;

import com.franco.walletservice.dto.UserDTO;
import com.franco.walletservice.exception.AlreadyRegisteredException;
import com.franco.walletservice.model.User;
import com.franco.walletservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository walletRepository;

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
