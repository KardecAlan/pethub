package com.kardec.pethub.tutor;

import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service("tutorService")
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorMapper tutorMapper;

    public Page<TutorResponse> findAll(TutorRequest tutorRequest) {
        Page<Tutor> page = tutorRepository.findAll((Specification<Tutor>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (tutorRequest.getNome() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + tutorRequest.getNome() + "%"));
            }

            if (tutorRequest.getCpf() != null) {
                predicates.add(criteriaBuilder.like(root.get("cpf"), "%" + tutorRequest.getCpf() + "%"));
            }

            if (tutorRequest.getTuteladoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tutelados").get("id"), tutorRequest.getTuteladoId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(tutorRequest.getPage(), tutorRequest.getSize()));

        return page.map(tutorMapper::mapToDto);

    }

    public TutorResponse findById(Long id) {
        return tutorRepository.findById(id)
                .map(tutorMapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Tutor não encontrado"));

    }

    public TutorResponse create(TutorRequest tutorRequest) {
        Tutor tutor = tutorMapper.mapToEntity(tutorRequest);

        Tutor tutorEntity = tutorRepository.save(tutor);

        return tutorMapper.mapToDto(tutorEntity);
    }

    public TutorResponse update(TutorRequest tutorRequest) {
        Tutor tutor = tutorRepository.findById(tutorRequest.getId())
                .orElseThrow(() -> new NoSuchElementException("Tutor não encontrado"));

        tutorMapper.updateTutorFromDto(tutorRequest, tutor);

        return tutorMapper.mapToDto(tutorRepository.save(tutor));
    }

    public void delete(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tutor não encontrado"));

        tutorRepository.delete(tutor);
    }
}
