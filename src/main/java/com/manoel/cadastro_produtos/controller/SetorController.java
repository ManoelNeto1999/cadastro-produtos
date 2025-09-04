package com.manoel.cadastro_produtos.controller;

import com.manoel.cadastro_produtos.controller.dtos.setor.DadosAtualizacaoSetor;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosCadastroSetor;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosDetalhamentoSetor;
import com.manoel.cadastro_produtos.model.service.SetorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroSetor dados) {
        var dto = setorService.cadastrar(dados);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = setorService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoSetor>> listar() {
        var lista = setorService.listar();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoSetor dados) {
        var dto = setorService.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var dto = setorService.excluir(id);

        return ResponseEntity.ok(dto);
    }
}
