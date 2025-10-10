package com.manoel.cadastro_produtos.controller;

import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosAtualizacaoCliente;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosCadastroCliente;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosDetalhamentoCliente;
import com.manoel.cadastro_produtos.model.service.ClienteService;
import com.manoel.cadastro_produtos.validation.ClienteValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private ClienteService clienteService;
    private ClienteValidator clienteValidator;

    public ClienteController(ClienteValidator clienteValidator, ClienteService clienteService) {
        this.clienteValidator = clienteValidator;
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCliente dados) {
        clienteValidator.validar(dados);
        var dto = clienteService.cadastrar(dados);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = clienteService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCliente>> listar() {
        var lista = clienteService.listar();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoCliente dados) {
        var dto = clienteService.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var dto = clienteService.deletar(id);

        return ResponseEntity.ok(dto);
    }
}
