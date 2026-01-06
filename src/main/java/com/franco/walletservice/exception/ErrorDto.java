package com.franco.walletservice.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDto {
    private String message;
    private int state;
    private LocalDateTime date;

    public ErrorDto(String msg, int state) {
        this.message = msg;
        this.state = state;
        this.date = LocalDateTime.now();
    }
}
