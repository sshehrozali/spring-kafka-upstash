package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionEmitterService transactionEmitterService;
    @PostMapping("/new")
    public ResponseEntity<TransactionResponse> newTransaction() {

    }
}
