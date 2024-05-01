package dev.laggsquad.tippedapi.domain.port.input;

import dev.laggsquad.tippedapi.domain.model.entity.User;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;

public interface UserServicePort {
  public void createUser(UserCredentials credentials);

  public User loginUser(UserCredentials credentials);
}
