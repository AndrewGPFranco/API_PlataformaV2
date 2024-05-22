package com.gpf.ti.dtos.curso;

import com.gpf.ti.enums.StatusType;
import com.gpf.ti.model.Aula;

import java.util.List;

public record CursoDTO(
        String nome,
        StatusType status,
        List<Aula> aulas
){}
