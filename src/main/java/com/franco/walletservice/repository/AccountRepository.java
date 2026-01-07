package com.franco.walletservice.repository;

import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserIdAndCurrency(Long userId, Currency currency);
}
