package com.kardec.pethub.tutor;

import com.kardec.pethub.endereco.Endereco;
import com.kardec.pethub.endereco.EnderecoResponse;
import com.kardec.pethub.tutelado.Tutelado;
import com.kardec.pethub.tutelado.TuteladoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    private List<TuteladoResponse> tutelados;
}
