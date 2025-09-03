package com.manoel.cadastro_produtos.controller.dtos;

import com.manoel.cadastro_produtos.model.entities.Produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(
        Long id,
        String codigo,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidade,
        String nomeCategoria,
        Boolean ativo
) {
    public DadosDetalhamentoProduto(Produto produto) {
        this(produto.getId(), produto.getCodigo(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getCategoria().getNome(), produto.getAtivo());
    }
}
