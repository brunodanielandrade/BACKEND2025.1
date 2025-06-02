package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
    private String perfil; // Ex: ADMIN, CLIENTE, etc.
    private Boolean ativo = true;

    public int getIdade() {
        return getIdade();
    }

}
