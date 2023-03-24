package dev.main.finance_tacker.api.dto;

import dev.main.finance_tacker.api.enums.TypeEnum;

import java.util.Date;

public record TransactionDTO(
        String description,
        double amount,
        Date transactionDate,
        String category,
        TypeEnum type
) {
}
