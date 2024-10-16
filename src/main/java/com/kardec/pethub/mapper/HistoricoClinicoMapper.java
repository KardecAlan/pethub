package com.kardec.pethub.mapper;

import com.kardec.pethub.dto.request.HistoricoClinicoRequest;
import com.kardec.pethub.dto.response.HistoricoClinicoResponse;
import com.kardec.pethub.model.HistoricoClinico;
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
