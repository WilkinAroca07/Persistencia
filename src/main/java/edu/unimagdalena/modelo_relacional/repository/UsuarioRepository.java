package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unimagdalena.modelo_relacional.entidades.Usuario;
import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.username=:nuevoUsername WHERE u.id=:id")
    void updateUsernameById(Long id, String nuevoUsername);
}
