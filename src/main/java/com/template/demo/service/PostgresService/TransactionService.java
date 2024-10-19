package com.template.demo.service.PostgresService;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.demo.dto.TransactionDTO;
import com.template.demo.model.PostgresModel.Transaction;
import com.template.demo.repository.PostgresRepository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void saveTransaction(TransactionDTO transaction) {
        Transaction newTransaction = new Transaction();
        newTransaction.setActivityCode(transaction.getActivityCode());
        newTransaction.setInsertBy(transaction.getInsertBy());
        newTransaction.setInsertDate(transaction.getInsertDate());
        transactionRepository.save(newTransaction);
    }

    @Transactional
    public void updateTransaction(Integer id, TransactionDTO transactionDto) throws BadRequestException {
        log.info("check: {}", transactionDto.getInsertBy());
        Transaction existingTransaction = transactionRepository.findById(id) .orElseThrow(() -> new BadRequestException("Invalid transaction id"));
        existingTransaction .setActivityCode(transactionDto.getActivityCode() == null ? existingTransaction.getActivityCode() : transactionDto.getActivityCode());
        existingTransaction.setInsertBy(transactionDto.getInsertBy() == null ? existingTransaction.getInsertBy() : transactionDto.getInsertBy());
        existingTransaction.setInsertDate(transactionDto.getInsertDate() == null ? existingTransaction.getInsertDate(): transactionDto.getInsertDate());
        transactionRepository.save(existingTransaction);
        return;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Integer id) throws BadRequestException {
        return transactionRepository.findById(id).orElseThrow(() -> new BadRequestException("Invalid transaction id"));
    }

    public String deleteTransaction(Integer id) throws BadRequestException {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid transaction id"));
        transactionRepository.delete(transaction);
        return "Transaction deleted";
    }
}
