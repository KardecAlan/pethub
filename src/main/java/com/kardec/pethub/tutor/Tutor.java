package com.kardec.pethub.tutor;

import com.kardec.pethub.endereco.Endereco;
import com.kardec.pethub.tutelado.Tutelado;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutelado_id")
    private Tutelado tutelado;




}
