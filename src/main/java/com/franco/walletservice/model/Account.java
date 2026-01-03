package com.franco.walletservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Builder.Default
    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
