package com.manoel.cadastro_produtos.model.service;

import com.manoel.cadastro_produtos.controller.dtos.DadosAtualizacaoProduto;
import com.manoel.cadastro_produtos.controller.dtos.DadosCadastroProduto;
import com.manoel.cadastro_produtos.controller.dtos.DadosDetalhamentoProduto;
import com.manoel.cadastro_produtos.model.entities.Categoria;
import com.manoel.cadastro_produtos.model.entities.Produto;
import com.manoel.cadastro_produtos.model.repository.CategoriaRepository;
import com.manoel.cadastro_produtos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private CategoriaRepository categoriaRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public DadosDetalhamentoProduto cadastrar(DadosCadastroProduto dados) {
        var buscandoCategoria = categoriaRepository.findByNome(dados.nomeCategoria());
        Categoria categoria = buscandoCategoria.get();

        Produto produto = new Produto(dados, categoria);
        produtoRepository.save(produto);

        return new DadosDetalhamentoProduto(produto);
    }

    public DadosDetalhamentoProduto detalhar(Long id) {
        var produto = produtoRepository.getReferenceById(id);

        return new DadosDetalhamentoProduto(produto);
    }

    public List<DadosDetalhamentoProduto> listar() {
        List<DadosDetalhamentoProduto> dados = produtoRepository.findAllByAtivoTrue().stream()
                .map(p -> new DadosDetalhamentoProduto(p)).collect(Collectors.toList());

        return dados;
    }

    public DadosDetalhamentoProduto atualizar(DadosAtualizacaoProduto dados) {
        var produto = produtoRepository.getReferenceById(dados.id());
        produto.atualizar(dados);

        return new DadosDetalhamentoProduto(produto);
    }

    public DadosDetalhamentoProduto excluir(Long id) {
        var produto = produtoRepository.getReferenceById(id);
        produto.excluir();

        return new DadosDetalhamentoProduto(produto);
    }
}
