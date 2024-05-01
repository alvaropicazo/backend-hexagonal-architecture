package dev.laggsquad.tippedapi.infrastructure;

import dev.laggsquad.tippedapi.domain.port.input.UserServicePort;
import dev.laggsquad.tippedapi.domain.port.output.UserRepositoryPort;
import dev.laggsquad.tippedapi.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {
  @Bean
  UserServicePort createUserPort(UserRepositoryPort userRepository) {
    return new UserService(userRepository);
  }

  @Bean
  PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }
}
