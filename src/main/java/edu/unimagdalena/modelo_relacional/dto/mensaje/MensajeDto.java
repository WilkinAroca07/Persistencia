package edu.unimagdalena.modelo_relacional.dto.mensaje;

import edu.unimagdalena.modelo_relacional.dto.usuario.UsuarioDto;

public record MensajeDto(
    Long id,
    String creador,
    String destinatario,
    String create_at,
    String contenido,
    UsuarioDto usuario
) {}
