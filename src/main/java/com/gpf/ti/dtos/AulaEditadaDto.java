package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        String imagem,
        Boolean status,
        CategoriaEnum categoria
) {}
