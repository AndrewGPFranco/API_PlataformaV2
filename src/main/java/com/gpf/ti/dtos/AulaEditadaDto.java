package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

import java.util.Date;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        Boolean status,
        CategoriaEnum categoria
) {}
