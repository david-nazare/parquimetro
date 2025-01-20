# Parquimetro
Sistema de gerenciamento de parquimetro

Este é um sistema de controle de parquímetro desenvolvido em Java, com suporte para gerenciamento de estacionamentos e controle de estadias. O sistema inclui os seguintes casos de uso principais:

- **Cadastrar Estacionamento**: Registra um novo estacionamento no sistema.
- **Entrar na Garagem**: Registra a entrada de um veículo.
- **Pagar Estadia**: Gerencia o pagamento da estadia.
- **Sair da Garagem**: Registra a saída de um veículo e verifica a quitação da estadia.

O projeto utiliza **Docker** para facilitar o ambiente de desenvolvimento e **PostgreSQL** como banco de dados.

---

## Tecnologias Utilizadas

- **Java**: Linguagem principal para o desenvolvimento do sistema.
- **Spring Boot**: Framework para a criação de APIs e serviços.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados.
- **Docker**: Ferramenta para containerização e simplificação do ambiente.
- **Maven**: Gerenciador de dependências e build.

---

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)

---

## Configuração do Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/david-nazare/parquimetro.git
cd parquimetro
```

2. Configurar o Banco de Dados com Docker
Use o Docker Compose para configurar o PostgreSQL. Certifique-se de que o arquivo docker-compose.yml está presente no diretório raiz.

```bash
docker-compose up -d
```
3. Endpoints da API
Abaixo estão os principais endpoints disponíveis:

# Cadastrar Estacionamento
POST /estacionamentos
Body:
json
{
  "nome": "Estacionamento Central",
  "endereco": "Rua Principal, 123",
  "capacidade": 50,
  "capacidadeTotal": 40,
  "vagasDisponiveis": 40,
  "valorVaga": 14.5
}

# Entrar na Garagem
POST: /ticket
Body:
```json
{
  "id": null,
  "placaVeiculo": "PDD4T98",
  "horarioEntrada": "2025-01-19T17:30",
  "horarioSaida": null,
  "pago": false,
  "estacionamentoId": 6,
  "valorPago": null
}
```

# Pagar Estadia
PUT /ticket/pagar/{ticketId}

# Sair da Garagem
PUT /ticket/sair/{ticketId}

## Contribuição
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

Fork este repositório.
Crie uma branch para sua feature: git checkout -b minha-feature.
Faça as alterações necessárias e commit: git commit -m 'Minha nova feature'.
Envie as alterações para o repositório remoto: git push origin minha-feature.
Abra um Pull Request.

## Contato
Caso tenha dúvidas ou sugestões, entre em contato:

Email: dsnazare@icloud.com
LinkedIn: David Nazare

TODO:
- Testar Docker Compose
- Finalizar documento PDF
- [Bonus] Refatorar codigo
