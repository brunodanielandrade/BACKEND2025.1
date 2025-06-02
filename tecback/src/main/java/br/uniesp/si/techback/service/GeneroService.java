package br.uniesp.si.techback.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.List;

@RequiredArgsConstructor
@Service

public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Optional<Genero> buscarPorId(Long id) {
        return generoRepository.findById(id);
    }

    public Genero criar(Genero genero) {
        if (generoRepository.existsByNome(genero.getNome())) {
            throw new IllegalArgumentException("Gênero já existe");
        }
        return generoRepository.save(genero);
    }

    public Genero atualizar(Long id, Genero generoAtualizado) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado"));

        genero.setNome(generoAtualizado.getNome());
        return generoRepository.save(genero);
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }

}
