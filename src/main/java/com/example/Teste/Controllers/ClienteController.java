package com.example.Teste.Controllers;

import com.example.Teste.domain.cliente.Cliente;
import com.example.Teste.domain.cliente.RepositoryCliente;
import com.example.Teste.domain.cliente.RequestCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@RestController

@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private RepositoryCliente repository;

    @GetMapping
    public ResponseEntity getAllClientes() {
        var Allclientes = repository.findAllByActiveTrue();
        return ResponseEntity.ok(Allclientes);
    }

    @PostMapping
    public ResponseEntity registerCliente(@RequestBody @Valid RequestCliente data){
        Cliente newCliente = new Cliente(data);
        repository.save(newCliente);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateCliente(@RequestBody @Valid RequestCliente data){
        Optional<Cliente> optionalCliente = repository.findById(data.id());
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setName(data.name());
            cliente.setTelefone(data.telefone());
            return ResponseEntity.ok(cliente);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCliente(@PathVariable String id){
        Optional<Cliente> optionalCliente = repository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }

    }

}

