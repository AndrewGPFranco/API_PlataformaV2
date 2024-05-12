package com.gpf.ti.model;

import com.gpf.ti.enums.LevelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "nivel")
    @Enumerated(EnumType.STRING)
    private LevelType nivel;

    @NotNull
    @Column(name = "email")
    private String email;

    public Aluno() {}

    public Aluno(String name, LevelType level, String email) {
        this.nome = name;
        this.nivel = level;
        this.email = email;
    }
}
