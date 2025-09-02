package com.manoel.cadastro_produtos.model.repository;

import com.manoel.cadastro_produtos.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByAtivoTrue();
}
