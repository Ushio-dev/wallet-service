package com.franco.walletservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WalletController {
    @GetMapping("/hola")
    public String saludar() {
        return "Hola Mundo";
    }
}
