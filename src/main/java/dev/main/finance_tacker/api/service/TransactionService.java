package dev.main.finance_tacker.api.service;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import dev.main.finance_tacker.api.entity.TransactionEntity;
import dev.main.finance_tacker.api.mapper.TransactionDTOMapper;
import dev.main.finance_tacker.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDTOMapper transactionDTOMapper;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionDTOMapper transactionDTOMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionDTOMapper = transactionDTOMapper;
    }

    public TransactionEntity getTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId).get();
    }

    public Long addTransaction(TransactionEntity transaction) {
        return transactionRepository.save(transaction).getId();
    }

    public List<TransactionDTO> getAllTransactions() {
        List<TransactionEntity> transactionsList = transactionRepository.findAll();
        return transactionsList.stream().map(transactionDTOMapper).toList();
    }

}
