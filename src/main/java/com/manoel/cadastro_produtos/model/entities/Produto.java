package com.manoel.cadastro_produtos.model.entities;

import com.manoel.cadastro_produtos.controller.dtos.DadosAtualizacaoProduto;
import com.manoel.cadastro_produtos.controller.dtos.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private Boolean ativo;

    public Produto (DadosCadastroProduto dados, Categoria categoria) {
        this.codigo = dados.codigo();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.categoria = categoria;
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoProduto dados) {
        if (dados.codigo() != null) {
            this.codigo = dados.codigo();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.quantidade() != null) {
            this.quantidade = dados.quantidade();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
