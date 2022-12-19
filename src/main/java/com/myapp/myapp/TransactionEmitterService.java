package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionEmitterService {
//    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    public CustomTransactionResponse processTransaction(NewTransactionRequest newTransactionRequest) throws InterruptedException {
        Transaction t = Transaction.builder()
                .id(1)
                .transaction_id("ABC-123")
                .amount(newTransactionRequest.amount())
                .state(0)   // Default to 0
                .build();
//        transactionRepository.save(t);
        log.warn("Transaction initiated successfully");

//        log.warn("Sending Transaction... " + t_initiated);
//        transactionProducer.sendTransaction(t_initiated);
//        log.info("Sent");
//
//        t_initiated.setState(1);    // Set Transaction to success
//        Transaction t_success = t_initiated;    // Assign t again
//        transactionRepository.saveAndFlush(t_success);  // Rewrite on db

        CustomTransactionResponse customTransactionResponse = CustomTransactionResponse.builder()
                .httpStatus(HttpStatus.OK)
                .msg("Transaction sent successfully")
                .build();
        return customTransactionResponse;
    }
}
