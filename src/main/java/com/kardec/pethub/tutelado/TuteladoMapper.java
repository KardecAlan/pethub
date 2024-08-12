package com.kardec.pethub.tutelado;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TuteladoMapper {

    @Mapping(source = "tutorId", target = "tutor.id")
    Tutelado mapToEntity(TuteladoRequest request);

    @Mapping(source = "tutor.id", target = "tutorId")
    TuteladoResponse mapToDto(Tutelado entity);

    Tutelado mapToDto(TuteladoResponse tuteladoResponse);

    List<TuteladoResponse> mapToDto(List<Tutelado> entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTuteladoFromDto(TuteladoRequest request, @MappingTarget Tutelado entity);
}
