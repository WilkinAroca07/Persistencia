package edu.unimagdalena.modelo_relacional.dto.sugerencia;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;

@Mapper
public interface SugerenciaMapper {
   SugerenciaMapper INSTANCE= Mappers.getMapper(SugerenciaMapper.class);
   Sugerencia sugerenciaDtoToSugerencia(SugerenciaDto sugerenciaDto);
   SugerenciaDto sugerenciaToSugerenciaDto(Sugerencia sugerencia);
}
