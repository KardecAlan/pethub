package com.kardec.pethub.ficha;

import com.kardec.pethub.tutelado.Tutelado;
import com.kardec.pethub.tutelado.TuteladoRepository;
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
@Service("fichaService")
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private FichaMapper fichaMapper;

    @Autowired
    private TuteladoRepository tuteladoRepository;

    public Page<FichaResponse> findAll(FichaRequest fichaRequest) {
        Page<FichaResponse> page = fichaRepository.findAll((Specification<Ficha>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (fichaRequest.getTuteladoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tutelado").get("id"), fichaRequest.getTuteladoId()));
            }

            if (fichaRequest.getHistoricoClinicoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("historicoClinico").get("id"), fichaRequest.getHistoricoClinicoId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        }, PageRequest.of(fichaRequest.getPage(), fichaRequest.getSize())).map(fichaMapper::mapToDto);

        return page;
    }

    public FichaResponse findById(Long id) {
        return fichaRepository.findById(id)
                .map(fichaMapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Ficha não encontrada"));
    }

    public FichaResponse create(FichaRequest fichaRequest) {

       Tutelado tutelado = tuteladoRepository.findById(fichaRequest.getTuteladoId())
               .orElseThrow(() -> new NoSuchElementException("Tutelado não encontrado"));

       Ficha fichaEntity = fichaMapper.mapToEntity(fichaRequest);
       fichaEntity.setTutelado(tutelado);

       Ficha ficha = fichaRepository.save(fichaEntity);

       return fichaMapper.mapToDto(ficha);
    }

    public FichaResponse update(FichaRequest fichaRequest) {
        Ficha ficha = fichaRepository.findById(fichaRequest.getId())
                .orElseThrow(() -> new NoSuchElementException("Ficha não encontrada"));

        fichaMapper.updateFichaFromDto(fichaRequest, ficha);

        Ficha fichaEntity = fichaRepository.save(ficha);

        return fichaMapper.mapToDto(fichaEntity);
    }

    public void delete(Long id) {
        fichaRepository.deleteById(id);
    }
}
