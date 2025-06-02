package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.model.ListaFavoritos;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.FilmeRepository;
import br.uniesp.si.techback.repository.ListaFavoritosRepository;
import br.uniesp.si.techback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaFavoritosService {

    @Autowired
    private ListaFavoritosRepository listaFavoritosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public ListaFavoritos adicionarFilmeFavorito(Long usuarioId, Long filmeId) {
        if (listaFavoritosRepository.existsByUsuarioIdAndFilmeId(usuarioId, filmeId)) {
            throw new IllegalArgumentException("Esse filme já está na lista de favoritos");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (usuario.getIdade() < 7) {
            throw new IllegalArgumentException("Usuário não tem idade suficiente para favoritar este filme.");
        }

        ListaFavoritos favorito = new ListaFavoritos(usuario, filme);
        return listaFavoritosRepository.save(favorito);
    }

    public List<ListaFavoritos> listarFavoritosDoUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return listaFavoritosRepository.findByUsuario(usuario);
    }

    public void removerFavorito(Long favoritoId) {
        listaFavoritosRepository.deleteById(favoritoId);
    }
}