package com.example.Teste.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCliente (
        String id,
        @NotBlank
        String name,

        @NotNull
        String telefone) {
<<<<<<< HEAD
}
=======
}
>>>>>>> 43c69c08086e3c46bd35cb2ba7f3c4190f9cb32c
