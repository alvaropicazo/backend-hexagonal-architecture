package dev.laggsquad.tippedapi.domain.service;

import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;
import dev.laggsquad.tippedapi.domain.port.input.BalanceServicePort;
import dev.laggsquad.tippedapi.domain.port.output.BalanceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BalanceService implements BalanceServicePort {
  private final BalanceRepositoryPort balanceRepository;

  public void addBalance(AddBalanceObject addBalanceObj) {
    balanceRepository.addBalance(addBalanceObj);
  }

  public Double getBalance(String id) {
    return balanceRepository.getBalance(id);
  }
}
