# Projeto Votação API

Serviços que serão utilizados para gerenciar votações de assembleias do cooperativismo.

## Dependências

Para compilar o software é necessário ter o maven instalado.

Para executar o software é necessário ter o ambiente de execução do Java (JRE) e um banco dados PostgreSQL.

## Criar base de dados

Como a aplicação depende do banco de dados para executar, é necessário seguir os passos abaixo antes de compilar ou executar o projeto.

```sql
-- criar o banco de dados
CREATE DATABASE votacao;

-- criar o usuário para o banco de dados
CREATE USER admin WITH ENCRYPTED PASSWORD 'admin';

-- dar os privilégios necessários para criação de tabelas, consultas, etc.
GRANT ALL PRIVILEGES ON DATABASE "votacao" TO admin;
```

## Executar o projeto

`mvn spring-boot:run`

## Documentação das API's

Para documentar as API's foi utilizado o Swagger, para acessar a interface, utilize o link abaixo:

[Documentação das API's](http://localhost:8080/swagger.html)
