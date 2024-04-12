package com.gpf.ti.dtos;

import java.util.Date;

public record AulaDto(
        String titulo,
        String descricao,
        Date cadastro,
        Integer duracao,
        String imagem,
        String url,
        Boolean status
) {}