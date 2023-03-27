package dev.main.finance_tacker.security.entity;

import dev.main.finance_tacker.api.entity.AuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthorityEntity implements GrantedAuthority {

    private final AuthorityEntity authority;
    @Override
    public String getAuthority() {
        return authority.getAuthority();
    }
}
