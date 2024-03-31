package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;
import com.gpf.ti.enums.TechnologyEnum;

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
        TechnologyEnum tech
) {}