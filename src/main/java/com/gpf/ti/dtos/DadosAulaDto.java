package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;

import java.util.Date;

public record DadosAulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        String imagem,
        Integer duracao,
        TechnologyType tech,
        CategoryType categoria
) {}
