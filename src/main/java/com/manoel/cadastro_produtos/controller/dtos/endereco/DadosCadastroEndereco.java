package com.manoel.cadastro_produtos.controller.dtos.endereco;

public record DadosCadastroEndereco(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}
