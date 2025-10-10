package com.manoel.cadastro_produtos.controller.dtos.cliente;

import com.manoel.cadastro_produtos.model.entities.Endereco;
import com.manoel.cadastro_produtos.model.entities.Sexo;
import com.manoel.cadastro_produtos.model.entities.TipoPessoa;

public record DadosAtualizacaoCliente(
        Long id,
        String nome,
        String cpf,
        String cnpj,
        TipoPessoa tipoPessoa,
        String telefone,
        String email,
        Sexo sexo,
        Endereco endereco
) {
}
