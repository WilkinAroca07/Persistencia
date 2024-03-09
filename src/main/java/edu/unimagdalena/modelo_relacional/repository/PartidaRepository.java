package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.modelo_relacional.entidades.Partida;

public interface PartidaRepository extends JpaRepository<Partida,Long>{}
