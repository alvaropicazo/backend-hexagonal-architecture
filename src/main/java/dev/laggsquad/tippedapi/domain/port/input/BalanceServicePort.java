package dev.laggsquad.tippedapi.domain.port.input;

import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;

public interface BalanceServicePort {
  public void addBalance(AddBalanceObject addBalanceObj);

  public Double getBalance(String id);
}
