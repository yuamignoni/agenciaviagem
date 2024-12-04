package com.desafio.agenciaviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.agenciaviagem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
