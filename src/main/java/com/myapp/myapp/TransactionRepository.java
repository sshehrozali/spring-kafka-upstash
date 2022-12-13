package com.myapp.myapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Integer, Transaction> {
}
