package com.kardec.pethub.tutor;

import com.kardec.pethub.endereco.Endereco;
import com.kardec.pethub.tutelado.Tutelado;
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
    private Endereco endereco;
    private Tutelado tutelado;
}
