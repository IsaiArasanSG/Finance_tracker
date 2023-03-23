package dev.main.finance_tacker.api.entity;

import dev.main.finance_tacker.api.dto.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "TRANSACTION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "TYPE")
    private String type;

    public TransactionEntity(TransactionDTO dto) {
        this.description = dto.description();
        this.amount = dto.amount();
        this.transactionDate = dto.transactionDate();
        this.category = dto.category();
        this.type = dto.type();
    }
}
