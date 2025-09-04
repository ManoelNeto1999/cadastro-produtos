package com.manoel.cadastro_produtos.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosAtualizacaoCategoria;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosCadastroCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;


    public Categoria(DadosCadastroCategoria dados, Setor setor) {
        this.nome = dados.nome();
        this.setor = setor;
    }

    public void atualizar(DadosAtualizacaoCategoria dados, Setor setor) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (setor != null) {
            this.setor = setor;
        }
    }

}
