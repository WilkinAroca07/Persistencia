package edu.unimagdalena.modelo_relacional.dto.partida;

public record PartidaToSaveDto(
    Long id,
    String creador,
    String deporte,
    String ciudad,
    String provincia,
    String fecha, 
    String hora_comienzo,
    String hora_final,
    Integer participantes,
    Integer suplentes,
    String comentarios
) {}
