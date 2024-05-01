package dev.laggsquad.tippedapi.domain.port.output;

import dev.laggsquad.tippedapi.domain.model.entity.User;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;

public interface UserRepositoryPort {
  User createUser(UserCredentials credentials);

  User getUser(UserCredentials credentials);
}
