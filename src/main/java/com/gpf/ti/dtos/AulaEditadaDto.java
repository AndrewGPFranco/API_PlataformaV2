package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;
import com.gpf.ti.enums.TechnologyEnum;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        String imagem,
        String url,
        Boolean status,
        CategoriaEnum categoria,
        TechnologyEnum tech
) {}
