package edu.unimagdalena.modelo_relacional.dto.usuario;

import java.util.Collections;
import java.util.List;

import edu.unimagdalena.modelo_relacional.dto.mensaje.MensajeDto;
import edu.unimagdalena.modelo_relacional.dto.sugerencia.SugerenciaDto;

public record UsuarioDto(
    Long id,
    String username,
    String email,
    String nombre,
    String apellidos,
    Integer edad,
    String password,
    String rep_password,
    Boolean enabled,
    String foto,
    String rol,
    String create_at,
    List<SugerenciaDto> sugerencias,
    List<MensajeDto> mensajes
) {
    public List<SugerenciaDto> sugerencias(){
        return Collections.unmodifiableList(sugerencias);
    }
    public List<MensajeDto> mensajes(){
        return Collections.unmodifiableList(mensajes);
    }
}
