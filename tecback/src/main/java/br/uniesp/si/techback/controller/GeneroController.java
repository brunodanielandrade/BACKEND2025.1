package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.service.GeneroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> listarTodos() {
        log.info("Listando todos os gêneros");
        return generoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable Long id) {
        log.info("Buscando gênero com ID: {}", id);
        return generoService.buscarPorId(id)
                .map(genero -> {
                    log.debug("Gênero encontrado: {}", genero);
                    return ResponseEntity.ok(genero);
                })
                .orElseGet(() -> {
                    log.warn("Gênero com ID {} não encontrado", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<Genero> criar(@RequestBody Genero genero) {
        log.info("Criando novo gênero: {}", genero.getNome());
        try {
            Genero novoGenero = generoService.criar(genero);
            log.debug("Gênero criado: {}", novoGenero);
            return ResponseEntity.ok(novoGenero);
        } catch (IllegalArgumentException e) {
            log.warn("Erro ao criar gênero: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> atualizar(@PathVariable Long id, @RequestBody Genero genero) {
        log.info("Atualizando gênero com ID: {}", id);
        try {
            Genero atualizado = generoService.atualizar(id, genero);
            log.debug("Gênero atualizado: {}", atualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            log.warn("Erro ao atualizar gênero com ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Deletando gênero com ID: {}", id);
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

