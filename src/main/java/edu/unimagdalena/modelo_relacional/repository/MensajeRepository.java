package edu.unimagdalena.modelo_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unimagdalena.modelo_relacional.entidades.Mensaje;
import jakarta.transaction.Transactional;

public interface MensajeRepository extends JpaRepository<Mensaje,Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Mensaje m SET m.destinatario=:nuevoDestinario WHERE m.id=:id")
    void updateDescripcionById(Long id, String nuevoDestinatario);
}
