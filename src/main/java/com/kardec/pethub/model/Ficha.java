package com.kardec.pethub.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ficha {

    @Id
    @SequenceGenerator(name = "ficha_generator", sequenceName = "ficha_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ficha_generator")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Tutelado tutelado;

    @OneToOne(cascade = CascadeType.ALL)
    private HistoricoClinico historicoClinico;

    private String observacoes;

}
