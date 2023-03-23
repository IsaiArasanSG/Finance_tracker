package dev.main.finance_tacker.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Column(name = "ID")
    @Id
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "TYPE")
    private String type;

    public TransactionEntity(String description, Double amount,
                             String transactionDate, String category,
                             String type) {
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.category = category;
        this.type = type;
    }
}
