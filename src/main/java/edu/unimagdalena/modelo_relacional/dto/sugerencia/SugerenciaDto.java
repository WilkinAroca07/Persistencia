package edu.unimagdalena.modelo_relacional.dto.sugerencia;

import edu.unimagdalena.modelo_relacional.dto.usuario.UsuarioDto;

public record SugerenciaDto(
    Long id, 
    String descripcion,
    String create_at,
    UsuarioDto usuario
) {}
