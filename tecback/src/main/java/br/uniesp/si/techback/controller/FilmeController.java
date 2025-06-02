package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/filmes")

public class FilmeController {

    private final FilmeService service;

    @GetMapping
    @Cacheable("filmes_all")
    public List<Filme> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @CacheEvict("filmes_all")
    public Filme criar(@RequestBody Filme filme) {
        return service.salvar(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Long id, @RequestBody Filme filme) {
        log.info("Atualizando Filme ID {} TÍTULO {}");
        try {
            Filme atualizado = service.atualizar(id, filme);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            log.error("Erro atualizar Filme id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @CacheEvict("filmes_all")
    public void limparCacheFilmes(){
        log.info("Limpando cacho do Filme");
    }
}