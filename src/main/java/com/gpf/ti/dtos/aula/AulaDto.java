package com.gpf.ti.dtos.aula;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AulaDto(
        @NotNull String titulo,
        @NotNull String descricao,
        @NotNull Date cadastro,
        @NotNull Integer duracao,
        @NotNull String imagem,
        @NotNull String url,
        @NotNull TechnologyType tech,
        @NotNull CategoryType categoria,
        @NotNull String curso
) {}