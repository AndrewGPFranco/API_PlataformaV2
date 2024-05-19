package com.gpf.ti.dtos.aluno;

import com.gpf.ti.enums.LevelType;

public record AlunoDto(String nome, LevelType nivel, String email) {}
