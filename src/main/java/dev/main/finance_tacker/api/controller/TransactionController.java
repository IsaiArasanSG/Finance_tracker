package dev.main.finance_tacker.api.controller;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import dev.main.finance_tacker.api.entity.TransactionEntity;
import dev.main.finance_tacker.api.service.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final Logger logger = LoggerFactory.getLogger(TransactionService.class) ;

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add-transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTransaction(@RequestBody TransactionDTO transactionDTO) {
        TransactionEntity entity = new TransactionEntity(transactionDTO);
        transactionService.addTransaction(entity);
    }

    @GetMapping("/get-all-transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactions(Authentication authentication) {
        authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).forEach(System.out::println);
        return transactionService.getAllTransactions();
    }

    @GetMapping("/get-transaction/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getTransactionById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(transactionService.getTransaction(id));
        } catch (EntityNotFoundException e){
            logger.error("Entity with Id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity with Id is not available");
        }
    }
}
