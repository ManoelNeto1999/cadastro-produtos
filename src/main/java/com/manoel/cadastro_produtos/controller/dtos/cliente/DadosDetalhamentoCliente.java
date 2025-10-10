package com.manoel.cadastro_produtos.controller.dtos.cliente;

import com.manoel.cadastro_produtos.model.entities.Cliente;
import com.manoel.cadastro_produtos.model.entities.Endereco;
import com.manoel.cadastro_produtos.model.entities.Sexo;
import com.manoel.cadastro_produtos.model.entities.TipoPessoa;

public record DadosDetalhamentoCliente(
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
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getCnpj(), cliente.getTipoPessoa(), cliente.getTelefone(), cliente.getEmail(), cliente.getSexo(), cliente.getEndereco());
    }
}
