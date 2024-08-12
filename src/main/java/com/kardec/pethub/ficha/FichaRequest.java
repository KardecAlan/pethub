package com.kardec.pethub.ficha;

import com.kardec.pethub.comum.PageableDto;
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
public class FichaRequest extends PageableDto {

    private Long id;
    private Long tuteladoId;
    private Long historicoClinicoId;
    private String observacoes;
}
