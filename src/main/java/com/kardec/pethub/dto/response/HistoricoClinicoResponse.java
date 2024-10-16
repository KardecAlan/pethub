package com.kardec.pethub.dto.response;

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
public class HistoricoClinicoResponse {

    private Long id;
    private String medicamentos;
    private String suplementacao;
    private String exames;
    private String cirurgias;
    private String alergias;
    private FichaResponse ficha;

}
