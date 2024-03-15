package edu.unimagdalena.modelo_relacional.dto.usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import edu.unimagdalena.modelo_relacional.entidades.Usuario;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper{

    @Mappings({
        @Mapping(source="create_at",target = "create_at", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    UsuarioDto entityToDto(Usuario usuario);

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Usuario dtoToEntity(UsuarioDto usuarioDto); 

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Usuario toSaveDtoToEntity(UsuarioToSaveDto usuarioTosaveDto);

}
