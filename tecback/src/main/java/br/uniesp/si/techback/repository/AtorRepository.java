package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository
        extends JpaRepository<Ator, Integer> {
}
