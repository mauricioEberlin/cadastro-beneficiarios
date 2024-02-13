package com.mauricio.avaliacao.repository;

import com.mauricio.avaliacao.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {}