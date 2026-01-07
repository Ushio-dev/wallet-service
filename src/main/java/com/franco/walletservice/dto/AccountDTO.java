package com.franco.walletservice.dto;

import com.franco.walletservice.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private Currency currency;

    private Long userId;
}
