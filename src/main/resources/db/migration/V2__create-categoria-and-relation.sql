-- 1. Criar tabela categoria
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- 2. Alterar tabela produto e adicionar chave estrangeira
ALTER TABLE produto
    ADD COLUMN categoria_id INT,
    ADD CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id) REFERENCES categoria(id);
