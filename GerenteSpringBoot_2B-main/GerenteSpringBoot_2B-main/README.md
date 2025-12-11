# FuncionarioSpringBoot_2B

Projeto desenvolvido para a disciplina de **Programação 2 (4º Bimestre)** no IFPE.

O objetivo principal deste repositório foi sair do desenvolvimento em console (Java puro) e migrar para uma aplicação Web estruturada, focando inicialmente no cadastro e gestão de Gerentes.

## 🎯 O que foi feito

Transformamos um sistema simples de terminal numa aplicação Web funcional usando **Spring Boot**. O foco não foi criar o sistema mais complexo, mas sim entender e aplicar na prática:

* **Arquitetura MVC:** Separar a lógica (Model), as telas (View) e o controle de fluxo (Controller).
* **Injeção de Dependência:** Deixar o Spring gerir os objetos em vez de instanciar tudo manualmente.
* **Persistência Real:** Conectar a aplicação a um banco MySQL de verdade.

## 🛠️ Tecnologias

* Java 21
* Spring Boot 3 (Web, Thymeleaf, JDBC)
* MySQL
* Maven
* HTML/CSS

## 🚀 Como Rodar

### 1. Banco de Dados
Certifique-se de que o MySQL está rodando e crie o banco com este script:

```sql
CREATE DATABASE IF NOT EXISTS funcionarios;
USE funcionarios;

CREATE TABLE IF NOT EXISTS funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo INT,
    nome VARCHAR(255),
    idade INT,
    email VARCHAR(255),
    cargo VARCHAR(50),
    salario DOUBLE,
    rua VARCHAR(255),
    cidade VARCHAR(255),
    bonus DOUBLE
);
````

### 2\. Configuração

Verifique se a senha e usuário no arquivo `src/main/resources/application.properties` correspondem ao seu MySQL local.

### 3\. Execução

Abra o terminal na pasta do projeto e rode:

  * **Windows:** `.\mvnw.cmd spring-boot:run`
  * **Linux/Mac:** `./mvnw spring-boot:run`

### 4\. Acesso

Abra o navegador em: [http://localhost:8081/cadastro](https://www.google.com/search?q=http://localhost:8081/cadastro)

## 👨‍💻 Autores

  * [Juan Vila Nova](https://github.com/juanvnrojas)
  * [João Guilherme](https://github.com/Guilherme-lopes-F)
  * [Artur Tomé](https://github.com/ArturTome)

-----

Instituto Federal de Pernambuco (IFPE) - Jaboatão dos Guararapes
