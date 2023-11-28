package com.example.Teste.domain.produto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduto(

        String id,
        @NotBlank
        String name,

        @NotNull
        Integer prince_in_cents) {
}
