package com.manoel.cadastro_produtos.controller;

import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosAtualizacaoCategoria;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosCadastroCategoria;
import com.manoel.cadastro_produtos.controller.dtos.categoria.DadosDetalhamentoCategoria;
import com.manoel.cadastro_produtos.model.service.CategoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCategoria dados) {
        var dto = categoriaService.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = categoriaService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCategoria>> listar() {
        var lista = categoriaService.listar();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoCategoria dados) {
        var dto = categoriaService.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var dto = categoriaService.excluir(id);

        return ResponseEntity.ok(dto);
    }
}
