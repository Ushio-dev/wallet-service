package com.franco.walletservice.exception;

public class NotSameCurrencyException extends RuntimeException {
    public NotSameCurrencyException(String msg) {
        super(msg);
    }
}
