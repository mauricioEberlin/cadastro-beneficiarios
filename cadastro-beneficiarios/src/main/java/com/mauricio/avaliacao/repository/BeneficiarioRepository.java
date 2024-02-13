package com.mauricio.avaliacao.repository;

import com.mauricio.avaliacao.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {}