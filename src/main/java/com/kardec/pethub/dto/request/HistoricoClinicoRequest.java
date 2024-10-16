package com.kardec.pethub.dto.request;

import com.kardec.pethub.dto.PageableDto;
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
public class HistoricoClinicoRequest extends PageableDto {

    private Long id;
    private String medicamentos;
    private String suplementacao;
    private String exames;
    private String cirurgias;
    private String alergias;
    private Long fichaId;
}
