package com.manoel.cadastro_produtos.model.service;

import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosAtualizacaoCliente;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosCadastroCliente;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosDetalhamentoCliente;
import com.manoel.cadastro_produtos.model.entities.Cliente;
import com.manoel.cadastro_produtos.model.entities.TipoPessoa;
import com.manoel.cadastro_produtos.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public DadosDetalhamentoCliente cadastrar(DadosCadastroCliente dados) {
        Cliente cliente = new Cliente(dados);
        preencherTipoPessoa(cliente);
        clienteRepository.save(cliente);

        return new DadosDetalhamentoCliente(cliente);
    }

    public DadosDetalhamentoCliente detalhar(Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);

        return new DadosDetalhamentoCliente(cliente);
    }

    public List<DadosDetalhamentoCliente> listar() {
        List<DadosDetalhamentoCliente> lista = clienteRepository.findAll().stream()
                .map(c -> new DadosDetalhamentoCliente(c)).collect(Collectors.toList());

        return lista;
    }

    public DadosDetalhamentoCliente atualizar(DadosAtualizacaoCliente dados) {
        Cliente cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizar(dados);

        return new DadosDetalhamentoCliente(cliente);
    }

    public DadosDetalhamentoCliente deletar(Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);

        return new DadosDetalhamentoCliente(cliente);
    }

    public void preencherTipoPessoa(Cliente cliente) {
        if(cliente.getCpf() != null && cliente.getTipoPessoa() == null) {
            cliente.setTipoPessoa(TipoPessoa.FISICA);
        }
        if(cliente.getCnpj() != null && cliente.getTipoPessoa() == null) {
            cliente.setTipoPessoa(TipoPessoa.JURIDICA);
        }
    }
}
