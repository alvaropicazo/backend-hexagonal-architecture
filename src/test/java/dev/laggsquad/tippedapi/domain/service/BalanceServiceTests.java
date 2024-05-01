package dev.laggsquad.tippedapi.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;
import dev.laggsquad.tippedapi.domain.model.value.UserCredentials;
import dev.laggsquad.tippedapi.domain.port.output.BalanceRepositoryPort;
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
class BalanceServiceTests {
    @MockBean private BalanceRepositoryPort balanceRepositoryMock;
    private BalanceService balanceService = new BalanceService(balanceRepositoryMock);

    @Test
    public void whenAddBalanceWithInvalidId_thenErrorShouldBeThrown() {
        // Given
        final var balance = new AddBalanceObject(1L, +10.0);
        Mockito.doThrow(new RuntimeException()).when(balanceRepositoryMock).addBalance(balance);

        // When
        final Executable expression =
                () -> {
                    balanceService.addBalance(balance);
                };

        // Then
        assertThrows(RuntimeException.class, expression);
    }

    @Test
    public void whenGetBalanceWithInvalidId_thenErrorShouldBeThrown() {
        // Given
        Mockito.doThrow(new RuntimeException()).when(balanceService).getBalance("1");

        // When
        final Executable expression =
                () -> {
                    balanceService.getBalance("1");
                };

        // Then
        assertThrows(RuntimeException.class, expression);
    }
}
