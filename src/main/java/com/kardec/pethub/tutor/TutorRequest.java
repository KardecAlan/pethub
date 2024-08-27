package com.kardec.pethub.tutor;

import com.kardec.pethub.comum.PageableDto;
import com.kardec.pethub.endereco.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TutorRequest extends PageableDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private EnderecoRequest endereco;
}
