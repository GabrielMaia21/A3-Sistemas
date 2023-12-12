package com.example.Teste.domain.cliente;

<<<<<<< HEAD

=======
>>>>>>> 43c69c08086e3c46bd35cb2ba7f3c4190f9cb32c
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryCliente extends JpaRepository<Cliente, String> {
    List<Cliente>findAllByActiveTrue();

}
