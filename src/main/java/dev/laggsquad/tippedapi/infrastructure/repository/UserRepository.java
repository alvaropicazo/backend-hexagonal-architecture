package dev.laggsquad.tippedapi.infrastructure.repository;

import dev.laggsquad.tippedapi.domain.model.entity.User;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import dev.laggsquad.tippedapi.domain.port.output.UserRepositoryPort;
import dev.laggsquad.tippedapi.infrastructure.repository.model.UserDataModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepository implements UserRepositoryPort {
  private final UserPostgresRepository postgresRepository;
  private final PasswordEncoder passwordEncoder;

  public User createUser(UserCredentials credentials) {
    if (postgresRepository.findByEmail(credentials.email()) != null) {
      // TODO: Define appropriate errors
      throw new RuntimeException();
    }

    final var encodedPassword = passwordEncoder.encode(credentials.password());
    final var userData = new UserDataModel(credentials.email(), encodedPassword, 0.0);
    postgresRepository.save(userData);

    return userData.mapToUser();
  }

  public User getUser(UserCredentials credentials) {
    final var user = postgresRepository.findByEmail(credentials.email());

    if (user == null) {
      // TODO: Define appropriate errors
      throw new RuntimeException();
    }

    if (!passwordEncoder.matches(credentials.password(), user.getPassword())) {
      // TODO: Define appropriate errors
      throw new RuntimeException();
    }

    return user.mapToUser();
  }
}
