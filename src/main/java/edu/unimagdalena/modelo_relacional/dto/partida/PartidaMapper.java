package edu.unimagdalena.modelo_relacional.dto.partida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import edu.unimagdalena.modelo_relacional.entidades.Partida;

public interface PartidaMapper {
    @Mappings({
        @Mapping(source="create_at",target = "create_at", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    PartidaDto entityToDto(Partida partida);

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Partida dtoToEntity(PartidaDto partidaDto); 

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Partida toSaveDtoToEntity(PartidaToSaveDto partidaTosaveDto);
}
