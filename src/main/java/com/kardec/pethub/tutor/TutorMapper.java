package com.kardec.pethub.tutor;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    @Mapping(source = "enderecoId", target = "endereco.id")
    @Mapping(source = "tuteladoId", target = "tutelado.id")
    Tutor mapToEntity(TutorRequest request);

    TutorResponse mapToDto(Tutor entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTutorFromDto(TutorRequest request, @MappingTarget Tutor entity);

}
