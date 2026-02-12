# Workshop MongoDB com Spring Boot

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.2-green)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-green)

Projeto desenvolvido durante o estudo de **Java** com **Spring Boot** e banco de dados **NoSQL (MongoDB)**.
O objetivo foi construir uma API RESTful completa, abordando conceitos fundamentais de modelagem de dados orientada a documentos, associações e consultas dinâmicas.

## 🚀 Tecnologias Utilizadas

- **Java 21**: Linguagem de programação.
- **Spring Boot 4.0.2**: Framework para criação da API.
- **Spring Data MongoDB**: Integração e persistência de dados.
- **Maven**: Gerenciamento de dependências.
- **MongoDB**: Banco de dados NoSQL.

## ⚙️ Funcionalidades e Arquitetura

O projeto segue o padrão de camadas (Resources, Services, Repositories) e implementa boas práticas de mercado:

- **CRUD Completo**: Criação, leitura, atualização e exclusão de usuários (`User`).
- **Padrão DTO**: Utilização de *Data Transfer Objects* (`UserDto`, `AuthorDTO`, `CommentDTO`) para trafegar dados de forma segura, evitando exposição de dados sensíveis e melhorando a performance.
- **Tratamento de Exceções**: Manipulador global (`ResourceExceptionHandler`) para capturar erros como `ObjectNotFoundException` e devolver respostas HTTP padronizadas (`StandardError`).
- **Consultas Personalizadas**:
  - Busca simples por texto no título (regex).
  - Busca avançada com múltiplos critérios (texto no título/corpo/comentários E intervalo de datas) utilizando `@Query` do MongoDB.
- **Relacionamentos NoSQL**:
  - **Referência**: O Usuário possui uma lista de referências para seus Posts (`@DBRef`).
  - **Aninhamento**: Os Posts contêm uma cópia resumida do Autor (`AuthorDTO`) e uma lista de Comentários (`CommentDTO`) embutidos, otimizando a leitura.

## 🔌 Endpoints da API

### Usuários (`/users`)

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca um usuário por ID |
| POST | `/users` | Cria um novo usuário |
| PUT | `/users/{id}` | Atualiza os dados de um usuário |
| DELETE | `/users/{id}` | Remove um usuário |
| GET | `/users/{id}/posts` | Retorna a lista de posts de um usuário específico |

### Posts (`/posts`)

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/posts/{id}` | Busca um post por ID |
| GET | `/posts/titlesearch?text=...` | Busca posts que contenham o texto fornecido no título |
| GET | `/posts/fullsearch` | Busca avançada por texto e intervalo de datas (veja parâmetros abaixo) |

**Parâmetros para Full Search:**

- `text`: Texto a ser pesquisado (título, corpo ou comentários).
- `minDate`: Data mínima (formato `yyyy-MM-dd`, ex: 2018-01-01).
- `maxDate`: Data máxima (formato `yyyy-MM-dd`, ex: 2018-03-25).

## ▶️ Como Executar

1. **Pré-requisitos**: Certifique-se de ter o Java 21 e o MongoDB instalados (ou rodando via Docker).

2. Clone o repositório:
```bash
   git clone https://github.com/pedroccarv/workshopmongo.git
```

3. Navegue até a pasta do projeto e execute:
```bash
   ./mvnw spring-boot:run
```

4. A API estará disponível em `http://localhost:8080`.

**Nota**: O projeto possui uma classe de configuração (`Instantiation`) que popula o banco de dados automaticamente com dados de teste (Usuários: Pedro, Kaio, Matheus; Posts e Comentários) ao iniciar a aplicação.
