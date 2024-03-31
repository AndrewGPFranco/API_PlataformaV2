package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        String imagem,
        String url,
        Boolean status,
        CategoriaEnum categoria,
        String tech
) {}
