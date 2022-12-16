package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionEmitterService transactionEmitterService;
    @PostMapping("/new")
    public ResponseEntity<TransactionResponse> newTransaction(@RequestBody NewTransactionRequest newTransactionRequest) {
        transactionEmitterService.processTransaction(newTransactionRequest);
    }
}
