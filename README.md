# Bem vindo ao projeto Banco Nix!

O projeto foi feito em 2 etapas, o Frontend e o Backend.
Para executar o projeto:

Utilizar o banco de dados postgres, com a **porta: 5433**, **usuário: postgres** e **senha: postgres**.
Criar uma database com o nome nix.
Rodar o seguinte script que se encontra na raiz do projeto com o seguinte nome **nix.sql**.

Para rodar o Backend deve ser executado o arquivo **BancoNixApplication.java**.
Para rodar o Frontend acessar o pacote: FrontNix e executar o comando: **ng-serve**.

Para acessaro a aplicação: http://localhost:4200

# Tecnologias

**Backend**: 
	
 - Springboot e Rest API 
 - Java 8 
 - JPA 
 - Maven

**Frontend**:
	
 - Angular 4 
 - Bootstrap

## Considerações futuras

 - Realização de testes automatizados. 
 - Utilização do material design.
 - Implementação do swagger.
 - Criação de protótipos para mobile.
 - Implementação de segurança, exemplo: autenticação do usuário e criação do token de acesso.
 - Internacionalização.
 - Mensagens de alerta

## Observações

Devido ao fato de não haver autenticação no sistema, foi retirado o relacionamento com usuário.