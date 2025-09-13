drop database if exists DBProyectoSprignBoot2025;
create database DBProyectoSprignBoot2025;
use DBProyectoSprignBoot2025;
create table users (
	id int auto_increment not null,
    first_name varchar(15) not null ,
    last_name varchar(200) not null ,
    email varchar(150) not null unique,
    primary key PK_id(id)
);
 
select * from users;