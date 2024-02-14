package com.mauricio.avaliacao.service;

import com.mauricio.avaliacao.model.Beneficiario;
import com.mauricio.avaliacao.repository.BeneficiarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    public Beneficiario findById(Long id) {
        Optional<Beneficiario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + Beneficiario.class.getName(), obj));
    }

    public List<Beneficiario> findAll() {
        return repository.findAll();
    }

    public Beneficiario save(Beneficiario obj) {
        obj.setDataInclusao(LocalDate.now());
        return repository.save(obj);
    }

    public Beneficiario update(Long id, Beneficiario obj) {
        Beneficiario newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setTelefone(obj.getTelefone());
        newObj.setDataNascimento(obj.getDataNascimento());
        newObj.setDataInclusao(obj.getDataInclusao());
        newObj.setDataAtualizacao(LocalDate.now());
        newObj.setDocumentos(obj.getDocumentos());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}