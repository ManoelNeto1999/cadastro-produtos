CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) UNIQUE,   -- código comercial (SKU, código de barras, etc.)
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    ativo TINYINT(1) NOT NULL DEFAULT 1  -- 1 = ativo, 0 = inativo
);

