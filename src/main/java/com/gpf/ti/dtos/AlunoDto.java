package com.gpf.ti.dtos;

import com.gpf.ti.enums.LevelType;

public record AlunoDto(String nome, LevelType nivel, String email) {}
