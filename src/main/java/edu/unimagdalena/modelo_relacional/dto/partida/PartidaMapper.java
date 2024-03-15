package edu.unimagdalena.modelo_relacional.dto.partida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.modelo_relacional.entidades.Partida;

@Mapper
public interface PartidaMapper {
    PartidaMapper INSTANCE = Mappers.getMapper(PartidaMapper.class);
    Partida partidaDtoToPartida(PartidaDto partidaDto);
    PartidaDto partidaToPartidaDto(Partida partida);
}
