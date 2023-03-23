package dev.mai.finance_tacker.api.mapper;

import dev.mai.finance_tacker.api.dto.TransactionDTO;
import dev.mai.finance_tacker.api.entity.TransactionEntity;

import java.util.function.Function;

public class TransactionDTOMapper implements Function<TransactionEntity, TransactionDTO> {
    @Override
    public TransactionDTO apply(TransactionEntity entity) {
        return new TransactionDTO(entity.getDescription(), entity.getAmount(), entity.getTransactionDate(),
                entity.getCategory(), entity.getType());
    }
}
