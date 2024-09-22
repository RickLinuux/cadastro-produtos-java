
# Projeto de Gerenciamento de Produtos

Este projeto é uma aplicação web em **Java** com **Spring Boot** que realiza operações **CRUD** (Create, Read, Update, Delete) para gerenciar produtos. O sistema permite cadastrar produtos com imagem, listar, editar e excluir produtos, além de exibir detalhes individuais.

## Índice
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura de Diretórios](#estrutura-de-diretórios)
- [Rotas da Aplicação](#rotas-da-aplicação)
- [Configuração](#configuração)
  - [Pré-requisitos](#pré-requisitos)
  - [Executando o Projeto](#executando-o-projeto)
  - [Exemplos na Prática](#exemplos-na-prática).

## Funcionalidades
- **Cadastro de Produtos**: Cadastro de produtos com nome, descrição, valor e imagem.
- **Listagem de Produtos**: Exibição de todos os produtos cadastrados em uma tabela.
- **Edição de Produtos**: Atualização de informações dos produtos, incluindo a possibilidade de alteração da imagem.
- **Exclusão de Produtos**: Remoção de produtos do sistema.
- **Exibição de Detalhes do Produto**: Exibição de informações detalhadas de um produto, incluindo a imagem.

## Tecnologias Utilizadas
- **Java 23**: Linguagem principal do projeto.
- **Spring Boot**: Framework para facilitar a criação de aplicações web.
- **Thymeleaf**: Motor de templates para renderização de páginas HTML.
- **MySQL**: Banco de dados utilizado para armazenar os produtos.
- **Gradle**: Sistema de build e gerenciamento de dependências.

## Estrutura de Diretórios

```bash
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── br
│   │   │           └── shakalinux
│   │   │               ├── produtos
│   │   │               │   ├── controller     # Controladores responsáveis pelas rotas e lógica
│   │   │               │   ├── model          # Modelos de dados (ProdutoModel)
│   │   │               │   └── repository     # Interfaces de repositório (ProdutoRepository)
│   │   ├── resources
│   │   │   ├── static                         # Arquivos estáticos (CSS, JS)
│   │   │   └── templates                      # Páginas Thymeleaf (HTML)
│   └── test                                   # Testes da aplicação
```

## Rotas da Aplicação

| Método HTTP | Rota                     | Descrição                                               |
|-------------|--------------------------|---------------------------------------------------------|
| GET         | `/cadastrar`              | Exibe o formulário de cadastro de um novo produto.       |
| POST        | `/cadastrar`              | Submete o formulário de cadastro de produto.            |
| GET         | `/listarProdutos`         | Lista todos os produtos cadastrados.                    |
| GET         | `/editarProduto/{id}`     | Exibe o formulário de edição de um produto específico.  |
| POST        | `/editarProduto/{id}`     | Atualiza os dados de um produto específico.             |
| GET         | `/excluirProduto/{id}`    | Exclui um produto pelo ID.                              |
| GET         | `/produto/{id}`           | Exibe os detalhes de um produto específico.             |

## Configuração

### Pré-requisitos

- **JDK 23**: Certifique-se de ter a versão correta do Java instalada.
- **MySQL**: Banco de dados para armazenar os produtos.
- **Gradle**: Ferramenta de build usada no projeto.

### Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/RickLinuux/cadastro-produtos-java.git
   ```
2. Configure o banco de dados no arquivo \`application.properties\`.
3. Execute o projeto:
   ```bash
   ./gradlew bootRun
   ```

4. Acesse no navegador:
   ```
   http://localhost:8080/listarProdutos
   ```

### Exemplos na prática 
#### Página de cadastro
![cadastrar](https://github.com/user-attachments/assets/43fdd52c-48e9-415c-9f72-2939912b406e)

#### Página de listagem
![tela](https://github.com/user-attachments/assets/4f825a2c-0687-4eea-865b-b550738e4e7b)

#### Página de edição
![editar](https://github.com/user-attachments/assets/f4783407-22d4-4dc9-8ebe-16ddc2fb8546)


#### Página de visualização única do produto
![produto](https://github.com/user-attachments/assets/16bf761c-6db7-4e53-9ef7-1d75a303630d)


