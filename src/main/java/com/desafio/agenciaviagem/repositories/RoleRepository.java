package com.desafio.agenciaviagem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.agenciaviagem.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}