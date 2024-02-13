package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long>{}
