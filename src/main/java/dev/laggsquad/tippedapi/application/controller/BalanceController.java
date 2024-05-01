package dev.laggsquad.tippedapi.application.controller;

import dev.laggsquad.tippedapi.application.controller.request.AddBalanceRequest;
import dev.laggsquad.tippedapi.application.controller.response.GetBalanceResponse;
import dev.laggsquad.tippedapi.domain.model.value.AddBalanceObject;
import dev.laggsquad.tippedapi.domain.port.input.BalanceServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {
  private final BalanceServicePort balanceService;

  @PostMapping
  public void addBalance(@Valid @RequestBody AddBalanceRequest request) {
    final var balanceObject = new AddBalanceObject(request.id(), request.balance());

    balanceService.addBalance(balanceObject);
  }

  @GetMapping
  public ResponseEntity<GetBalanceResponse> getBalance(@Valid @RequestParam String id) {
    final var balance = balanceService.getBalance(id);
    return ResponseEntity.ok(GetBalanceResponse.balanceFromId(balance));
  }
}
