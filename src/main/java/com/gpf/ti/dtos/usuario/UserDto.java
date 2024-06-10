package com.gpf.ti.dtos.usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotNull String login,
        @NotNull String senha,
        Boolean admin
) {}
