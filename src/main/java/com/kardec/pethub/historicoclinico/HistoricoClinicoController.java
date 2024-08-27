package com.kardec.pethub.historicoclinico;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("historicoClinicoController")
@RequestMapping("/historicosclinico")
public class HistoricoClinicoController {

    @Autowired
    private HistoricoClinicoService historicoClinicoService;

    @Operation(summary = "Obtém todos os históricos clínicos")
    @GetMapping
    public Page<HistoricoClinicoResponse> findAll(@RequestParam(required = false) String medicamentos,
                                                   @RequestParam(required = false) String suplementacao,
                                                   @RequestParam(required = false) String exames,
                                                   @RequestParam(required = false) String cirurgias,
                                                   @RequestParam(required = false) String alergias,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return historicoClinicoService.findAll(HistoricoClinicoRequest.builder()
                .medicamentos(medicamentos)
                .suplementacao(suplementacao)
                .exames(exames)
                .cirurgias(cirurgias)
                .alergias(alergias)
                .page(page)
                .size(size)
                .build()
        );
    }

    @Operation(summary = "Obtém um histórico clínico pelo id")
    @GetMapping("/{id}")
    public HistoricoClinicoResponse findById(@PathVariable @Parameter(example = "1") Long id) {
        return historicoClinicoService.findById(id);
    }

    @Operation(summary = "Cadastra um histórico clínico")
    @PostMapping
    public HistoricoClinicoResponse store(@RequestBody HistoricoClinicoRequest historicoClinicoRequest) {
        return historicoClinicoService.create(historicoClinicoRequest);
    }

    @Operation(summary = "Atualiza um histórico clínico")
    @PutMapping("/{id}")
    public HistoricoClinicoResponse update(@PathVariable @Parameter(example = "1") Long id, @RequestBody HistoricoClinicoRequest historicoClinicoRequest) {
        historicoClinicoRequest.setId(id);
        return historicoClinicoService.update(historicoClinicoRequest);
    }

    @Operation(summary = "Deleta um histórico clínico")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(example = "1") Long id) {
        historicoClinicoService.delete(id);
    }
}
