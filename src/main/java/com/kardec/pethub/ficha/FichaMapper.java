package com.kardec.pethub.ficha;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FichaMapper {

    @Mapping(source = "tuteladoId", target = "tutelado.id")
    @Mapping(target = "historicoClinico", ignore = true)
    Ficha mapToEntity(FichaRequest request);

    @Mapping(source = "tutelado.id", target = "tuteladoId")
    FichaResponse mapToDto(Ficha entity);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateFichaFromDto(FichaRequest request, @MappingTarget Ficha entity);
}
