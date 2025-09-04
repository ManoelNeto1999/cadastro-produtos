package com.manoel.cadastro_produtos.controller.dtos.setor;

import com.manoel.cadastro_produtos.model.entities.Setor;

public record DadosDetalhamentoSetor(
        Long id,
        String nome
) {
    public DadosDetalhamentoSetor(Setor setor) {
        this(setor.getId(), setor.getNome());
    }
}
