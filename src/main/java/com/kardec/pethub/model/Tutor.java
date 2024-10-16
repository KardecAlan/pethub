package com.kardec.pethub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @Id
    @SequenceGenerator(name = "tutor_generator", sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutor_generator")
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private List<Tutelado> tutelados;

}
