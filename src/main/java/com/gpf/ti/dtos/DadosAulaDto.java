package com.gpf.ti.dtos;

import com.gpf.ti.enums.CategoriaEnum;

import java.util.Date;

public record DadosAulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        String imagem,
        Integer duracao,
        CategoriaEnum categoria
) {}
