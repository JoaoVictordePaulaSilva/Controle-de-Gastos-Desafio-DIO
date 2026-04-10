# 💰 Controle de Gastos API

API REST para gerenciamento de despesas pessoais, desenvolvida com foco em boas práticas de arquitetura backend e persistência de dados.

## 🚀 Tecnologias Utilizadas

* **Java 21**: Linguagem principal do projeto.
* **Spring Boot 3.2.4**: Framework para agilizar o desenvolvimento da API.
* **Spring Data JPA**: Abstração da camada de persistência.
* **MySQL 8**: Banco de dados relacional.
* **Docker**: Conteinerização do banco de dados para facilitar o setup.
* **Lombok**: Redução de código boilerplate (Getters/Setters).
* **Maven**: Gerenciador de dependências e build.

## 🏗️ Arquitetura e Diferenciais

O projeto segue o padrão de camadas para garantir a separação de responsabilidades:

* **Model**: Entidade `Gasto` mapeada com JPA.
* **Repository**: Interface para comunicação com o banco de dados.
* **Service**: Camada de regras de negócio, onde reside a lógica de validação.
* **Controller**: Endpoints REST para comunicação externa.

### 🔒 Soft Delete (Exclusão Lógica)
Diferente de sistemas básicos, esta API implementa o conceito de **Soft Delete**. Ao "excluir" um gasto, o registro permanece no banco de dados com a flag `ativo = false`, garantindo a integridade histórica dos dados e auditoria.

## 🛠️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/controle-de-gastos.git](https://github.com/seu-usuario/controle-de-gastos.git)
    ```

2.  **Suba o banco de dados via Docker:**
    Certifique-se de ter o Docker instalado e rode o container do MySQL configurado.

3.  **Configure o `application.properties`:**
    Verifique as credenciais do banco em `src/main/resources/application.properties`.

4.  **Rode a aplicação:**
    Execute via IntelliJ ou pelo terminal com `./mvnw spring-boot:run`.

## 📡 Endpoints Principais

* `GET /gastos`: Lista todos os gastos ativos.
* `POST /gastos`: Cadastra um novo gasto.
* `DELETE /gastos/{id}`: Desativa um gasto (Soft Delete).