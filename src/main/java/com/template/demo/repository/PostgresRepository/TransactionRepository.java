package com.template.demo.repository.PostgresRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.demo.model.PostgresModel.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTop1ById(Integer id);

    Transaction findTop1ByActivityCode(Integer activityCode);
}
