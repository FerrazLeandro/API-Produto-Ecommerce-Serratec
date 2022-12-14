CREATE TABLE categoria (
id_categoria serial primary key,
nome varchar(30) NOT NULL unique,
descricao varchar(200)
);

CREATE TABLE produto (
id_produto serial primary key,
nome varchar(50) NOT NULL unique,
descricao varchar(200),
qtd_estoque int,
data_cadastro date,
valor_unitario REAL not null,
id_categoria int NOT NULL REFERENCES categoria(id_categoria)
);

create table imagem (
id_foto serial primary key,
dados bytea,
tipo varchar(100),
nome varchar(100),
id_produto int NOT NULL REFERENCES produto(id_produto)
);

CREATE TABLE endereco (
id_endereco serial primary key,
cep varchar(8) NOT NULL, 
logradouro varchar(80) NOT NULL,
bairro varchar(50) NOT NULL, 
localidade varchar(80) NOT NULL, 
numero varchar(20) NOT NULL,
complemento varchar(80),
uf varchar(2) NOT null
);

CREATE TABLE cliente (
id_cliente serial primary key,
nome_completo varchar(50) NOT NULL,
email varchar(80) NOT NULL UNIQUE,
cpf varchar(11) NOT NULL UNIQUE, 
telefone varchar(40) NOT NULL,
data_nascimento date,
id_endereco int NOT NULL REFERENCES endereco(id_endereco)
);


CREATE TABLE pedido (
id_pedido serial primary key,
data_pedido date NOT NULL,
data_entrega date,
data_envio date,
status varchar(1) NOT NULL,
valor_total REAL NOT NULL,
id_cliente int NOT null REFERENCES cliente(id_cliente)
);


CREATE TABLE item_pedido (
id_item_pedido serial primary key,
quantidade int NOT null,
preco_venda REAL NOT null,
percentual_desconto REAL NOT null,
valor_bruto REAL NOT null,
valor_liquido REAL NOT NULL, 
id_produto int NOT null REFERENCES produto(id_produto),
id_pedido int NOT NULL REFERENCES pedido(id_pedido)
);

CREATE TABLE usuario (
   id serial PRIMARY key,
   nome varchar(60),
   email varchar(60),
   senha varchar(255)
);

CREATE TABLE perfil (
   id_perfil serial PRIMARY KEY,
   nome varchar(40)
);

CREATE TABLE usuario_perfil (
    id_usuario int REFERENCES usuario(id),
    id_perfil int REFERENCES perfil(id_perfil),
    data_criacao date,
    CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil)
);

INSERT INTO perfil (nome) VALUES 
 ('ROLE_ADMIN'),
 ('ROLE_USER');





