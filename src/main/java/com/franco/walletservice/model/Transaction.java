package com.franco.walletservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // averiguar mas sobre como tomar la cantidad de dinero en la transaccion
    private BigDecimal amount;

    private TransactionType type;

    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "target_account_id")
    private Long targetAccountId;
}
