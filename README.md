# Travel Agency API 🌍

Esta é uma API RESTful desenvolvida em **Java** com **Spring Boot** para gerenciar os destinos de viagem de uma agência. A API permite o cadastro, consulta, avaliação e exclusão de destinos de forma simples e eficiente.
---
## 🛠️ Funcionalidades

### **Destinos**
- **Cadastro de destinos de viagem**
- **Listagem de todos os destinos**
- **Busca de destinos por nome ou localização**
- **Visualização detalhada de um destino**
- **Avaliação de destinos (1 a 10, com cálculo de média)**
- **Exclusão de destinos de viagem**

### **Usuários**
- **Cadastro de usuários**
- **Atualização de usuários**
- **Listagem de usuários**
- **Busca de usuários por ID**
- **Exclusão de usuários**

### **Controle de Acesso**
- **Acesso aos endpoints de destinos para usuários autenticados**
- **Endpoints administrativos acessíveis somente para administradores**
- **Sistema de autenticação com roles (usuário e administrador)**

---
## 📦 Endpoints Disponíveis

### 1. **Cadastrar Destino**
- **Método**: `POST`
- **URL**: `/destinations`
- **Corpo da Requisição**:
  ```json
  {
    "name": "Paris",
    "location": "France",
    "description": "The city of lights and romance."
  }
  ```
- **Resposta**:
  ```json
  {
    "id": 1,
    "name": "Paris",
    "location": "France",
    "description": "The city of lights and romance.",
    "averageRating": 0.0,
    "totalRatings": 0,
    "ratingSum": 0
  }
  ```

---

### 2. **Listar Todos os Destinos**
- **Método**: `GET`
- **URL**: `/destinations`
- **Resposta**:
  ```json
  [
    {
      "id": 1,
      "name": "Paris",
      "location": "France",
      "description": "The city of lights and romance.",
      "averageRating": 0.0,
      "totalRatings": 0,
      "ratingSum": 0
    }
  ]
  ```

---

### 3. **Pesquisar Destinos**
- **Método**: `GET`
- **URL**: `/destinations/search`
- **Parâmetros de Consulta**:
  - `name`: (Opcional) Nome do destino.
  - `location`: (Opcional) Localização do destino.
- **Exemplo**: `/destinations/search?name=Paris`
- **Resposta**:
  ```json
  [
    {
      "id": 1,
      "name": "Paris",
      "location": "France",
      "description": "The city of lights and romance.",
      "averageRating": 0.0,
      "totalRatings": 0,
      "ratingSum": 0
    }
  ]
  ```

---

### 4. **Visualizar Detalhes do Destino**
- **Método**: `GET`
- **URL**: `/destinations/{id}`
- **Exemplo**: `/destinations/1`
- **Resposta**:
  ```json
  {
    "id": 1,
    "name": "Paris",
    "location": "France",
    "description": "The city of lights and romance.",
    "averageRating": 0.0,
    "totalRatings": 0,
    "ratingSum": 0
  }
  ```

---

### 5. **Avaliar Destino**
- **Método**: `PATCH`
- **URL**: `/destinations/{id}/rate`
- **Parâmetros de Consulta**:
  - `rating`: Nota de 1 a 10.
- **Exemplo**: `/destinations/1/rate?rating=9`
- **Resposta**:
  ```json
  {
    "id": 1,
    "name": "Paris",
    "location": "France",
    "description": "The city of lights and romance.",
    "averageRating": 9.0,
    "totalRatings": 1,
    "ratingSum": 9
  }
  ```

---

### 6. **Excluir Destino**
- **Método**: `DELETE`
- **URL**: `/destinations/{id}`
- **Exemplo**: `/destinations/1`
- **Resposta**: `204 No Content`

---
### **2. CRUD de Usuários**

#### **1. Listar Todos os Usuários**
- **Método**: `GET`
- **URL**: `/admin/users`
- **Acesso**: Apenas administradores
- **Resposta**:
  ```json
  [
    {
      "id": 1,
      "username": "admin",
      "roles": [
        {
          "id": 1,
          "name": "ROLE_ADMIN"
        }
      ]
    }
  ]
  ```

#### **2. Obter Usuário por ID**
- **Método**: `GET`
- **URL**: `/admin/users/{id}`
- **Acesso**: Apenas administradores
- **Resposta**:
  ```json
  {
    "id": 1,
    "username": "admin",
    "roles": [
      {
        "id": 1,
        "name": "ROLE_ADMIN"
      }
    ]
  }
  ```

#### **3. Criar um Novo Usuário**
- **Método**: `POST`
- **URL**: `/admin/users`
- **Acesso**: Apenas administradores
- **Corpo da Requisição**:
  ```json
  {
    "username": "newuser",
    "password": "password123",
    "roles": [
      {
        "id": 2,
        "name": "ROLE_USER"
      }
    ]
  }
  ```
- **Resposta**:
  ```json
  {
    "id": 2,
    "username": "newuser",
    "roles": [
      {
        "id": 2,
        "name": "ROLE_USER"
      }
    ]
  }
  ```

#### **4. Atualizar Usuário**
- **Método**: `PUT`
- **URL**: `/admin/users/{id}`
- **Acesso**: Apenas administradores
- **Corpo da Requisição**:
  ```json
  {
    "username": "updateduser",
    "password": "newpassword123",
    "roles": [
      {
        "id": 1,
        "name": "ROLE_ADMIN"
      }
    ]
  }
  ```
- **Resposta**:
  ```json
  {
    "id": 1,
    "username": "updateduser",
    "roles": [
      {
        "id": 1,
        "name": "ROLE_ADMIN"
      }
    ]
  }
  ```

#### **5. Deletar Usuário**
- **Método**: `DELETE`
- **URL**: `/admin/users/{id}`
- **Acesso**: Apenas administradores
- **Resposta**: `204 No Content`

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/yuamignoni/agenciaviagem.git
   cd travel-agency-api
   ```
2. Suba o container PostgreSQL:
   ```bash
   docker-compose up -d
   ```
3. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a API em:  	
   `http://localhost:8080`

---
