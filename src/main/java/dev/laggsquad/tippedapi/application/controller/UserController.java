package dev.laggsquad.tippedapi.application.controller;

import dev.laggsquad.tippedapi.application.controller.request.CreateUserRequest;
import dev.laggsquad.tippedapi.application.controller.request.LoginRequest;
import dev.laggsquad.tippedapi.application.controller.response.LoginResponse;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import dev.laggsquad.tippedapi.domain.port.input.UserServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserServicePort userService;

  @PostMapping
  public void createUser(@Valid @RequestBody CreateUserRequest request) {
    final var credentials = new UserCredentials(request.email(), request.password());

    userService.createUser(credentials);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest request) {
    final var credentials = new UserCredentials(request.email(), request.password());
    final var user = userService.loginUser(credentials);

    return ResponseEntity.ok(LoginResponse.fromUser(user));
  }
}
