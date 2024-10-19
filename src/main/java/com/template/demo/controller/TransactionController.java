package com.template.demo.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.demo.dto.TransactionDTO;
import com.template.demo.model.PostgresModel.Transaction;
import com.template.demo.service.PostgresService.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() throws Exception {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactions(@PathVariable Integer id) throws Exception {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transaction")
    public String insertTransaction(@RequestBody TransactionDTO transactionDto) {
        log.info("Transaction: {}", transactionDto);
        transactionService.saveTransaction(transactionDto);
        return "Transaction saved";
    }

    @PostMapping("/transaction/{id}")
    public String updateTransaction(@PathVariable Integer id, @RequestBody TransactionDTO transactionDto)
            throws BadRequestException {
        transactionService.updateTransaction(id, transactionDto);
        return "Transaction updated";
    }

    @DeleteMapping("/transaction/{id}")
    public String deleteTransaction(@PathVariable Integer id) throws BadRequestException {
        return transactionService.deleteTransaction(id);
    }
}
