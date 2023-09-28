API - Sistema de Gestão de Funcionários

Objetivo: disponibilizar API que efetue a inserção de novo cadastro, busca por id (com detalhamento de dados correspondentes), atualização e exclusão de funcionário.

Tecnologias Utilizadas:

- Java;
- Spring Boot;
- Spring Data JPA;
- Spring Validation;
- Spring H2;
- Docker;
- PostgreSQL;
- Postman;
- IntelliJ;

Como utilizar:

1 - Baixe o repositório:
```
git clone https://github.com/lucianonevesln/java-sistema-de-gestao-de-funcionarios.git
```

2 - Se estiver com o Docker instalado, execute, via terminal, o comando abaixo para construção de container do banco de dados, no diretório onde encontra-se o arquivo "docker-compose.yml":
```
docker-compose up --build
```

3 - Altere a linha do arquivo "spring.profiles.active=test" para:
```
spring.profiles.active=dev
```

4 - Abra o IntelliJ e execute a aplicação.

5 - Agora, abra o Postman (ou aplicação semelhante), e insira o JSON abaixo no corpo da aplicação:
```
{
    "nome": "Luciano Teste 1",
    "designacao": "Programador 1",
    "salario": "10000",
    "telefone": "11999999999",
    "endereco": "Praça da Sé, 100, Centro, CEP 00001-000, São Paulo-SP"
}
```

6 - Insira o link abaixo, selecione a opção de "POST" e pressione "Send":
```
http://localhost:8080/servico-gestao-funcionarios
```

7 - Ainda utilizando o Postman (ou aplicação semelhante), utilize o link abaixo para elencar os dados do funcionário, através de seu "id" e selecionando a opção "GET":
```
http://localhost:8080/servico-gestao-funcionarios/{id}
```

8 - Ainda utilizando o Postman (ou aplicação semelhante), utilize o link abaixo para elencar todos os funcionários, selecionando a opção "GET":
```
http://localhost:8080/servico-gestao-funcionarios
```

9 - Ainda utilizando o Postman (ou aplicação semelhante), utilize o link abaixo (e o JSON a seguir), para atualizar um funcionário através de seu "id", selecionando a opção "PUT":
```
http://localhost:8080/servico-gestao-funcionarios/{id}
```
```
{
    "nome": "Update",
    "designacao": "Update",
    "salario": "20000",
    "telefone": "22888888888",
    "endereco": "Outro Endereço"
}
```

10 - Ainda utilizando o Postman (ou aplicação semelhante), utilize o link abaixo para excluir um funcionário através de seu "id", selecionando a opção "DELETE":
```
http://localhost:8080/servico-gestao-funcionarios/{id}
```

11 - Para encerrar o funcionarmento do Docker, basta digitar o "Ctrl + C", via terminal, no diretório onde encontra-se o arquivo "docker-compose.yml".

OBS: caso não possua o Docker instalado, basta não alterar o arquivo "spring.profiles.active=test" e seguir os passos a partir do item 4 que a aplicação deve funcionar corretamente, através de banco de dados em memória (H2).
