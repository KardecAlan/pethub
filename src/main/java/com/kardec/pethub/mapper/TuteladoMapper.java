package com.kardec.pethub.mapper;

import com.kardec.pethub.model.Tutelado;
import com.kardec.pethub.dto.request.TuteladoRequest;
import com.kardec.pethub.dto.response.TuteladoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TuteladoMapper {

    @Mapping(source = "tutorId", target = "tutor.id")
    Tutelado mapToEntity(TuteladoRequest request);

    @Mapping(source = "tutor.nome", target = "tutorNome")
    TuteladoResponse mapToDto(Tutelado entity);

    Tutelado mapToDto(TuteladoResponse tuteladoResponse);

    List<TuteladoResponse> mapToDto(List<Tutelado> entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTuteladoFromDto(TuteladoRequest request, @MappingTarget Tutelado entity);
}
