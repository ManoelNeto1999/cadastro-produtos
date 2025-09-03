package com.manoel.cadastro_produtos.model.service;

import com.manoel.cadastro_produtos.controller.dtos.DadosAtualizacaoCategoria;
import com.manoel.cadastro_produtos.controller.dtos.DadosCadastroCategoria;
import com.manoel.cadastro_produtos.controller.dtos.DadosDetalhamentoCategoria;
import com.manoel.cadastro_produtos.model.entities.Categoria;
import com.manoel.cadastro_produtos.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public DadosDetalhamentoCategoria cadastrar(DadosCadastroCategoria dados) {
        Categoria categoria = new Categoria(dados);
        categoriaRepository.save(categoria);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public DadosDetalhamentoCategoria detalhar(Long id) {
        var categoria = categoriaRepository.getReferenceById(id);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public List<DadosDetalhamentoCategoria> listar() {
        List<DadosDetalhamentoCategoria> dados = categoriaRepository.findAllByAtivoTrue().stream()
                .map(c -> new DadosDetalhamentoCategoria(c)).collect(Collectors.toList());

        return dados;
    }

    public DadosDetalhamentoCategoria atualizar(DadosAtualizacaoCategoria dados) {
        var categoria = categoriaRepository.getReferenceById(dados.id());
        categoria.atualizar(dados);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public DadosDetalhamentoCategoria excluir(Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        categoria.excluir();

        return new DadosDetalhamentoCategoria(categoria);
    }
}
