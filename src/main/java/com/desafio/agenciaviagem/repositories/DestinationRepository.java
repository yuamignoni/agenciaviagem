package com.desafio.agenciaviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.agenciaviagem.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {}