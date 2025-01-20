create table estacionamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    capacidade_total INTEGER,
    vagas_disponiveis INTEGER,
    valor_vaga NUMBER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

