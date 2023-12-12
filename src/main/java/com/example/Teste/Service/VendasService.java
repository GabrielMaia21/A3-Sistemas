package com.example.Teste.Service;

import com.example.Teste.domain.vendas.RepositoryVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasService {
    @Autowired
    private RepositoryVendas RepositoryVendas;
}


