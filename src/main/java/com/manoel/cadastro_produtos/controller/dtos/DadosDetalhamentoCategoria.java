package com.manoel.cadastro_produtos.controller.dtos;

import com.manoel.cadastro_produtos.model.entities.Categoria;

public record DadosDetalhamentoCategoria(
        Long id,
        String nome
) {
    public DadosDetalhamentoCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }


}
