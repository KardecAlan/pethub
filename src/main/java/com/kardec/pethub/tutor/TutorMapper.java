package com.kardec.pethub.tutor;

import com.kardec.pethub.tutelado.TuteladoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    Tutor mapToEntity(TutorRequest request);

    TutorResponse mapToDto(Tutor entity);

    List<TutorResponse> mapToDto(List<Tutor> entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTutorFromDto(TutorRequest request, @MappingTarget Tutor entity);

}
