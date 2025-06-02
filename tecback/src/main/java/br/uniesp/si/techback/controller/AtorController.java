package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Ator;
import br.uniesp.si.techback.service.AtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/ator")
public class AtorController {

    private final AtorService service;

    @GetMapping
    public List<Ator> listar(){
        return service.listar();
    }
@PostMapping
    public Ator incluir (@RequestBody Ator ator){
        return service.cadastrar(ator);

    }
    @PutMapping
    public Ator alterar(@RequestBody Ator ator){
        return service.alterar(ator);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity delete(Integer id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}