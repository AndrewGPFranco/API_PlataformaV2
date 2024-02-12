package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;
import lombok.Data;

import java.util.Date;

@Data
public class AulaDto {
    private String titulo;

    private String descricao;

    private Date cadastro;

    private Integer duracao;

    private Boolean status;

    private CategoriaEnum categoria;

    public AulaDto(String titulo, String descricao, Date cadastro, Integer duracao, Boolean status, CategoriaEnum categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cadastro = cadastro;
        this.duracao = duracao;
        this.status = status;
        this.categoria = categoria;
    }
}
