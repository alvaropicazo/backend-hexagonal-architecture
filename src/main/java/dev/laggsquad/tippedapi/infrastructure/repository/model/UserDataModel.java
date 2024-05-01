package dev.laggsquad.tippedapi.infrastructure.repository.model;

import dev.laggsquad.tippedapi.domain.model.entity.User;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(schema = "waiter", name = "user")
@RequiredArgsConstructor
public class UserDataModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "balance")
  private Double balance;

  public UserDataModel(String email, String password, Double balance) {
    this.email = email;
    this.password = password;
    this.balance = balance;
  }

  // Mapping methods

  public User mapToUser() {
    final var credentials = new UserCredentials(this.email, this.password);
    return new User(this.id, credentials, this.balance);
  }

  public void setNewBalance(Double newBalance) {
    this.balance = newBalance;
  }
}
