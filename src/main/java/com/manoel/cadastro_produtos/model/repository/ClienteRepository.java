package com.manoel.cadastro_produtos.model.repository;

import com.manoel.cadastro_produtos.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
