package com.gpf.ti.dtos;

public record AulaEditadaDto(
        String titulo,
        String descricao,
        Integer duracao,
        String imagem,
        String url,
        Boolean status,
        String tech,
        String categoria
) {}
