package br.uniesp.si.techback.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String genero;
    private Long anoLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Long anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}