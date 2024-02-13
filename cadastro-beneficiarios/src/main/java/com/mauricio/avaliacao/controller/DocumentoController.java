package com.mauricio.avaliacao.controller;

import com.mauricio.avaliacao.model.Documento;
import com.mauricio.avaliacao.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@Tag(name = "Documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @Operation(summary = "Realiza a busca de todos os documentos cadastrados")
    @GetMapping
    public List<Documento> getDocumentos() {
        return service.findAll();
    }

    @Operation(summary = "Cadastra um documento")
    @PostMapping("/persistir")
    public ResponseEntity<Object> persistirDocumento(@RequestBody @Validated Documento documento) {
        return ResponseEntity.ok(service.save(documento));
    }

}