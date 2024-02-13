package com.mauricio.avaliacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "beneficiarios")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_inclusao", nullable = false)
    private LocalDate dataInclusao;

    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Documento> documentos;

}