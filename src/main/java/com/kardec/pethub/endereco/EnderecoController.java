package com.kardec.pethub.endereco;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("enderecoController")
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Obtém todos os endereços")
    @GetMapping
    public Page<EnderecoResponse> findAll(@RequestParam(required = false) @Parameter(example = "Bairro dos Bobos") String bairro,
                                          @RequestParam(required = false) @Parameter(example = "Cidade dos Bobos") String cidade,
                                          @RequestParam(required = false) @Parameter(example = "12345-678") String cep,
                                          @RequestParam(defaultValue = "0") @Parameter(example = "0") int page,
                                          @RequestParam(defaultValue = "10") @Parameter(example = "10") int size) {
        return enderecoService.findAll(EnderecoRequest.builder()
                .bairro(bairro)
                .cidade(cidade)
                .cep(cep)
                .page(page)
                .size(size)
                .build()
        );
    }

    @Operation(summary = "Obtém um endereço pelo id")
    @GetMapping("/{id}")
    public EnderecoResponse findById(@PathVariable @Parameter(example = "1") Long id) {
        return enderecoService.findById(id);
    }

    @Operation(summary = "Cadastra um endereço")
    @PostMapping
    public EnderecoResponse store(@RequestBody EnderecoRequest enderecoRequest) {
        return enderecoService.create(enderecoRequest);
    }

    @Operation(summary = "Atualiza um endereço")
    @PutMapping("/{id}")
    public EnderecoResponse update(@PathVariable @Parameter(example = "1") Long id, @RequestBody EnderecoRequest enderecoRequest) {
        enderecoRequest.setId(id);
        return enderecoService.update(enderecoRequest);
    }

    @Operation(summary = "Deleta um endereço")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(example = "1") Long id) {
        enderecoService.delete(id);
    }




}
