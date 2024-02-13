# Sistema de cadastro de beneficiários

Projeto de avaliação que consiste em uma aplicação simples utilizando Java e Spring Boot, no qual fornece uma API REST para manter o cadastro de beneficiários de um plano de saúde, documentado com o Swagger.
Arquitetura composta por Service, Repository, Model e Controller.

## Criação do projeto

1. Foi utilizado o Spring Initializr para criação do projeto Maven.
2. Criei o pacote "model" para as entidades, com as classes "Beneficiario" e "Documento", contendo todos seus devidos atributos.
3. Em seguida criei o pacote "repository", com duas interfaces "BeneficiarioRepository" e "DocumentoRepository"
4. Criei o pacote "service" com suas devidas classes para fornecer serviços para a "controller"
5. Criei o pacote "controller" com suas respectivas classes, onde todas as requisições são recebidas e tratadas para atender o usuário conforme seus pedidos.
6. Na classe de aplicação, criei exemplos para testes da API.
7. Realizei testes com o Postman.
8. Por último, a documentação projeto com o Swagger, utilizando a dependência "SpringDoc 2.3.0"

## Subindo o projeto

Antes de tudo, garanta que a porta 8080 da sua rede local esteja livre.

1) Utilizando uma IDE, abra o projeto "cadastro-beneficiarios" e aguarde a instalação de todas as dependências.
2) Após ter baixado todas as dependências, acesse a classe da aplicação (CadastroBeneficiariosApplication) e execute a aplicação.
3) Acesse em seu navegador o link http://localhost:8080/swagger-ui/index.html para consultar a documentação da API.
4) Use uma API Client (ex. Postman) para realizar busca, cadastro, alteração e exclusão dos dados.

Linguagens e ferramentas utilizadas no projeto:
* Java versão 17
* Spring Boot 3.2.2
* Postman v10.23.0
 
IDE: 
* IntelliJ IDEA 2023.3.3

Dependencias do Maven:
* Spring Web
* Lombok
* H2 Database
* Spring Data JPA
* SpringDoc 2.3.0
