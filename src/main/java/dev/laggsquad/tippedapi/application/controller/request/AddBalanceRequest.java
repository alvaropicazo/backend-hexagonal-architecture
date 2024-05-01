package dev.laggsquad.tippedapi.application.controller.request;

import jakarta.validation.constraints.NotNull;

public record AddBalanceRequest(@NotNull Long id, @NotNull Double balance) {}
