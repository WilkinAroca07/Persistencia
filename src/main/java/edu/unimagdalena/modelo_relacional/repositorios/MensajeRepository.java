package edu.unimagdalena.modelo_relacional.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.modelo_relacional.entidades.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje,Long>{}
