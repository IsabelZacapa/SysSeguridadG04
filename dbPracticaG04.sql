CREATE DATABASE dbPracticaG04
GO

USE dbPracticaG04
GO

CREATE TABLE Rol
(
[Id] int not null primary key identity(1,1),
[Nombre] varchar(100) not null
)
GO

CREATE TABLE Usuario
(
[Id] int not null primary key identity(1,1),
[IdRol] int not null,
[Nombre] varchar(100) not null,
[Apellido] varchar(100) not null,
[Login] varchar(100) not null,
[Password] varchar(37) not null,
[Estatus] tinyint not null,
[FechaRegistro] datetime not null,
foreign key (IdRol) references Rol(Id)
)