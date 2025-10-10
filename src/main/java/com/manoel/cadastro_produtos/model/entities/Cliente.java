package com.manoel.cadastro_produtos.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosAtualizacaoCliente;
import com.manoel.cadastro_produtos.controller.dtos.cliente.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cliente")
@Entity (name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(unique = true, length = 14)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", nullable = false)
    private TipoPessoa tipoPessoa;

    private String telefone;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.cnpj = dados.cnpj();
        this.tipoPessoa = dados.tipoPessoa();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.sexo = dados.sexo();
        this.adicionarEndereco(new Endereco(dados.endereco()));
    }

    public void adicionarEndereco(Endereco endereco) {
        this.endereco = endereco;
        endereco.setCliente(this);
    }

    public void atualizar(DadosAtualizacaoCliente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.cnpj() != null) {
            this.cnpj = dados.cnpj();
        }
        if (dados.tipoPessoa() != null) {
            this.tipoPessoa = dados.tipoPessoa();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.sexo() != null) {
            this.sexo = dados.sexo();
        }
        if (dados.endereco() != null) {
            Endereco enderecoAtual = this.endereco;
            enderecoAtual.atualizar(dados.endereco());
        }

    }
}
