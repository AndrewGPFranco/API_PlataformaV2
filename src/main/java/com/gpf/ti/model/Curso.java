package com.gpf.ti.model;

import com.gpf.ti.enums.StatusType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aula> aulas;

    public Curso() {}

    public Curso(String nome, StatusType status, List<Aula> aulas) {
        this.nome = nome;
        this.status = status;
        this.aulas = aulas;
    }
}
