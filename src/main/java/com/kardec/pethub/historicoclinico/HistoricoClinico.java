package com.kardec.pethub.historicoclinico;

import com.kardec.pethub.ficha.Ficha;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoClinico {

    @Id
    @SequenceGenerator(name = "historico_clinico_generator", sequenceName = "historico_clinico_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_clinico_generator")
    private Long id;

    private String medicamentos;

    private String suplementacao;

    private String exames;

    private String cirurgias;

    private String alergias;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "historicoClinico")
    private Ficha ficha;


}
