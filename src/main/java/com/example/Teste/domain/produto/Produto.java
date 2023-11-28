package com.example.Teste.domain.produto;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String name;

    private Integer prince_in_cents;

    private Boolean active;

    public Produto(RequestProduto requestProduto){
        this.name = requestProduto.name();
        this.prince_in_cents = requestProduto.prince_in_cents();
        this.active = true;
    }
}
