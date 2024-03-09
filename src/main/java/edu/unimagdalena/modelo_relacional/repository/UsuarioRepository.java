package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.modelo_relacional.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{}
