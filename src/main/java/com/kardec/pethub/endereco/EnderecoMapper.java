package com.kardec.pethub.endereco;

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
