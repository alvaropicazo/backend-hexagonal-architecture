package dev.laggsquad.tippedapi.infrastructure.repository;

import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;
import dev.laggsquad.tippedapi.domain.port.output.BalanceRepositoryPort;
import dev.laggsquad.tippedapi.infrastructure.repository.model.UserDataModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.Long.parseLong;

@Component
@RequiredArgsConstructor
public class BalanceRepository implements BalanceRepositoryPort {
    private final UserPostgresRepository postgresRepository;

    public void addBalance(AddBalanceObject balanceObject) {
        var userToFind = postgresRepository.findById(balanceObject.id());
        if (userToFind.isEmpty()) {
            // TODO: Define appropriate errors
            throw new RuntimeException("User Not Found");
        } else {
            UserDataModel userFound = userToFind.get();
            userFound.setNewBalance(userToFind.get().mapToUser().balance() + balanceObject.balance());
            postgresRepository.save(userFound);
        }
    }

    public Double getBalance(String id) {
        var user = postgresRepository.findById(parseLong(id));
        if (user.isEmpty()) {
            throw new RuntimeException("User Not Found");
        } else {
           return user.get().mapToUser().balance();
        }
    }
}
