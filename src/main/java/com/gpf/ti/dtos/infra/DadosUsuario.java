package com.gpf.ti.dtos.infra;

import com.gpf.ti.enums.LevelType;

public record DadosUsuario(String login, String nomeCompleto, Boolean admin, LevelType nivel) {}
