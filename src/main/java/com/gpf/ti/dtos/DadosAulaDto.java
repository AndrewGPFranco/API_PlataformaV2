package com.gpf.ti.dtos;

import java.util.Date;

public record DadosAulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        String imagem,
        Integer duracao,
        String tech,
        String categoria
) {}
