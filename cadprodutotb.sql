create database cadprodutodb;
use cadprodutodb;

create table tbcadastrar(
id int auto_increment primary key,
nome varchar (50) not null,
descricaoPr text not null,
fabricantePr varchar (30) not null,
quantidade int not null default 1,
preco decimal (10,2) not null
);

insert into tbcadastrar (nome, descricaoPr, fabricantePr, quantidade, preco)
values ('Matheus', 'qualquer', 'cia', 5, 1500.00),
('Gabriel', 'qualquer', 'cia', 5, 200.00),
('Matheus', 'qualquer', 'cia', 5, 1500.00),
('Gabriel', 'qualquer', 'cia', 5, 200.00);

select * from tbcadastrar;