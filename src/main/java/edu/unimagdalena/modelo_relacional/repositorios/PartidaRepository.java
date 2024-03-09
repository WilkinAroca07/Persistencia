package edu.unimagdalena.modelo_relacional.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.modelo_relacional.entidades.Partida;

public interface PartidaRepository extends JpaRepository<Partida,Long>{}
