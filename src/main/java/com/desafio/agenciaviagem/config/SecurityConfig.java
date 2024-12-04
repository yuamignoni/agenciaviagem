package com.desafio.agenciaviagem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                // Permitir acesso aos endpoints de destinos para usuários com ROLE_USER ou ROLE_ADMIN
                .requestMatchers("/destinations/**").hasAnyRole("USER", "ADMIN")
                // Permitir acesso aos endpoints administrativos somente para ROLE_ADMIN
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // Requer autenticação para qualquer outra request
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // Usar autenticação básica para simplificação
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
