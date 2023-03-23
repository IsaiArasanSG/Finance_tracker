package dev.main.finance_tacker.api.mapper;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import dev.main.finance_tacker.api.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TransactionDTOMapper implements Function<TransactionEntity, TransactionDTO> {
    @Override
    public TransactionDTO apply(TransactionEntity entity) {
        return new TransactionDTO(entity.getDescription(), entity.getAmount(), entity.getTransactionDate(),
                entity.getCategory(), entity.getType());
    }
}
