package com.kardec.pethub.endereco;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco_generator", sequenceName = "endereco_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_generator")
    private Long id;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;
}
