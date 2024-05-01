package dev.laggsquad.tippedapi.domain.model.entity;

import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;

public record User(Long id, UserCredentials credentials, Double balance) implements Entity<Long> {}
