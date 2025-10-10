package com.manoel.cadastro_produtos.validation;

import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosCadastroCliente;
import com.manoel.cadastro_produtos.model.entities.TipoPessoa;
import com.manoel.cadastro_produtos.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteValidator {

    private final ClienteRepository clienteRepository;

    public ClienteValidator(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validar(DadosCadastroCliente dados) {
        validarTipoPessoa(dados);
    }

    private void validarTipoPessoa(DadosCadastroCliente dados) {
        if(dados.cpf() != null && dados.cnpj() != null) {
            throw new ClienteValidationException("cpf e cnpj", "O cadastro deve ser realizado utilizando apenas um identificador, CPF ou CNPJ. Não é permitido informar ambos.");
        }

        if(dados.cpf() != null) {
            if(!isCpfValido(dados.cpf())) {
                throw new ClienteValidationException("cpf", "CPF inválido para pessoa física.");
            }
            if (dados.tipoPessoa() != null) {
                if(!dados.tipoPessoa().equals(TipoPessoa.FISICA)) {
                    throw new ClienteValidationException("tipoPessoa", "Pessoa jurídifca não pode ter CPF.");
                }
            }

        }

        if(dados.cnpj() != null) {
            if(!isCnpjValido(dados.cnpj())) {
                throw new ClienteValidationException("cnpj", "CNPJ inválido para pessoa jurídica.");
            }
            if (dados.tipoPessoa() != null) {
                if(!dados.tipoPessoa().equals(TipoPessoa.JURIDICA)) {
                    throw new ClienteValidationException("tipoPessoa", "Pessoa fisíca não pode ter CNPJ.");
                }
            }
        }
    }

    private boolean isCpfValido(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private boolean isCnpjValido(String cnpj) {
        return cnpj.matches("\\d{14}");
    }
}
