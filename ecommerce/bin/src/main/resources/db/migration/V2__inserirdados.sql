INSERT INTO public.categoria (nome,descricao) VALUES
	 ('Alimentos','Comidas e bebidas'),
	 ('Limpeza','Produtos de limpeza em geral'),
	 ('Higiene', 'Higiene pessoal'),
	 ('Livros','Livros para todos os gostos'),
	 ('Jogos', 'Jogos eletrônicos'),
	 ('Fantasias', 'Fantasias para arrasar no Halloween'),
	 ('Decoração', 'Quadros, figures e etc');

INSERT INTO public.produto (nome,descricao,qtd_estoque,data_cadastro,valor_unitario,id_categoria) VALUES
	 ('Arroz','Arroz Integral 5kg',100,'2022-10-20',20.99,1),
	 ('Detergente','Detergente Ypê',25,'2022-01-01',5.4,2),
	 ('Feijão','Feijão preto 1kg',22,'2022-10-25',6.99,1),
	 ('Coca-cola','Coca-cola 2L',16,'2022-10-25',9.99,1),
	 ('Fanta uva','Fanta uva 2L',12,'2022-10-25',8.59,1),
	 ('Kinder ovo','Kinder ovo padrão',9,'2022-10-25',259.99,1),
	 ('Sabão em pó','Sabão em pó OMO 1.6kg',11,'2022-10-25',23.99,2),
	 ('Limpador','Limpador Veja 1L',8,'2022-10-25',12.29,2),
	 ('Como lidar com um babaca VOL7','Para as pessoas que lidam com um babaca diariamente',5,'2022-10-25',20.99,4),
	 ('Bulinha em: A embarcação infinita','Lenda sobre a embarcação que nunca chega',7,'2022-10-25',35.99,4),
	 ('Bootstrap By Claiver','Claiver descreve como o bootstrap mudou sua vida',20,'2022-10-25',25.50,4),
	 ('Furry Slayer','Conto sobre um herói lendário',19,'2022-10-25',40.00,4),
	 ('Manual ApiREST In Peace','Como encomendar seu caixão',7,'2022-10-25',77.00,4),
	 ('Lá e de volta outra vez','A difícil jornada até o entendimento do Github',1,'2022-10-25',130.00,4),
	 ('A saga de José','O cara que só faz perguntas depois de 8 horas da noite',8,'2022-10-25',19.99,4),
	 ('Desodorante','Desodorante Rexona',14,'2022-10-25',23.50,3),
	 ('Shampoo','Shampoo Clear Men',22,'2022-10-25',21.99,3),
	 ('Papel higiênico','Para limpar a cagada que você fez dando DELETE no banco',8,'2022-10-25',33.00,3),
	 ('Battlefield 2042','Gráficos de PS1 no PS4',15,'2022-10-25',100.00,5),
	 ('Cyberbug 2077','A história começa quando Johnny Silverhand é transformado em um commit...',77,'2022-10-25',170.00,5),
	 ('Starwars 1313','O game do Boba Fett que nunca aconteceu',0,'2022-10-25',999.99,5),
	 ('Fantasia de palhaço assassino','Fantasia de halloween para quem é mão de vaca',19,'2022-10-25',60.00,6),
	 ('Fantasia do Json','O terror das APIs',13,'2022-10-25',400.13,6),
	 ('Fantasia do Fofão','A mais assustadora de todas',1,'2022-10-25',700.00,6),
	 ('Figure do Goku','Mini Goku com cabelo removível',8,'2022-10-25',250.00,7),
	 ('Miniatura Knight Rider','Pontiac Firebird Trans Am Black - (1982) C/ Luz',5,'2022-10-25',299.99,7),
	 ('Figure Gandalf','You shall not pass',3,'2022-10-25',4500.00,7);
	 
INSERT INTO public.endereco (cep,logradouro,bairro,localidade,numero,complemento,uf) VALUES
	 ('11111111','Rua A','Bairro B','Cidade C','1',NULL,'RJ'),
	 ('22222222','Rua B','Bairro C','Cidade D','2',NULL,'SP'),
	 ('33333333','Rua C','Bairro D','Cidade E','3',NULL,'BH'),
	 ('44444444','Rua D','Bairro E','Cidade F','4',NULL,'ES'),
	 ('55555555','Rua E','Bairro F','Cidade G','5',NULL,'RS');
	 

	
INSERT INTO public.cliente (nome_completo,email,cpf,telefone,data_nascimento,id_endereco) VALUES
	 ('João Silva','joao@test.com','11111111111','21999999999','2000-01-01',1),
	 ('Bulinha','bula@test.com','33333333333','21935618293','1910-03-08',3),
	 ('Roni','roni@test.com','44444444444','21983617234','2001-09-12',4),
	 ('Deby','deby@test.com','55555555555','21999812378','1999-11-11',5),
	 ('Maria Silva','maria@test.com','22222222222','21000000000','1900-01-01',2);

INSERT INTO public.pedido (data_pedido,data_entrega,data_envio,status,valor_total,id_cliente) VALUES
	 ('2022-10-20','2022-10-20','2022-10-20','0',150.0,1),
	 ('2022-10-01','2022-10-05','2022-10-05','1',50.99,2);

	
INSERT INTO public.item_pedido (quantidade,preco_venda,percentual_desconto,valor_bruto,valor_liquido,id_produto,id_pedido) VALUES
	 (2,20.99,0.0,42.2,42.0,1,1),
	 (1,5.4,10.0,5.1,5.0,2,2);
	

INSERT INTO usuario (nome, email, senha) VALUES
('Leandro', 'leandro@email.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'),
('Claiver', 'claiver@email.com', '$2a$12$G7ibc/sJRL0BWCpVCBcRxudHZ2aV8uHbMhHbu/Y6Zpz3Dw1X4.B2S');

INSERT INTO perfil (nome) VALUES
('ADMIN'),
('USER');

INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
( (SELECT id FROM usuario WHERE email='leandro@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='ADMIN') ),
( (SELECT id FROM usuario WHERE email='leandro@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') ),
( (SELECT id FROM usuario WHERE email='claiver@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') );

	