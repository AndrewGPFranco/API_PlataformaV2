package com.gpf.ti.dtos.usuario;

import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotNull String login,
        @NotNull String senha,
        @NotNull Boolean admin
) {}
