package com.gpf.ti.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "cadastro")
    private Date cadastro;

    @NotNull
    @Column(name = "duracao")
    private Integer duracao;

    @NotNull
    @Column(name = "status")
    private Boolean status;

    @NotNull
    @Column(name = "imagem")
    private String imagem;

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "tech")
    private String tech;

    @NotNull
    @Column(name = "categoria")
    private String categoria;

    public Aula() {}

    public Aula(Long id, String nomeDaAula) {}

    public Aula(
            String titulo,
            String descricao,
            Date cadastro,
            Integer duracao,
            String imagem,
            String url,
            Boolean status,
            String tech,
            String categoria
    ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cadastro = cadastro;
        this.duracao = duracao;
        this.imagem = imagem;
        this.url = url;
        this.status = status;
        this.tech = tech;
        this.categoria = categoria;
    }
}
