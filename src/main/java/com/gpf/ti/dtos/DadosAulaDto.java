package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;
import lombok.Data;

import java.util.Date;

@Data
public class DadosAulaDto {
    private String titulo;

    private String descricao;

    private Date cadastro;

    private Integer duracao;

    private CategoriaEnum categoria;

    public DadosAulaDto() {}

    public DadosAulaDto(String titulo, String descricao, Date cadastro, Integer duracao, CategoriaEnum categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cadastro = cadastro;
        this.duracao = duracao;
        this.categoria = categoria;
    }
}
