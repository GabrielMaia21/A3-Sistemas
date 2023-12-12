package com.example.Teste.domain.cliente;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryCliente extends JpaRepository<Cliente, String> {
    List<Cliente>findAllByActiveTrue();

}
