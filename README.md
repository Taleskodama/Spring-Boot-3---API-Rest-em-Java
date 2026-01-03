# 🏥 API Vol.med - Gestão Clínica

Projeto de uma API REST para gerenciamento de uma clínica médica. A aplicação foca em boas práticas de desenvolvimento, segurança robusta com JWT e organização seguindo princípios SOLID.

## 📋 Descrição do Projeto

Esta API permite o controle total de uma clínica, desde o cadastro de médicos e pacientes até o agendamento e cancelamento de consultas. O sistema foi construído para ser escalável e seguro, utilizando DTOs para tráfego de dados e isolando regras de negócio complexas em serviços especializados (Service Layer).

## 🎯 Objetivos

- Implementar um CRUD completo (médicos e pacientes) com paginação e ordenação.
- Garantir a segurança da API via **Spring Security** e **JSON Web Token (JWT)**.
- Aplicar princípios **SOLID** para organizar as regras de agendamento de consultas.
- Realizar a validação de dados com **Bean Validation**.
- Documentar todos os endpoints seguindo o padrão **OpenAPI (Swagger)**.
- Garantir a qualidade do código com **Testes Automatizados** (Unitários e de Integração).

## 📁 Estrutura do Projeto



```text
MED.VOL-API
├── src/main/java/med/voll/api
│   ├── controller/         # Endpoints da API (REST)
│   ├── domain/             # Entidades JPA e Regras de Negócio
│   │   ├── consulta/       # Lógica de agendamentos e validações
│   │   ├── medico/         # Gestão de médicos
│   │   ├── paciente/       # Gestão de pacientes
│   │   └── usuario/        # Autenticação e Perfis
│   ├── infra/              # Configurações (Security, Exception Handler, Doc)
│   └── ApiApplication.java # Classe Principal
├── src/main/resources
│   ├── db/migration/       # Migrations do banco de dados (Flyway)
│   ├── application-prod.properties # Para produção
│   ├── application-test.properties # Para testes
│   └── application.properties
├── src/test/java           # Testes automatizados (JUnit/Mockito)
├── pom.xml                 # Gerenciador de dependências Maven
└── .gitignore
```
## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** - Persistência de dados
* **Spring Security** - Autenticação e autorização
* **Auth0 JWT** - Geração e validação de tokens
* **Flyway** - Controle de versão do banco de dados
* **MySQL** - Banco de dados relacional
* **Lombok** - Redução de código boilerplate
* **Bean Validation** - Validações de entrada
* **SpringDoc OpenAPI (Swagger)** - Documentação da API
* **JUnit 5 & Mockito** - Testes unitários e de integração

---

## 🛡️ Funcionalidades e Boas Práticas

### 1. Autenticação e Segurança
A API utiliza autenticação **Stateless**. O usuário realiza o login e recebe um token JWT, que deve ser enviado no cabeçalho `Authorization: Bearer <token>` de todas as requisições subsequentes. As senhas são criptografadas com **BCrypt**.

### 2. Regras de Negócio (SOLID)
O agendamento de consultas utiliza o padrão **Strategy** para validações. Criamos uma classe `AgendaDeConsultas` que recebe uma lista de validadores, permitindo adicionar novas regras sem alterar o código existente (**Open/Closed Principle**).

### 3. Documentação Interativa
Com a integração do Swagger, basta acessar o endpoint `/swagger-ui.html` para visualizar e testar todos os métodos disponíveis na API de forma documentada.

### 4. Tratamento de Erros
Implementação de um `GlobalExceptionHandler` (usando `@RestControllerAdvice`) para capturar exceções e retornar os status HTTP corretos (404, 400, etc.) com mensagens JSON padronizadas.

---

## 🚀 Como Executar

### Pré-requisitos
* **JDK 17**
* **Maven 3.x**
* **MySQL Server**

### Passo a Passo

1. **Configurar o Banco de Dados**
Crie um schema no MySQL chamado `vollmed_api`. No arquivo `src/main/resources/application.properties`, ajuste as credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vollmed_api
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

```

2.  **Executar a Aplicação**
```properties
mvn spring-boot:run
```

3. **Rodar os Testes**
```properties
mvn test
```
## 👨‍💻 Autor

- Tales Araujo Kodama
- Estudante de Engenharia de Computação - UNIFEI
- Estudo Pessoal
- Data: Janeiro 2026
