create database bancoApiII;

use bancoApiII;

create table administrador(
cpf_adm int primary key,
nome_adm varchar(40),
senha_adm varchar(30));

create table canais(
id_canais int primary key auto_increment,
nome_canal varchar(30),
tipo_canal varchar(30),
padrao_autenticacao varchar(30),
token varchar(30),
senha_canal varchar(20));

create table usuario(
cpf_usuario int primary key,
nome_usuario varchar (30),
senha_usuario varchar (20));

select * from canais