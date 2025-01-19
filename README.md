# parquimetro
Sistema de gerenciamento de parquimetro

Para criar instancia do PostgreSQL no Docker:
```shell script
docker run -d --name parquimetro -e POSTGRES_PASSWORD=p@ssw0rd -p 5432:5432 postgres:latest
```

TODO:
- Adicionar disparo de eventos nos use cases
- Criar Dockerfile
- Ajustar README