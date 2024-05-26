package com.gpf.ti.model;

import com.gpf.ti.enums.StatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome")
    @Size(max = 30, min = 2)
    private String nome;

    @NotNull
    @Column(name = "status")
    @Size(max = 20, min = 4)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @NotNull
    @Column(name = "descricao")
    @Size(max = 255, min = 10)
    private String descricao;
}
