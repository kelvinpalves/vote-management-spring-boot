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

## Executar os testes unitários

`mvn test`

## Documentação das API's

Para documentar as API's foi utilizado o Swagger, para acessar a interface, utilize o link abaixo:

[Documentação das API's](http://localhost:8080/swagger.html)

### Exemplos:

[Exemplo de criação de pauta](https://github.com/kelvinpalves/votacao/blob/master/src/main/resources/exemplos/criar-pauta.sh)

[Exemplo de criação de sessão para pauta 1](https://github.com/kelvinpalves/votacao/blob/master/src/main/resources/exemplos/criar-sessao.sh)

[Exemplo de tentativa de voto para sessão 1](https://github.com/kelvinpalves/votacao/blob/master/src/main/resources/exemplos/votar.sh)

[Exemplo de busca pelo resultado da votação](https://github.com/kelvinpalves/votacao/blob/master/src/main/resources/exemplos/resultado-votacao.sh)

