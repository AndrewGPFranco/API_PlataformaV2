package com.gpf.ti.dtos.aula;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;

import java.util.Date;

public record AulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        Integer duracao,
        String imagem,
        String url,
        TechnologyType tech,
        CategoryType categoria
) {}