package com.manoel.cadastro_produtos.controller.dtos.categoria;

import com.manoel.cadastro_produtos.model.entities.Categoria;
import com.manoel.cadastro_produtos.model.entities.Setor;

public record DadosDetalhamentoCategoria(
        Long id,
        String nome,
        Setor setor
) {
    public DadosDetalhamentoCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.getSetor());
    }


}
