package edu.unimagdalena.modelo_relacional.dto.partida;

import java.util.Collections;
import java.util.List;

import edu.unimagdalena.modelo_relacional.dto.usuario.UsuarioDto;

public record PartidaDto(
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
    String comentario,
    List<UsuarioDto> usuarios
) {
    public List<UsuarioDto> usuarios(){
        return Collections.unmodifiableList(usuarios);
    }
}
