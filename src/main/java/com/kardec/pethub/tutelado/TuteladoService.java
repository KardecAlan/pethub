package com.kardec.pethub.tutelado;

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
@Service("tuteladoService")
public class TuteladoService {

    @Autowired
    private TuteladoRepository tuteladoRepository;

    @Autowired
    private TuteladoMapper tuteladoMapper;

    public Page<TuteladoResponse> findAll(TuteladoRequest tuteladoRequest) {
        Page<TuteladoResponse> page = tuteladoRepository.findAll((Specification<Tutelado>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (tuteladoRequest.getNome() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + tuteladoRequest.getNome() + "%"));
            }

            if (tuteladoRequest.getTutorId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tutor").get("id"), tuteladoRequest.getTutorId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(tuteladoRequest.getPage(), tuteladoRequest.getSize())).map(tuteladoMapper::mapToDto);

        return page;
    }

    public TuteladoResponse findById(Long id) {
        return tuteladoRepository.findById(id)
                .map(tuteladoMapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Tutelado não encontrado"));
    }


    public TuteladoResponse create(TuteladoRequest tuteladoRequest) {
        Tutelado tutelado = tuteladoMapper.mapToEntity(tuteladoRequest);

        Tutelado tuteladoEntity = tuteladoRepository.save(tutelado);

        return tuteladoMapper.mapToDto(tuteladoEntity);
    }

    public TuteladoResponse update(TuteladoRequest tuteladoRequest) {
        Tutelado tutelado = tuteladoRepository.findById(tuteladoRequest.getId())
                .orElseThrow(() -> new NoSuchElementException("Tutelado não encontrado"));

        tuteladoMapper.updateTuteladoFromDto(tuteladoRequest, tutelado);

        return tuteladoMapper.mapToDto(tuteladoRepository.save(tutelado));

    }

    public void delete(Long id) {
        tuteladoRepository.deleteById(id);
    }
}
