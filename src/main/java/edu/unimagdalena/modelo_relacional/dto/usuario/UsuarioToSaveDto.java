package edu.unimagdalena.modelo_relacional.dto.usuario;

public record UsuarioToSaveDto(
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
    String create_at
) {}
