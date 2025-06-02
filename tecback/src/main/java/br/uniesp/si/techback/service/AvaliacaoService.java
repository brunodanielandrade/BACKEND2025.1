package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Avaliacao;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.AvaliacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public void adicionarAvaliacao(Usuario usuario, Filme filme, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(0, usuario, filme, nota, comentario);
        repository.save(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return repository.findAll();
    }

    public Avaliacao buscarPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada"));
    }

    public void atualizarAvaliacao(int id, int novaNota, String novoComentario) {
        Avaliacao avaliacao = buscarPorId(id); // agora usa findById
        avaliacao.setNota(novaNota);
        avaliacao.setComentario(novoComentario);
        repository.save(avaliacao); // save serve para atualizar também
    }

    public void removerAvaliacao(int id) {
        repository.deleteById(id);
    }
}
