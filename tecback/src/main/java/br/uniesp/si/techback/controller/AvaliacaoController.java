package br.uniesp.si.techback.controller;
import br.uniesp.si.techback.model.Avaliacao;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {
    private final AvaliacaoService service;

    @PostMapping
    public void criarAvaliacao(@RequestBody Usuario usuario,
                               @RequestBody Filme filme,
                               @RequestParam int nota,
                               @RequestParam String comentario) {
        log.info("Criando nova avaliação");
        log.debug("Usuário: {}, Filme: {}, Nota: {}, Comentário: {}", usuario, filme, nota, comentario);
        service.adicionarAvaliacao(usuario, filme, nota, comentario);
    }

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        log.info("Listando todas as avaliações");
        return service.listarAvaliacoes();
    }

    @GetMapping("/{id}")
    public Avaliacao buscarAvaliacao(@PathVariable int id) {
        log.info("Buscando avaliação com ID: {}", id);
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizarAvaliacao(@PathVariable int id,
                                   @RequestParam int novaNota,
                                   @RequestParam String novoComentario) {
        log.info("Atualizando avaliação ID: {}", id);
        log.debug("Nova nota: {}, Novo comentário: {}", novaNota, novoComentario);
        service.atualizarAvaliacao(id, novaNota, novoComentario);
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable int id) {
        log.info("Removendo avaliação com ID: {}", id);
        service.removerAvaliacao(id);
    }
}