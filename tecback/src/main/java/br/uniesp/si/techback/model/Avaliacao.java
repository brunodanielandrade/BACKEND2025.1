package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;

    private int nota;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(int id, Usuario usuario, Filme filme, int nota, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.filme = filme;
        this.nota = nota;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliação: " + nota + " estrelas por " + usuario.getNome() +
                " em " + filme.getTitulo() + " - " + comentario;
    }
}

