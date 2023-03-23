package dev.main.finance_tacker.api.controller;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import dev.main.finance_tacker.api.entity.TransactionEntity;
import dev.main.finance_tacker.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/addtransaction")
    public String addTransaction(@RequestBody TransactionDTO transactionDTO) {
        TransactionEntity entity = new TransactionEntity(transactionDTO);
        Long id = transactionService.addTransaction(entity);
        return id.toString();
    }

    @GetMapping("/gettransactions")
    public List<TransactionDTO> getTransactions() {
        return transactionService.getAllTransactions();
    }
}