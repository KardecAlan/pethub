package com.kardec.pethub.historicoclinico;

import com.kardec.pethub.ficha.Ficha;
import com.kardec.pethub.ficha.FichaRepository;
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
@Service("HistoricoClinicoService")
public class HistoricoClinicoService {

    @Autowired
    private HistoricoClinicoRepository historicoClinicoRepository;

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private HistoricoClinicoMapper historicoClinicoMapper;

    public Page<HistoricoClinicoResponse> findAll(HistoricoClinicoRequest historicoClinicoRequest) {
        Page<HistoricoClinicoResponse> page = historicoClinicoRepository.findAll((Specification<HistoricoClinico>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (historicoClinicoRequest.getFichaId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("ficha").get("id"), historicoClinicoRequest.getFichaId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        }, PageRequest.of(historicoClinicoRequest.getPage(), historicoClinicoRequest.getSize())).map(historicoClinicoMapper::mapToDto);

        return page;
    }

    public HistoricoClinicoResponse findById(Long id) {
        return historicoClinicoRepository.findById(id)
                .map(historicoClinicoMapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Histórico clínico não encontrado"));
    }


    public HistoricoClinicoResponse create(HistoricoClinicoRequest historicoClinicoRequest) {
        Ficha ficha = fichaRepository.findById(historicoClinicoRequest.getFichaId())
                .orElseThrow(() -> new NoSuchElementException("Ficha não encontrada"));

        HistoricoClinico historicoClinico = historicoClinicoMapper.mapToEntity(historicoClinicoRequest);
        historicoClinico.setFicha(ficha);

        return historicoClinicoMapper.mapToDto(historicoClinicoRepository.save(historicoClinico));
    }


    public HistoricoClinicoResponse update(HistoricoClinicoRequest historicoClinicoRequest) {
        HistoricoClinico historicoClinico = historicoClinicoRepository.findById(historicoClinicoRequest.getId())
                .orElseThrow(() -> new NoSuchElementException("Histórico clínico não encontrado"));

        historicoClinicoMapper.updateHistoricoClinicoFromDto(historicoClinicoRequest, historicoClinico);

        return historicoClinicoMapper.mapToDto(historicoClinicoRepository.save(historicoClinico));
    }

    public void delete(Long id) {
        historicoClinicoRepository.deleteById(id);
    }
}
