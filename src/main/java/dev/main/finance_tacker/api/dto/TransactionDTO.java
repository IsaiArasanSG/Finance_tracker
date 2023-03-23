package dev.main.finance_tacker.api.dto;

public record TransactionDTO(
        String description,
        double amount,
        String transactionDate,
        String category,
        String type
) {
}
