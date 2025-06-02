package br.uniesp.si.techback.controller;
import br.uniesp.si.techback.model.ListaFavoritos;
import br.uniesp.si.techback.service.ListaFavoritosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/favoritos")
@Slf4j
@RequiredArgsConstructor
@RestController

public class ListaFavoritosController {
    @Autowired
    private ListaFavoritosService listaFavoritosService;

    @PostMapping
    public ResponseEntity<ListaFavoritos> adicionarFavorito(
            @RequestParam Long usuarioId,
            @RequestParam Long filmeId) {
        log.info("Adicionando filme {} à lista de favoritos do usuário {}", filmeId, usuarioId);
        try {
            ListaFavoritos favorito = listaFavoritosService.adicionarFilmeFavorito(usuarioId, filmeId);
            log.debug("Favorito adicionado: {}", favorito);
            return ResponseEntity.ok(favorito);
        } catch (IllegalArgumentException e) {
            log.warn("Erro ao adicionar favorito: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<ListaFavoritos>> listarFavoritos(@PathVariable Long usuarioId) {
        log.info("Listando favoritos do usuário {}", usuarioId);
        List<ListaFavoritos> favoritos = listaFavoritosService.listarFavoritosDoUsuario(usuarioId);
        log.debug("Favoritos encontrados: {}", favoritos.size());
        return ResponseEntity.ok(favoritos);
    }

    @DeleteMapping("/{favoritoId}")
    public ResponseEntity<Void> removerFavorito(@PathVariable Long favoritoId) {
        log.info("Removendo favorito com ID {}", favoritoId);
        listaFavoritosService.removerFavorito(favoritoId);
        return ResponseEntity.noContent().build();
    }
}