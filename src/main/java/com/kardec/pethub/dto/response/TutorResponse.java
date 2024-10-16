package com.kardec.pethub.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private EnderecoResponse endereco;
}
