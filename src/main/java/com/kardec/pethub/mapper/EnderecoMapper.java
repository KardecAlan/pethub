package com.kardec.pethub.mapper;

import com.kardec.pethub.dto.request.EnderecoRequest;
import com.kardec.pethub.dto.response.EnderecoResponse;
import com.kardec.pethub.model.Endereco;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {


    Endereco mapToEntity(EnderecoRequest request);

    EnderecoResponse mapToDto(Endereco entity);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEnderecoFromDto(EnderecoRequest request, @MappingTarget Endereco entity);
}
