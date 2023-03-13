package dev.mai.finance_tacker.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TRANSACTION")
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
}
