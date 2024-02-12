package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

import java.util.Date;

public record AulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        Integer duracao,
        Boolean status,
        CategoriaEnum categoria
) {}