package com.manoel.cadastro_produtos.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosAtualizacaoSetor;
import com.manoel.cadastro_produtos.controller.dtos.setor.DadosCadastroSetor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "setor")
@Entity(name = "Setor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Setor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Categoria> categorias;

    public Setor(DadosCadastroSetor dados) {
        this.nome = dados.nome();
    }

    public void atualizar(DadosAtualizacaoSetor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
