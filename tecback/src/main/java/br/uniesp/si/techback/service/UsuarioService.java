package br.uniesp.si.techback.service;

import br.uniesp.si.techback.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public br.uniesp.si.techback.model.Usuario cadastrar(br.uniesp.si.techback.model.Usuario usuario){
        return repository.save(usuario);
    }

    public br.uniesp.si.techback.model.Usuario alterar(br.uniesp.si.techback.model.Usuario usuario) {
        if (usuario.getId() == null) {
            throw new EntityNotFoundException();
        }
        return repository.save(usuario);
    }

    public List<br.uniesp.si.techback.model.Usuario> listar(){
        return repository.findAll();
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }


}
