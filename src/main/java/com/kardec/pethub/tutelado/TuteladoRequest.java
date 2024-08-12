package com.kardec.pethub.tutelado;

import com.kardec.pethub.comum.PageableDto;
import com.kardec.pethub.enums.Especie;
import com.kardec.pethub.enums.Sexo;
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
public class TuteladoRequest extends PageableDto {

    private Long id;
    private String nome;
    private Sexo sexo;
    private Especie especie;
    private Long tutorId;

}
