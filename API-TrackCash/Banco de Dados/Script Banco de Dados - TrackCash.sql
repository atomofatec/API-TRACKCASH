drop database if exists bancoapiii;
create database bancoApiII;
use bancoApiII;

create table canais(
id_canais int,
nome_canal varchar(30),
tipo_canal varchar(30),
padrao_autenticacao varchar(30));

create table usuario(
id_usuario int primary key auto_increment,
email_usuario varchar (50),
nome_usuario varchar (30),
senha_usuario varchar (20),
tipo_usuario varchar (30));

create table canal_usuario(
id_canal_usuario int primary key auto_increment,
id_usuario int,
nome_canal varchar(30),
token varchar(30),
usuario varchar(30),
senha varchar(30),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

create table secao(
id_user int,
nome_user varchar(30),
email_user varchar(30),
tipo_user varchar (30));


INSERT INTO bancoapiii.usuario (email_usuario, nome_usuario, senha_usuario, tipo_usuario) VALUES ('admin@hotmail.com', 'admin', 'admin', 'Admin');
