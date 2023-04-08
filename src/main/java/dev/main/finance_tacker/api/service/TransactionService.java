package dev.main.finance_tacker.api.service;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import dev.main.finance_tacker.api.entity.TransactionEntity;
import dev.main.finance_tacker.api.mapper.TransactionDTOMapper;
import dev.main.finance_tacker.api.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public TransactionDTO getTransaction(Long transactionId) {
        return transactionDTOMapper
                .apply(transactionRepository.findById(transactionId).orElseThrow(EntityNotFoundException::new));
    }

    public void addTransaction(TransactionEntity transaction) {
        transactionRepository.save(transaction);
    }

    public List<TransactionDTO> getAllTransactions() {
        List<TransactionEntity> transactionsList = transactionRepository.findAll();
        return transactionsList.stream().map(transactionDTOMapper).toList();
    }

}
