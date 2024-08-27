package com.kardec.pethub.ficha;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("fichaController")
@RequestMapping("/fichas")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @Operation(summary = "Obtém todas as fichas")
    @GetMapping
    public Page<FichaResponse> findAll(@RequestParam(required = false) @Parameter(example = "1") Long tuteladoId,
                                       @RequestParam(required = false) @Parameter(example = "1") Long historicoClinicoId,
                                       @RequestParam(required = false) @Parameter(example = "observacoes") String observacoes,
                                       @RequestParam(defaultValue = "0") @Parameter(example = "0") int page,
                                       @RequestParam(defaultValue = "10") @Parameter(example = "10") int size) {
        return fichaService.findAll(FichaRequest.builder()
                .tuteladoId(tuteladoId)
                .historicoClinicoId(historicoClinicoId)
                .observacoes(observacoes)
                .page(page)
                .size(size)
                .build()
        );
    }

    @Operation(summary = "Obtém uma ficha pelo id")
    @GetMapping("/{id}")
    public FichaResponse findById(@PathVariable @Parameter(example = "1") Long id) {
        return fichaService.findById(id);
    }

    @Operation(summary = "Cadastra uma ficha")
    @PostMapping
    public FichaResponse store(@RequestBody FichaRequest fichaRequest) {
        return fichaService.create(fichaRequest);
    }

    @Operation(summary = "Atualiza uma ficha")
    @PutMapping("/{id}")
    public FichaResponse update(@PathVariable @Parameter(example = "1") Long id, @RequestBody FichaRequest fichaRequest) {
        fichaRequest.setId(id);
        return fichaService.update(fichaRequest);
    }

    @Operation(summary = "Deleta uma ficha")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(example = "1") Long id) {
        fichaService.delete(id);
    }
}
