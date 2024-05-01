package dev.laggsquad.tippedapi.domain.port.output;
import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;


public interface BalanceRepositoryPort {
    void addBalance(AddBalanceObject object);

    Double getBalance(String id);

}
