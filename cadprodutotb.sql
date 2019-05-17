create database cadprodutodb;
use cadprodutodb;

create table tbcadastrar(
id int auto_increment primary key,
nome varchar (50) not null,
descricaoPr varchar (50),
fabricantePr varchar (30) not null,
quantidade int not null,
preco decimal (10,2) not null
);

insert into tbcadastrar (nome, descricaoPr, fabricantePr, quantidade, preco)
values ('Luiz', 'qualquer', 'tabajara', 2, 1000.00);

select * from tbcadastrar;