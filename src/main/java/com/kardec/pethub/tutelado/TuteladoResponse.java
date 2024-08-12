package com.kardec.pethub.tutelado;

import com.kardec.pethub.enums.Especie;
import com.kardec.pethub.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TuteladoResponse {

    private Long id;
    private String nome;
    private Sexo sexo;
    private Especie especie;
    private Long tutorId;
}
