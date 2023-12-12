package com.example.Teste.domain.cliente;

import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD


@Table (name = "cliente")
@Entity (name = "cliente")
=======
@Entity(name =  "cliente")
@Table(name = "cliente")
>>>>>>> 43c69c08086e3c46bd35cb2ba7f3c4190f9cb32c
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@EqualsAndHashCode (of = "id")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
=======
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

>>>>>>> 43c69c08086e3c46bd35cb2ba7f3c4190f9cb32c
    private String id;

    private String name;

    private String telefone;

    private boolean active;

    public Cliente(RequestCliente requestCliente){
        this.name = requestCliente.name();
        this.telefone = requestCliente.telefone();
        this.active = true;
    }
}
