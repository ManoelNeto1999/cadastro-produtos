ALTER TABLE categoria
ADD COLUMN setor_id INT,
ADD CONSTRAINT fk_categoria_setor
FOREIGN KEY (setor_id) REFERENCES setor(id);
