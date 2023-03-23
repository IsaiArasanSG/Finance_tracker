package dev.main.finance_tacker.api.dto;

import java.util.Date;

public record TransactionDTO(
        String description,
        double amount,
        Date transactionDate,
        String category,
        String type
) {
}
