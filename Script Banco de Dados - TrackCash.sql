create database bancoApiII;

use bancoApiII;

create table administrador(
cpf int primary key,
nome varchar(40),
senha varchar(30));

create table canais(
id_canais int primary key auto_increment,
nome_canal varchar(30),
padrao_autentificacao varchar(30),
token int,
senha_canal varchar(20));

create table uadministradorsuario(
cpf int primary key,
nome varchar (30),
senha varchar (20));

