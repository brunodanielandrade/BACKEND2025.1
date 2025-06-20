package br.uniesp.si.techback.repository;
import br.uniesp.si.techback.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    boolean existsByNome(String nome);
}