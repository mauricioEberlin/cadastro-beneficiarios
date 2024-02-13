package com.mauricio.avaliacao.controller;

import com.mauricio.avaliacao.model.Beneficiario;
import com.mauricio.avaliacao.service.BeneficiarioService;
import com.mauricio.avaliacao.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
@Tag(name = "Beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @Autowired
    private DocumentoService documentoService;

    @Operation(summary = "Realiza a busca de todos os beneficiários cadastrados")
    @GetMapping
    public ResponseEntity<Object> buscarTodosBeneficiarios() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Realiza a busca de todos os documentos de um determinado beneficiário")
    @GetMapping("/documentos/{id}")
    public ResponseEntity<Object> buscarDocumentosPorBeneficiario(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id).getDocumentos());
    }

    @Operation(summary = "Realiza o cadastro de um beneficiário e o cadastro opcional de seus documentos")
    @PostMapping("/persistir")
    public ResponseEntity<Object> persistirBeneficiario(@RequestBody @Validated Beneficiario beneficiario) {
        if(!beneficiario.getDocumentos().isEmpty()) {
            beneficiario.getDocumentos().forEach(documento -> documentoService.save(documento));
        }
        return ResponseEntity.ok(service.save(beneficiario));
    }

    @Operation(summary = "Edita os dados de um beneficiário")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> editarBeneficiario(@PathVariable Long id, @RequestBody @Validated Beneficiario beneficiario) {
        Beneficiario beneficiarioAtualizado = service.update(id, beneficiario);
        return ResponseEntity.ok().body(beneficiarioAtualizado);
    }

    @Operation(summary = "Realiza a exclusão de um beneficiário")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarBeneficiarioPorId(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}