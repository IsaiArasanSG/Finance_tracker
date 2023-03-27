package dev.main.finance_tacker.security.repository;

import dev.main.finance_tacker.api.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityAuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

    AuthorityEntity findAuthorityEntityByUserId(Long userId);
}
