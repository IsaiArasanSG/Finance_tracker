package dev.main.finance_tacker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests((authorize) -> {
                        authorize.requestMatchers("/error").permitAll();
                        authorize.requestMatchers("/favicon.ico").permitAll();
                        authorize.anyRequest().authenticated();
                    })
                    .httpBasic(withDefaults())
                    .formLogin(withDefaults())
                    .build();
    }


}
