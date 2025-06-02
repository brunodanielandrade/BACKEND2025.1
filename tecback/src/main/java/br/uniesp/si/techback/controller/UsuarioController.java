package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private final UsuarioService service;

    @GetMapping
    public List<Usuario> listar(){
        return service.listar();
    }
    @PostMapping
    public Usuario incluir (@RequestBody Usuario usuario){
        return service.cadastrar(usuario);

    }
    @PutMapping
    public Usuario alterar(@RequestBody Usuario usuario){
        return service.alterar(usuario);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity delete(Long id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}