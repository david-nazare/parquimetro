# parquimetro
Sistema de gerenciamento de parquimetro

Para criar o banco:
```shell script
docker run -d --name parquimetro -e POSTGRES_PASSWORD=p@ssw0rd -p 5432:5432 postgres:latest
```