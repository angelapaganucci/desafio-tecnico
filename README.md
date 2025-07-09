# 📦 API de Catálogo de Produtos e Pedidos

Este projeto é uma aplicação backend desenvolvida com **Spring Boot** que oferece uma API REST para:

- Cadastro, consulta, atualização e remoção de produtos
- Simulação de pedidos com múltiplos itens
- Validações com Bean Validation
- Boas práticas REST com uso de DTOs, Service Layer, Mapper e tratamento global de exceções

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database (em memória)
- Bean Validation
- Postman (para testes)

---

## 📁 Estrutura do Projeto

```
src/main/java/br/com/dio/catalogoprodutos
├── controller
├── dto
├── exception
├── mapper
├── model
├── repository
├── service
└── CatalogoProdutosApplication.java
```

---

## 🛠️ Como Executar o Projeto

### ✅ Pré-requisitos

- Java 17+
- Maven 3.8+
- Git

### 📥 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/catalogo-produtos.git
cd catalogo-produtos
```

### ▶️ 2. Rodar o projeto

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn clean install
java -jar target/catalogo-produtos-0.0.1-SNAPSHOT.jar
```

A API ficará disponível em:

```
http://localhost:8700
```

---

## 🔐 Autenticação

Todas as requisições devem incluir o seguinte header:

| Header         | Valor            |
|----------------|------------------|
| Authorization  | Bearer 123456    |

---

## 🧪 Testes com Postman

### 🔹 1. Cadastrar um produto

**POST** `http://localhost:8700/produtos`

**Headers:**

- `Authorization: Bearer 123456`
- `Content-Type: application/json`

**Body (raw / JSON):**

```json
{
  "nome": "Mouse Gamer",
  "descricao": "Mouse com DPI ajustável",
  "preco": 99.90
}
```

---

### 🔹 2. Listar produtos

**GET** `http://localhost:8700/produtos`

**Headers:**

- `Authorization: Bearer 123456`

---

### 🔹 3. Buscar produto por ID

**GET** `http://localhost:8700/produtos/1`

**Headers:**

- `Authorization: Bearer 123456`

---

### 🔹 4. Atualizar produto

**PUT** `http://localhost:8700/produtos/1`

**Headers:**

- `Authorization: Bearer 123456`
- `Content-Type: application/json`

**Body:**

```json
{
  "nome": "Mouse Gamer RGB",
  "descricao": "Mouse com iluminação RGB",
  "preco": 129.90
}
```

---

### 🔹 5. Deletar produto

**DELETE** `http://localhost:8700/produtos/1`

**Headers:**

- `Authorization: Bearer 123456`

---

### 🔹 6. Simular um pedido

**POST** `http://localhost:8700/pedidos/simular`

**Headers:**

- `Authorization: Bearer 123456`
- `Content-Type: application/json`

**Body:**

```json
{
  "itens": [
    { "idProduto": 1, "quantidade": 2 },
    { "idProduto": 2, "quantidade": 1 }
  ],
  "observacao": "Entrega urgente"
}
```

---

## 💾 Console do banco H2

Acesse:  
`http://localhost:8700/h2-console`

Use os dados:

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(em branco)*

---

## 👩‍💻 Autor(a)

Projeto desenvolvido por Angela Luiz  
💼 LinkedIn: [linkedin.com/in/angela-luiz](https://linkedin.com/in/angela-luiz)

---
