package com.manoel.cadastro_produtos.model.service;

import com.manoel.cadastro_produtos.controller.dtos.setor.DadosAtualizacaoSetor;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosCadastroSetor;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosDetalhamentoSetor;
import com.manoel.cadastro_produtos.model.entities.Setor;
import com.manoel.cadastro_produtos.model.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public DadosDetalhamentoSetor cadastrar(DadosCadastroSetor dados) {
        Setor setor = new Setor(dados);
        setorRepository.save(setor);

        return new DadosDetalhamentoSetor(setor);
    }

    public DadosDetalhamentoSetor detalhar(Long id) {
        Setor setor = setorRepository.getReferenceById(id);

        return new DadosDetalhamentoSetor(setor);
    }

    public List<DadosDetalhamentoSetor> listar() {
        List<DadosDetalhamentoSetor> dados = setorRepository.findAll().stream()
                .map(s -> new DadosDetalhamentoSetor(s)).collect(Collectors.toList());

        return dados;
    }

    public DadosDetalhamentoSetor atualizar(DadosAtualizacaoSetor dados) {
        var setor = setorRepository.getReferenceById(dados.id());
        setor.atualizar(dados);

        return new DadosDetalhamentoSetor(setor);
    }

    public DadosDetalhamentoSetor excluir(Long id) {
        Setor setor = setorRepository.getReferenceById(id);
        setorRepository.delete(setor);

        return new DadosDetalhamentoSetor(setor);
    }
}
