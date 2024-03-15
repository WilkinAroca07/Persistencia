package edu.unimagdalena.modelo_relacional.dto.sugerencia;

public record SugerenciaToSaveDto(
    Long id,
    String descripcion,
    String create_at
) {}
