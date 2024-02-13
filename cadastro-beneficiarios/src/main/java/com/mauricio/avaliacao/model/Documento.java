package com.mauricio.avaliacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_inclusao", nullable = false)
    private LocalDate dataInclusao;

    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

}