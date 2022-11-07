create database bancoApiII;
drop database bancoapiii;
use bancoApiII;

create table administrador(
id_adm int primary key auto_increment,
nome_adm varchar(40),
senha_adm varchar(30));

create table canais(
id_canais int primary key auto_increment,
nome_canal varchar(30),
tipo_canal varchar(30),
padrao_autenticacao varchar(30),
token varchar(30),
usuario_canal varchar(30),
senha_canal varchar(20));

create table usuario(
id_usuario int primary key auto_increment,
email_usuario varchar (50),
nome_usuario varchar (30),
senha_usuario varchar (20));

drop table usuario;
select * from usuario;
SELECT count(*) FROM canais;
SELECT * FROM canais LIMIT 20,10;

