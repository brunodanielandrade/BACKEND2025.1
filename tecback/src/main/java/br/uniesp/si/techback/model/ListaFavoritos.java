package br.uniesp.si.techback.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ListaFavoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;

    // Construtores
    public ListaFavoritos() {}

    public ListaFavoritos(Usuario usuario, Filme filme) {
        this.usuario = usuario;
        this.filme = filme;
    }
}
