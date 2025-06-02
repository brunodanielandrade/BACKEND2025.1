package br.uniesp.si.techback.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.uniesp.si.techback.model.ListaFavoritos;
import br.uniesp.si.techback.model.Usuario;

import java.util.List;

public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos, Long> {
    List<ListaFavoritos> findByUsuario(Usuario usuario);
    boolean existsByUsuarioIdAndFilmeId(Long usuarioId, Long filmeId);
}