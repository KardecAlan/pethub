package com.kardec.pethub.mapper;

import com.kardec.pethub.dto.request.TutorRequest;
import com.kardec.pethub.dto.response.TutorResponse;
import com.kardec.pethub.model.Tutor;
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
