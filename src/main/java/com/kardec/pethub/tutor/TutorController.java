package com.kardec.pethub.tutor;

import com.kardec.pethub.endereco.EnderecoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("tutorController")
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @Operation(summary = "Obtém todos os tutores")
    @GetMapping
    public Page<TutorResponse> findAll(@RequestParam(required = false) @Parameter(example = "Fulano de tal") String nome,
                                       @RequestParam(required = false) @Parameter(example = "fuladodetal@gmail.com") String email,
                                       @RequestParam(required = false) @Parameter(example = "123.456.789-00") String cpf,
                                       @RequestParam(required = false) @Parameter(example = "(11) 99999-9999") String telefone,
                                       @RequestParam(defaultValue = "0") @Parameter(example = "0") int page,
                                       @RequestParam(defaultValue = "10") @Parameter(example = "10") int size) {
        return tutorService.findAll(TutorRequest.builder()
                .nome(nome)
                .email(email)
                .cpf(cpf)
                .telefone(telefone)
                .page(page)
                .size(size)
                .build()
        );
    }

    @Operation(summary = "Obtém um tutor pelo id")
    @GetMapping("/{id}")
    public TutorResponse findById(@PathVariable @Parameter(example = "1") Long id) {
        return tutorService.findById(id);
    }

    @Operation(summary = "Cadastra um tutor")
    @PostMapping
    public TutorResponse store(@RequestBody TutorRequest tutorRequest) {
        return tutorService.create(tutorRequest);
    }

    @Operation(summary = "Atualiza um tutor")
    @PutMapping("/{id}")
    public TutorResponse update(@PathVariable @Parameter(example = "1") Long id, @RequestBody TutorRequest tutorRequest) {
        tutorRequest.setId(id);
        return tutorService.update(tutorRequest);
    }

    @Operation(summary = "Deleta um tutor")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(example = "1") Long id) {
        tutorService.delete(id);
    }

}
