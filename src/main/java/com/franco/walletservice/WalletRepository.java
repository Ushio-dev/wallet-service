package com.franco.walletservice;

import com.franco.walletservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
