package com.kardec.pethub.ficha;

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
public class FichaResponse {

    private Long id;
    private Long tuteladoId;
    private Long historicoClinicoId;
    private String observacoes;
}
