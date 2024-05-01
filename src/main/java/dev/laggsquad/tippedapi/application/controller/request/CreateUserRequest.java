package dev.laggsquad.tippedapi.application.controller.request;

import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotNull String email, @NotNull String password) {}
