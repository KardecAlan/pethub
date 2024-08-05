package com.kardec.pethub.tutor;

import com.kardec.pethub.comum.PageableDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;

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
    private Long enderecoId;
    private Long tuteladoId;
}
