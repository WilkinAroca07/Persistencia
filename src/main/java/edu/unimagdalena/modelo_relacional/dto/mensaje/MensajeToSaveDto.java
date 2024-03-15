package edu.unimagdalena.modelo_relacional.dto.mensaje;

public record MensajeToSaveDto(
    Long id,
    String creador,
    String destinatario,
    String create_at,
    String contenido
) {}
