package com.kardec.pethub.endereco;

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
@Service("enderecoService")
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;


    public Page<EnderecoResponse> findAll(EnderecoRequest enderecoRequest) {
        Page<EnderecoResponse> page = enderecoRepository.findAll((Specification<Endereco>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (enderecoRequest.getBairro() != null) {
                predicates.add(criteriaBuilder.like(root.get("bairro"), "%" + enderecoRequest.getBairro() + "%"));
            }

            if (enderecoRequest.getCidade() != null) {
                predicates.add(criteriaBuilder.like(root.get("cidade"), "%" + enderecoRequest.getCidade() + "%"));
            }

            if (enderecoRequest.getCep() != null) {
                predicates.add(criteriaBuilder.like(root.get("cep"), "%" + enderecoRequest.getCep() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(enderecoRequest.getPage(), enderecoRequest.getSize())).map(enderecoMapper::mapToDto);

        return page;
    }

    public EnderecoResponse findById(Long id) {
        return enderecoRepository.findById(id)
                .map(enderecoMapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("Endereço não encontrado"));
    }

    public EnderecoResponse create(EnderecoRequest enderecoRequest) {
        Endereco endereco = enderecoMapper.mapToEntity(enderecoRequest);

        Endereco enderecoEntity = enderecoRepository.save(endereco);

        return enderecoMapper.mapToDto(enderecoEntity);
    }

    public EnderecoResponse update(EnderecoRequest enderecoRequest) {
        Endereco endereco = enderecoMapper.mapToEntity(enderecoRequest);

        Endereco enderecoEntity = enderecoRepository.save(endereco);

        return enderecoMapper.mapToDto(enderecoEntity);
    }

    public void delete(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Endereço não encontrado"));

        enderecoRepository.delete(endereco);
    }
}
