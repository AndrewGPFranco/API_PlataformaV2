package com.gpf.ti.dtos.usuario;

import com.gpf.ti.enums.GeneroType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserDto(
        @NotNull String login,
        @NotNull String senha,
        @NotNull Boolean admin,
        @NotNull String nomeCompleto,
        @NotNull LocalDate dataNascimento,
        @NotNull @Enumerated(EnumType.STRING) GeneroType genero,
        @NotNull String telefone
) {}
