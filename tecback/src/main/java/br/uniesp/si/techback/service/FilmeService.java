package br.uniesp.si.techback.service;

import br.uniesp.si.techback.Client.OmdbClient;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(Long id, Filme filmeAtualizado) {
        return repository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setGenero(filmeAtualizado.getGenero());
                    return repository.save(filme);
                }).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private OmdbClient omdbClient;

    public void buscarFilmeExterno(String titulo) {
        JSONObject filmeJson = omdbClient.buscarFilmePorTitulo(titulo);
        System.out.println("Título: " + filmeJson.getString("Title"));
        System.out.println("Ano: " + filmeJson.getString("Year"));
        System.out.println("Classificação: " + filmeJson.getString("Rated"));
    }

}
