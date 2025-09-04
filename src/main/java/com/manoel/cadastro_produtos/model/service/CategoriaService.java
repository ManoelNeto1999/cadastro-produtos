package com.manoel.cadastro_produtos.model.service;

import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosAtualizacaoCategoria;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosCadastroCategoria;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosDetalhamentoCategoria;
import com.manoel.cadastro_produtos.model.entities.Categoria;
import com.manoel.cadastro_produtos.model.entities.Setor;
import com.manoel.cadastro_produtos.model.repository.CategoriaRepository;
import com.manoel.cadastro_produtos.model.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private SetorRepository setorRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, SetorRepository setorRepository) {
        this.categoriaRepository = categoriaRepository;
        this.setorRepository = setorRepository;
    }

    public DadosDetalhamentoCategoria cadastrar(DadosCadastroCategoria dados) {
        var buscandoSetor = setorRepository.findByNome(dados.nomeSetor());
        Setor setor = buscandoSetor.get();

        Categoria categoria = new Categoria(dados, setor);
        categoriaRepository.save(categoria);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public DadosDetalhamentoCategoria detalhar(Long id) {
        var categoria = categoriaRepository.getReferenceById(id);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public List<DadosDetalhamentoCategoria> listar() {
        List<DadosDetalhamentoCategoria> dados = categoriaRepository.findAll().stream()
                .map(c -> new DadosDetalhamentoCategoria(c)).collect(Collectors.toList());

        return dados;
    }

    public DadosDetalhamentoCategoria atualizar(DadosAtualizacaoCategoria dados) {
        var buscandoSetor = setorRepository.findByNome(dados.nomeSetor());
        var categoria = categoriaRepository.getReferenceById(dados.id());
        Setor setor = buscandoSetor.get();
        categoria.atualizar(dados, setor);

        return new DadosDetalhamentoCategoria(categoria);
    }

    public DadosDetalhamentoCategoria excluir(Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        categoriaRepository.delete(categoria);

        return new DadosDetalhamentoCategoria(categoria);
    }
}
