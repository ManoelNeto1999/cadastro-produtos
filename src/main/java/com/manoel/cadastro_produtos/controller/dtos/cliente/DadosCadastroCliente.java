package com.manoel.cadastro_produtos.controller.dtos.cliente;

import com.manoel.cadastro_produtos.controller.dtos.endereco.DadosCadastroEndereco;
import com.manoel.cadastro_produtos.model.entities.Sexo;
import com.manoel.cadastro_produtos.model.entities.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(


        String nome,

        String cpf,

        String cnpj,

        TipoPessoa tipoPessoa,

        String telefone,

        @Email
        String email,

        Sexo sexo,

        @Valid
        DadosCadastroEndereco endereco
) {
}
