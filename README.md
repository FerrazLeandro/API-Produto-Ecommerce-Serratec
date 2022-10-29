# API RESTful
### Trabalho final da matéria:
<img src="https://img.shields.io/badge/Versão-1.0.0-darkred"/> <img src="https://img.shields.io/badge/Data%20de%20lançamento:-25_de_Outubro-informational">
<img src="https://img.shields.io/badge/Última_Modificação:-25_de_Outubro-darkgreen"/>
<br><br>

<h4>API padrão REST para um E-commerce.</h4>

<p>Este é o projeto final da matéria, consiste em uma API que siga os padrões REST. Possuindo segurança do Spring + JWT, envio automático de emails, API externa de CEPs (Via CEP), entre outras exigências.</p>


##

`Requisitos:`

- O banco de dados e as tabelas deverão ser criados de acordo com o DER fornecido
abaixo, utilizando o flyway;

- Não será permitido alterar a estrutura/relacionamento entre as entidades constantes
no DER;

- Todos os endpoints disponibilizados pela API deverão estar funcionais e realizando
os processos para os quais foram desenvolvidos;

- Para todos os recursos da API deverão ser disponibilizados os métodos CRUD;

- Deverá ser criado um Relatório de Pedido, contendo: id do pedido, data do pedido,
valor total; Relação de itens do pedido: código e nome do produto, preço de venda,
quantidade, valor bruto, percentual de desconto e valor líquido. Tal relatório deverá
ser criado com a utilização de DTO;

- Para transição dos dados referentes aos métodos CRUD poderão ser utilizadas as
Entidades ou DTOs, à escolha dos Grupos;

- Poderão ser criados diferentes DTOs referentes a uma mesma Entidade, caso
necessário;

- Em todos os métodos CRUD deverão ser identificadas e tratadas as exceções de
item não encontrado, com a exibição de mensagem personalizada;

- As imagens dos Produtos deverão ser armazenadas no banco de dados (utilizar o
tipo de dados blob/bytea para tal);

- A cada novo pedido cadastrado deverá ser enviado um e-mail contendo o Relatório
de Pedido (descrito acima);

- Deverão ser implementados a autenticação e o controle de acesso à API (com o
módulo de segurança do Spring + JWT);

##

`Regras de Negócio:`

- No ato de cadastro de um novo pedido deverá ser calculado os valores bruto e
líquido dos produtos: valor bruto (preço venda * qtde) e valor líquido (valor bruto –
valor desconto; sendo esse último calculado através da aplicação do percentual de
desconto sobre o valor bruto);

- Ao final do cadastro de um novo pedido deverá ser calculado e armazenado o seu
valor total: soma dos valores líquidos dos itens do pedido;

- Os dados do endereço do Cliente deverão ser obtidos a partir de sua coleta numa
API externa de consulta de CEP;

##

`Regras de Negócio – Desejáveis/Opcionais:`

- Não deverá ser possível cadastrar um pedido com data retroativa à atual;

- Não deverá ser possível cadastrar um produto com descrição idêntica a uma já
existente;

- Não deverá ser possível cadastrar diferentes clientes com um mesmo número de
CPF;

- Não deverá ser possível cadastrar diferentes clientes com um mesmo endereço de
e-mail;

##

`Tecnologias utilizadas:`<br>
- Java
- SpringToolSuite4
- DBeaver
- Postresql

<br><br>

## Professor responsável:
| [<img src="https://avatars.githubusercontent.com/u/6456100?v=4" width=115><br><sub>Luis Henrique 'Bulinha'</sub>](https://github.com/bulinha) |
 | :---: |

 
<br>

## Equipe do trabalho:
### Grupo 5 | Turma 8 - Teresópolis

| [<img src="https://avatars.githubusercontent.com/u/85909017?v=4" width=115><br><sub>Leandro Ferraz</sub>](https://github.com/FerrazLeandro) |  [<img src="https://avatars.githubusercontent.com/u/102622495?v=4" width=115><br><sub>Erick Ramos</sub>](https://github.com/ErickNotFound) |  [<img src="https://avatars.githubusercontent.com/u/96076314?v=4" width=115><br><sub>Alessandra Pinheiro</sub>](https://github.com/Ale-ssandra) |  [<img src="https://avatars.githubusercontent.com/u/110869576?v=4" width=115><br><sub>Tiago Souza</sub>](https://github.com/TiagoSouzacf) |  [<img src="https://avatars.githubusercontent.com/u/110734237?v=4" width=115><br><sub>Fábio Gurgel</sub>](https://github.com/Fabio-Gurgel) | 
| :---: | :---: | :---: | :---: | :---: |
