package com.fintech.credx.repositories;

import com.fintech.credx.entities.QTransaction;
import com.fintech.credx.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>, QuerydslPredicateExecutor<Transaction>, QuerydslBinderCustomizer<QTransaction> {
}
