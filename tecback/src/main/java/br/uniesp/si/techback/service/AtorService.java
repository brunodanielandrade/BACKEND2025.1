package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Ator;
import br.uniesp.si.techback.repository.AtorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AtorService {
    private final AtorRepository repository;

    public Ator cadastrar(Ator ator) {
        return repository.save(ator);
    }

    public Ator alterar(Ator ator) {
        if (ator.getId() == null) {
            throw new EntityNotFoundException();
        }
        return repository.save(ator);
    }

    public List<Ator> listar() {
        return repository.findAll();
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}