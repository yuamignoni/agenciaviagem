package com.desafio.agenciaviagem.config;

import com.desafio.agenciaviagem.entities.Role;
import com.desafio.agenciaviagem.entities.User;
import com.desafio.agenciaviagem.repositories.RoleRepository;
import com.desafio.agenciaviagem.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_ADMIN")));

            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoles(Set.of(adminRole));
                userRepository.save(admin);
            }
            
            if (userRepository.findByUsername("user") == null) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRoles(Set.of(userRole));
                userRepository.save(user);
            }
        };
    }
}
