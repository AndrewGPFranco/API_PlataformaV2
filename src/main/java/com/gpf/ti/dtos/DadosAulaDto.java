package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;
import com.gpf.ti.enums.TechnologyEnum;

import java.util.Date;

public record DadosAulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        String imagem,
        Integer duracao,
        CategoriaEnum categoria,
        TechnologyEnum tech
) {}
