package dev.mai.finance_tacker.api.repository;

import dev.mai.finance_tacker.api.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
