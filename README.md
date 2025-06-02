# BACKEND2025.1
Projeto de BackEnd - Integrantes: Bruno Daniel de Andrade Pereira
# 🎬 IespFlix

**IespFlix** é um sistema backend desenvolvido com Java e Spring Boot que simula as principais funcionalidades de uma plataforma de streaming como a Netflix. Usuários podem cadastrar filmes, avaliar, favoritar e explorar o catálogo por gênero.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- H2 Database (banco em memória)
- Lombok
- Swagger UI (via SpringDoc)
- Maven

---

## 🧠 Estrutura do Projeto

### 📁 `model/` — Entidades principais

#### 🧍‍♂️ `Usuario`
Representa um usuário da plataforma.
- Campos: `id`, `nome`, `email`, `senha`, `perfil`
- Pode avaliar filmes e criar uma lista de favoritos.

#### 🎬 `Filme`
Representa um filme no catálogo.
- Campos: `id`, `titulo`, `genero`, `anoLancamento`

#### 🎭 `Ator`
Associa um ator a um filme.
- Campos: `id`, `nome`, `personagem`, `idade`

#### ⭐ `Avaliacao`
Avaliações feitas por usuários sobre filmes.
- Campos: `id`, `usuario`, `filme`, `nota`, `comentario`

#### ❤️ `ListaFavoritos`
Associa filmes à lista de favoritos de um usuário.
- Campos: `id`, `usuario`, `filme`

#### 🏷️ `Genero`
Classifica os filmes.
- Campos: `id`, `nome`

#### 📦 `EntidadeBase`
Classe abstrata reutilizada para herança, contendo campos comuns:
- Campos: `nome`, `ano`

---

### 📁 `controller/` — Camada REST

- `UsuarioController`: gerencia usuários.
- `FilmeController`: CRUD de filmes.
- `AtorController`: gerenciamento de atores.
- `GeneroController`: CRUD de gêneros.
- `AvaliacaoController`: cria e consulta avaliações.
- `ListaFavoritosController`: adiciona e remove favoritos.
- `ControllerBase`: controladores genéricos herdados por outros.

---

### 📁 `Client/OmdbClient.java`
Permite integração com a API do OMDB (Open Movie Database) para buscar informações de filmes.

---

## 🧪 Como testar os endpoints (Swagger)

1. Rode o projeto com:
http://localhost:9090/swagger-ui/index.html
