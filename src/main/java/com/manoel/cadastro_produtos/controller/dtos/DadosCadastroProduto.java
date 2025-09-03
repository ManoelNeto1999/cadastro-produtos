package com.manoel.cadastro_produtos.controller.dtos;

import com.manoel.cadastro_produtos.model.entities.Categoria;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        String codigo,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidade,
        String nomeCategoria) {
}
