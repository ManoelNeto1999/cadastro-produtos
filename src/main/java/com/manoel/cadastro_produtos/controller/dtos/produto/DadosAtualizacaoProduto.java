package com.manoel.cadastro_produtos.controller.dtos.produto;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        Long id,
        String codigo,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidade,
        String nomeCategoria
) {
}
