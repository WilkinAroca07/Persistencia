package edu.unimagdalena.modelo_relacional.dto.sugerencia;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface SugerenciaMapper {
    @Mappings({
        @Mapping(source="create_at",target = "create_at", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    SugerenciaDto entityToDto(Sugerencia sugerencia);

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Sugerencia dtoToEntity(SugerenciaDto sugerenciaDto); 

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Sugerencia toSaveDtoToEntity(SugerenciaToSaveDto sugerenciaTosaveDto);
}
