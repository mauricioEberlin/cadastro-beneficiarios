package com.mauricio.avaliacao.service;

import com.mauricio.avaliacao.model.Documento;
import com.mauricio.avaliacao.repository.DocumentoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    public Documento findById(Long id) {
        Optional<Documento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + Documento.class.getName(), obj));
    }

    public List<Documento> findAll() {
        return repository.findAll();
    }

    public Documento save(Documento obj) {
        obj.setDataInclusao(LocalDate.now());
        return repository.save(obj);
    }

}