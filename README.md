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
    bonus DOUBLE,
    linguagem VARCHAR(100),
    instituicao VARCHAR(255)
);

INSERT INTO funcionario (codigo, nome, idade, email, cargo, salario, rua, cidade, bonus, linguagem, instituicao) VALUES 
(101, 'Juan Vila Nova', 17, 'paulista69@gmail.com', 'Gerente', 15000.00, 'Rua A, 1000', 'Jaboatão', 5000.00, NULL, NULL),
(102, 'Artur Tomé', 17, 'astolfo@gmail.com', 'Gerente', 20000.00, 'Rua B, 500', 'Jaboatão', 8000.00, NULL, NULL),
(103, 'João Guilherme', 17, 'joaog@oticas.com', 'Gerente', 25000.00, 'Rua C, 200', 'Jaboatão', 12000.00, NULL, NULL);

INSERT INTO funcionario (codigo, nome, idade, email, cargo, salario, rua, cidade, bonus, linguagem, instituicao) VALUES 
(201, 'Ada Lovelace', 30, 'ada@tech.com', 'Desenvolvedor', 8000.00, 'Rua dos Bits, 101', 'Recife', NULL, 'Java', NULL),
(202, 'Linus Torvalds', 40, 'linus@linux.org', 'Desenvolvedor', 9500.00, 'Av. Open Source, 404', 'Curitiba', NULL, 'C', NULL),
(203, 'James Gosling', 50, 'james@java.com', 'Desenvolvedor', 12000.00, 'Rua da JVM, 8', 'São Paulo', NULL, 'Java', NULL);

INSERT INTO funcionario (codigo, nome, idade, email, cargo, salario, rua, cidade, bonus, linguagem, instituicao) VALUES 
(301, 'Peter Parker', 20, 'peter@dailybugle.com', 'Estagiario', 1200.00, 'Rua Queens, 15', 'Nova York', NULL, NULL, 'IFPE'),
(302, 'Hermione Granger', 19, 'hermione@hogwarts.edu', 'Estagiario', 1300.00, 'Rua Grifinória, 934', 'Londres', NULL, NULL, 'UFPE'),
(303, 'Miles Morales', 18, 'miles@spider.com', 'Estagiario', 1100.00, 'Rua Brooklyn, 99', 'Nova York', NULL, NULL, 'UFRPE');
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
