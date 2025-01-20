create table ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa_veiculo VARCHAR(15) NOT NULL,
    horario_entrada TIMESTAMP,
    horario_saida TIMESTAMP,
    pago NUMBER,
    estacionamento_id BIGINT,
    valor_pago NUMBER
)