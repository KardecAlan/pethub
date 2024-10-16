package com.kardec.pethub.model;

import com.kardec.pethub.enums.Especie;
import com.kardec.pethub.enums.Sexo;
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

    private String nome;

    private Sexo sexo;

    private Especie especie;

    private int idade;

    private int peso;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
}
