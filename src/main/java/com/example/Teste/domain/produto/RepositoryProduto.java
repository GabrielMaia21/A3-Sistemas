package com.example.Teste.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryProduto extends JpaRepository<Produto,String> {
    List<Produto>findAllByActiveTrue();
}
