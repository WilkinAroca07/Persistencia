package edu.unimagdalena.modelo_relacional.dto.mensaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.modelo_relacional.entidades.Mensaje;
@Mapper
public interface MensajeMapper {
    MensajeMapper INSTANCE = Mappers.getMapper(MensajeMapper.class);
    Mensaje mensajeDtoMensaje(MensajeDto mensajeDto);
    MensajeDto mensajeTomMensajeDto(Mensaje mensaje);
}
