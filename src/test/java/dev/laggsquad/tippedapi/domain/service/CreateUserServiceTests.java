package dev.laggsquad.tippedapi.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import dev.laggsquad.tippedapi.domain.port.output.UserRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(
    properties = {
      "spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false",
      "spring.jpa.hibernate.ddl-auto=none"
    })
class UserServiceTests {
  @MockBean private UserRepositoryPort userRepositoryMock;
  private UserService userService = new UserService(userRepositoryMock);

  @Test
  public void whenCreateUserWithInvalidEmail_thenErrorShouldBeThrown() {
    // Given
    final var credentials = new UserCredentials("test@test.com", "testPassword");
    Mockito.doThrow(new RuntimeException()).when(userRepositoryMock).createUser(credentials);

    // When
    final Executable expression =
        () -> {
          userService.createUser(credentials);
        };

    // Then
    assertThrows(RuntimeException.class, expression);
  }

  @Test
  public void whenLoginUserWithInvalidCredentials_thenErrorShouldBeThrown() {
    // Given
    final var credentials = new UserCredentials("test@test.com", "testPassword");
    Mockito.doThrow(new RuntimeException()).when(userRepositoryMock).getUser(credentials);

    // When
    final Executable expression =
        () -> {
          userService.loginUser(credentials);
        };

    // Then
    assertThrows(RuntimeException.class, expression);
  }
}
