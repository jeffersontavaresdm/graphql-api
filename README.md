# GraphQL API
Esta é uma aplicação Spring Boot que implementa uma API GraphQL para gerenciar autores e livros.

### Pré-requisitos
Certifique-se de ter o seguinte software instalado em seu ambiente de desenvolvimento:
- Java Development Kit (JDK) 8 ou superior
- Maven

### Executando a aplicação:
1. Faça o clone deste repositório para o seu ambiente local.
2. Abra o projeto em sua IDE favorita.
3. Compile e execute a aplicação a partir da classe GraphqlApiApplication.java.
A aplicação será iniciada e estará disponível em http://localhost:8080/api.

### Endpoints GraphQL
A API GraphQL permite a execução de consultas e mutações para interagir com os dados. Os seguintes endpoints estão disponíveis:

**Consulta para obter todos os autores:**
```
query {
    authors {
        id
        name
        books {
            id
            title
            publisher
        }
    }
}
```
**Consulta para obter um autor específico pelo ID:**
```
query {
    authorById(id: <authorId>) {
        id
        name
        books {
            id
            title
            publisher
        }
    }
}
```
**Mutação para adicionar um novo livro:**
```
mutation {
    addBook(bookInput: {
        title: "<bookTitle>"
        publisher: "<publisher>"
        authorId: <authorId>
    }) {
        id
        title
        publisher
    }
}
```
**Mutação para atualizar um autor existente:**
```
mutation {
    updateAuthor(id: <authorId>, authorInput: {
        name: "<newAuthorName>"
    }) {
        id
        name
    }
}
```
**Mutação para excluir um autor:**
```
mutation {
    deleteAuthor(id: <authorId>)
}
```
Certifique-se de substituir *\<authorId>* pelo ID do autor desejado e *\<bookTitle>* e *\<publisher>* com as informações relevantes do livro.

### Documentação do Schema
O schema da API GraphQL (*schema.graphql*) define os tipos de dados disponíveis e as operações que podem ser executadas. Aqui está uma visão geral dos tipos e operações definidas neste projeto:

```
type Query {
    authors: [Author]
    authorById(id: ID!): Author
}

type Mutation {
    addBook(bookInput: BookInput): Book
    updateAuthor(id: ID!, authorInput: AuthorInput): Author
    deleteAuthor(id: ID!): Boolean
}

type Author {
    id: ID!
    name: String!
    books: [Book]
}

input AuthorInput {
    name: String
}

type Book {
    id: ID!
    title: String!
    publisher: String
}

input BookInput {
    title: String!
    publisher: String
    authorId: ID!
}
```
Consulte a documentação do GraphQL para obter mais informações sobre como utilizar a API e as possíveis consultas e mutações que podem ser realizadas.

Contribuição
Fique à vontade para contribuir com este projeto enviando pull requests com melhorias, correções de bugs ou novos recursos.