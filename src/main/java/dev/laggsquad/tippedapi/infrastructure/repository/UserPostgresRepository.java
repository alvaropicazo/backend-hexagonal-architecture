package dev.laggsquad.tippedapi.infrastructure.repository;

import dev.laggsquad.tippedapi.infrastructure.repository.model.UserDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostgresRepository extends JpaRepository<UserDataModel, Long> {
  UserDataModel findByEmail(String email);
}
