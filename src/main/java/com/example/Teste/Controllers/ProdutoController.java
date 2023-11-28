package com.example.Teste.Controllers;

import com.example.Teste.domain.produto.Produto;
import com.example.Teste.domain.produto.RepositoryProduto;
import com.example.Teste.domain.produto.RequestProduto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private RepositoryProduto repository;

    @GetMapping
    public ResponseEntity getAllProdutos(){
        var Allprodutos = repository.findAllByActiveTrue();
        return ResponseEntity.ok(Allprodutos);
    }

    @PostMapping
    public ResponseEntity registerProduto(@RequestBody @Valid RequestProduto data){
        Produto newProduto = new Produto(data);
        repository.save(newProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduto(@RequestBody @Valid RequestProduto data){
        Optional<Produto> optionalProduto = repository.findById(data.id());
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            produto.setName(data.name());
            produto.setPrince_in_cents(data.prince_in_cents());
            return ResponseEntity.ok(produto);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable String id){
        Optional<Produto> optionalProduto = repository.findById(id);
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            produto.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }

    }

}

