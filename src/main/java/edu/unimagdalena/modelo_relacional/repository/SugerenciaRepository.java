package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;
import jakarta.transaction.Transactional;

public interface SugerenciaRepository extends JpaRepository<Sugerencia,Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Sugerencia s SET s.descripcion=:nuevaDescripcion WHERE s.id=:id")
    void updateDescripcionById(Long id, String nuevaDescripcion);
}
