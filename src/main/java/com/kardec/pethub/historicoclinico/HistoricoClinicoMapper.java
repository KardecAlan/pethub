package com.kardec.pethub.historicoclinico;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HistoricoClinicoMapper {

    HistoricoClinico mapToEntity(HistoricoClinicoRequest request);

    HistoricoClinicoResponse mapToDto(HistoricoClinico entity);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateHistoricoClinicoFromDto(HistoricoClinicoRequest request, @MappingTarget HistoricoClinico entity);
}
