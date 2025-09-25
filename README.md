# Projeto

## Desenho:
-> N Usuarios
-> Nome, CPF, email, cargo, login, senha
-> N Projetos
-> Nome, Descricao, Data Inicio, Data Fim, Status (planejado, em andamento, comcluido, cancelado)
-> Gerente Responsavel
-> N Equipes
-> N Usuarios
-> Equipes podem estar associadas a N projetos

Usuarios:
Agencia
Pode ver tudo
Fornecedor
Pode ver insumos
Cliente
Preencher dados necessarios para o projeto
Projeto:
Independente
Dragoes da Real
Equipe:
Agencia
Fornecedor
Cliente

## Principais tecnologias utilizadas:
- Java 17
- JavaFX 17.0.1

## Build:

Execute o comando abaixo:

```shell
mvn clean install javafx:jlink
```

A aplicação está no seguinte caminho:
```
target/app/bin/
```

Abra o arquivo com o nome ```app``` e a aplicação ira ser executada!