-- Criar a tabela tb_product
CREATE TABLE IF NOT EXISTS tb_product (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    price FLOAT,
    status VARCHAR(20)
);

-- Inserir dados de exemplo
INSERT INTO tb_product (id, name, price, status) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Product 1', 10.99, 'active');
INSERT INTO tb_product (id, name, price, status) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Product 2', 20.99, 'active');
INSERT INTO tb_product (id, name, price, status) VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Product 3', 30.99, 'inactive');