package com.gpf.ti.model;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String titulo;

    @NotNull
    @Column(name = "descricao")
    @NotBlank
    private String descricao;

    @NotNull
    @Column(name = "cadastro")
    private Date cadastro;

    @NotNull
    @Column(name = "duracao")
    private Integer duracao;

    @NotNull
    @Column(name = "imagem")
    @NotBlank
    private String imagem;

    @NotNull
    @Column(name = "url")
    @NotBlank
    private String url;

    @NotNull
    @Column(name = "tech")
    @Enumerated(EnumType.STRING)
    private TechnologyType tech;

    @NotNull
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoryType categoria;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Aula() {}

    public Aula(Long id, String nomeDaAula) {}

    public Aula(
            String titulo,
            String descricao,
            Date cadastro,
            Integer duracao,
            String imagem,
            String url,
            TechnologyType tech,
            CategoryType categoria
    ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cadastro = cadastro;
        this.duracao = duracao;
        this.imagem = imagem;
        this.url = url;
        this.tech = tech;
        this.categoria = categoria;
    }
}
