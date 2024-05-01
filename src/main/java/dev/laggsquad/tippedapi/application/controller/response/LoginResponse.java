package dev.laggsquad.tippedapi.application.controller.response;

import dev.laggsquad.tippedapi.domain.model.entity.User;

public record LoginResponse(Long id, String email) {

  public static LoginResponse fromUser(User user) {
    return new LoginResponse(user.id(), user.credentials().email());
  }
}
