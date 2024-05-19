package com.gpf.ti.dtos.aula;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        String imagem,
        String url,
        TechnologyType tech,
        CategoryType categoria
) {}
