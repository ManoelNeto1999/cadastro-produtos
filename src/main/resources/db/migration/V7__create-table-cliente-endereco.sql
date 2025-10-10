CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE,     -- só pessoa física preenche
    cnpj VARCHAR(14) UNIQUE,    -- só pessoa jurídica preenche
    tipo_pessoa ENUM('FISICA', 'JURIDICA') NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    sexo ENUM('MASCULINO', 'FEMININO', 'OUTRO') NOT NULL
);

CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(150) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(50),
    bairro VARCHAR(100),
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    cliente_id INT UNIQUE NOT NULL,
    CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
