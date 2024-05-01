package dev.laggsquad.tippedapi.application.controller.response;

public record GetBalanceResponse(Double balance) {

    public static GetBalanceResponse balanceFromId(Double balance) {
        return new GetBalanceResponse(balance);
    }
}

