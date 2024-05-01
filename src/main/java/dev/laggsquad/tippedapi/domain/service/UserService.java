package dev.laggsquad.tippedapi.domain.service;

import dev.laggsquad.tippedapi.domain.model.entity.User;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import dev.laggsquad.tippedapi.domain.port.input.UserServicePort;
import dev.laggsquad.tippedapi.domain.port.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService implements UserServicePort {
  private final UserRepositoryPort userRepository;

  public void createUser(UserCredentials credentials) {
    userRepository.createUser(credentials);
  }

  public User loginUser(UserCredentials credentials) {
    final var user = userRepository.getUser(credentials);

    if (user == null) {
      // TODO: Defnine appropriate errors
      throw new RuntimeException();
    }

    return user;
  }
}
