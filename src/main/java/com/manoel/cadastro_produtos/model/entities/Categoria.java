package com.manoel.cadastro_produtos.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manoel.cadastro_produtos.controller.dtos.DadosAtualizacaoCategoria;
import com.manoel.cadastro_produtos.controller.dtos.DadosCadastroCategoria;
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

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Produto> produtos;

    private Boolean ativo;

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoCategoria dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
