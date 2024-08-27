package com.kardec.pethub.tutelado;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("tuteladoController")
@RequestMapping("/tutelados")
public class TuteladoController {

    @Autowired
    private TuteladoService tuteladoService;

    @Operation(summary = "Obtém todos os tutelados")
    @GetMapping
    public Page<TuteladoResponse> fndAll(@RequestParam(required = false) @Parameter(example = "Banguela") String nome,
                                      @RequestParam(required = false) @Parameter(example = "1") Long tutorId,
                                      @RequestParam(defaultValue = "0") @Parameter(example = "0") int page,
                                        @RequestParam(defaultValue = "10") @Parameter(example = "10") int size) {
        return tuteladoService.findAll(TuteladoRequest.builder()
                .nome(nome)
                .tutorId(tutorId)
                .page(page)
                .size(size)
                .build()
        );

    }

    @Operation(summary = "Obtém um tutelado pelo id")
    @GetMapping("/{id}")
    public TuteladoResponse findById(@Parameter(example = "1") Long id) {
        return tuteladoService.findById(id);
    }

    @Operation(summary = "Cadastra um tutelado")
    @PostMapping
    public TuteladoResponse store(@RequestBody TuteladoRequest tuteladoRequest) {
        return tuteladoService.create(tuteladoRequest);
    }

    @Operation(summary = "Atualiza um tutelado")
    @PutMapping("/{id}")
    public TuteladoResponse update(@PathVariable @Parameter(example = "1") Long id, @RequestBody TuteladoRequest tuteladoRequest) {
        tuteladoRequest.setId(id);
        return tuteladoService.update(tuteladoRequest);
    }

    @Operation(summary = "Deleta um tutelado")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(example = "1") Long id) {
        tuteladoService.delete(id);
    }

}
