package com.franco.walletservice.repository;

import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Currency;
import com.franco.walletservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserIdAndCurrency(Long userId, Currency currency);
}
