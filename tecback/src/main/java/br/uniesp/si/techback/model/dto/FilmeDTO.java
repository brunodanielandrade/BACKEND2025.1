package br.uniesp.si.techback.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class FilmeDTO {


    private Integer id;
    private String titulo;
    private String autor;
}
