package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unimagdalena.modelo_relacional.entidades.Partida;
import jakarta.transaction.Transactional;

public interface PartidaRepository extends JpaRepository<Partida,Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Partida p SET p.creador=:nuevoCreador WHERE p.id=:id")
    void updateCreadorById(Long id, String nuevoCreador);
}
