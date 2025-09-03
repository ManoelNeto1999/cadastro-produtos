package com.manoel.cadastro_produtos.model.repository;

import com.manoel.cadastro_produtos.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByAtivoTrue();

    Optional<Categoria> findByNome(String nome);
}
