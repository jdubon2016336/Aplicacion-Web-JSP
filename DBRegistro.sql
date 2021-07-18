drop database if exists DBRegistro;

create database	DBRegistro;
use DBRegistro;

create table Persona(
	codigoPersona int not null auto_increment,
    DPI varchar(15) not null,
    nombrePersona varchar(200) not null,
    primary key PK_codigoPersona(codigoPersona));

insert into Persona(DPI, nombrePersona) values( '18768756718', 'Javier Dubón'); 
insert into Persona(DPI, nombrePersona) values( '14445366454', 'Cristian Dubón');   
insert into Persona(DPI, nombrePersona) values( '31450653458', 'Amanda Flores'); 
insert into Persona(DPI, nombrePersona) values( '40453687345', 'Monserrat Vasquez');   
insert into Persona(DPI, nombrePersona) values( '15345314364', 'Alberto Jimenez'); 
insert into Persona(DPI, nombrePersona) values( '20154450684', 'Esperanza Veliz'); 
insert into Persona(DPI, nombrePersona) values( '10341554636', 'Fernando Lopez'); 
insert into Persona(DPI, nombrePersona) values( '25645603535', 'Juan Carlos España');   
insert into Persona(DPI, nombrePersona) values( '15345314364', 'Anastacia Steele'); 
insert into Persona(DPI, nombrePersona) values( '20154450684', 'Christopher Anderson'); 
    
create table Rol(
	idRol int not null,
    descripcion varchar(100),
    primary key PK_idRol(idRol));

insert into Rol(idRol, descripcion) values(1, 'Administrador');
insert into Rol(idRol, descripcion) values(2, 'Usuario');
    
create table Usuario(
    nombreUsuario varchar(100),
    contraseña varchar(150) not null,
    idRol int not null,
    primary key PK_nombreUsuario(nombreUsuario),
    constraint FK_Rol foreign key (idRol) references Rol(idRol));

insert into Usuario(nombreUsuario, contraseña, idRol) values('jdubon','2016336',1);
insert into Usuario(nombreUsuario, contraseña, idRol) values('amorales','osito2020',1);
insert into Usuario(nombreUsuario, contraseña, idRol) values('dubedo','fresa1984',2);
insert into Usuario(nombreUsuario, contraseña, idRol) values('aflores','esperansito18',2);
insert into Usuario(nombreUsuario, contraseña, idRol) values('canderson','123456',1);
    
#select * from Usuario where nombreUsuario like'jdubon';

