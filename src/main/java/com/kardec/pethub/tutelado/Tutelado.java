package com.kardec.pethub.tutelado;

import com.kardec.pethub.enums.Especie;
import com.kardec.pethub.enums.Sexo;
import com.kardec.pethub.tutor.Tutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutelado {

    @Id
    @SequenceGenerator(name = "tutelado_generator", sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tudelado_generator")
    private Long id;

    private String name;

    private Sexo sexo;

    private Especie especie;

    @ManyToOne
    private Tutor tutor;
}
