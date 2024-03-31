package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

import java.util.Date;

public record AulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        Integer duracao,
        String imagem,
        String url,
        Boolean status,
        CategoriaEnum categoria,
        String tech
) {}