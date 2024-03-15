package edu.unimagdalena.modelo_relacional.dto.mensaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import edu.unimagdalena.modelo_relacional.entidades.Mensaje;
public interface MensajeMapper {
    @Mappings({
        @Mapping(source="create_at",target = "create_at", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    MensajeDto entityToDto(Mensaje mensaje);

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Mensaje dtoToEntity(MensajeDto mensajeDto); 

    @InheritInverseConfiguration
    @Mapping(source = "create_at", target = "create_at")
    Mensaje toSaveDtoToEntity(MensajeToSaveDto mensajeTosaveDto);
}
