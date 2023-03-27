package dev.main.finance_tacker.security.service;

import dev.main.finance_tacker.security.entity.SecurityUserEntity;
import dev.main.finance_tacker.security.repository.SecurityUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final SecurityUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = repository.findUserEntityByEmail(username);
        return u.map(SecurityUserEntity::new)
                .orElseGet(() ->  {
                    var user = repository.findUserEntityByUserName(username);
                    if (user.isEmpty()) {
                        throw new UsernameNotFoundException("Username/Email not found " + username);
                    }
                    return user.map(SecurityUserEntity::new).get();
                });
    }
}
