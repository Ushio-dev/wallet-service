package com.franco.walletservice.repository;

import com.franco.walletservice.model.Account;
import com.franco.walletservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountUserId(Long id);
}
