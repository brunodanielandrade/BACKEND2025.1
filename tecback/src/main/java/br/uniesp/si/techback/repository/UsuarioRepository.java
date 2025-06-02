package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //gerenciado pelo spring
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
