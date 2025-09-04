package com.manoel.cadastro_produtos.controller;

import com.manoel.cadastro_produtos.controller.dtos.produto.DadosAtualizacaoProduto;
import com.manoel.cadastro_produtos.controller.dtos.produto.DadosCadastroProduto;
import com.manoel.cadastro_produtos.controller.dtos.produto.DadosDetalhamentoProduto;
import com.manoel.cadastro_produtos.model.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroProduto dados) {
        var dto = produtoService.cadastrar(dados);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = produtoService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoProduto>> listar() {
        var dto = produtoService.listar();

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoProduto dados) {
        var dto = produtoService.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var dto = produtoService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dto);
    }
}
