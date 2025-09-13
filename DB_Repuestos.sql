drop database if exists  DB_Repuestos;
create database DB_Repuestos;
use DB_Repuestos;

create table Categoria (
    id_Categoria int auto_increment,
    nombre varchar(100) not null,
    primary key PK_idCategoria (id_Categoria)
);

create table Repuesto (
    id_Repuesto int auto_increment,
    nombre varchar(150) not null,
    precio decimal(10,2) not null,
    id_Categoria INT,
    primary key PK_id_Repuesto (id_Repuesto),
    constraint FK_id_Categoria foreign key (id_Categoria) 
		references Categoria(id_Categoria) on delete cascade
);

create table Cliente (
    id_Cliente int auto_increment,
    nombre varchar(150) not null,
    telefono varchar(20),
    primary key PK_id_Cliente (id_Cliente)
);

create table Venta (
    id_Venta int auto_increment,
    fecha date not null,
    cantidad int not null,
    id_Cliente int,
    id_Repuesto int,
    primary key PK_id_Venta (id_Venta),
    constraint FK_id_Cliente foreign key (id_Cliente) 
		references Cliente(id_Cliente) on delete cascade,
	constraint FK_id_Repuesto foreign key (id_Repuesto)
		references Repuesto(id_Repuesto) on delete cascade
);

INSERT INTO Categoria (nombre) VALUES
('Filtros'),
('Baterías'),
('Aceites'),
('Frenos'),
('Suspensión'),
('Luces'),
('Transmisión'),
('Correas'),
('Escapes'),
('Accesorios');

INSERT INTO Repuesto (nombre, precio, id_Categoria) VALUES
('Filtro de aire', 15.50, 1),
('Filtro de aceite', 8.75, 1),
('Batería 12V 60Ah', 120.00, 2),
('Aceite 5W-30 4L', 35.00, 3),
('Aceite 20W-50 4L', 28.00, 3),
('Pastillas de freno delanteras', 45.00, 4),
('Amortiguador trasero', 70.00, 5),
('Faro delantero izquierdo', 95.00, 6),
('Kit de embrague', 250.00, 7),
('Correa de distribución', 60.00, 8);

INSERT INTO Cliente (nombre, telefono) VALUES
('Juan Pérez', '555-1234'),
('María López', '555-5678'),
('Carlos Gómez', '555-8765'),
('Ana Torres', '555-3344'),
('Luis Sánchez', '555-7788'),
('Pedro Herrera', '555-9988'),
('Carmen Díaz', '555-4422'),
('Jorge Morales', '555-8899'),
('Lucía Vega', '555-2233'),
('Ricardo Soto', '555-6677');

INSERT INTO Venta (fecha, cantidad, id_Cliente, id_Repuesto) VALUES
('2025-09-01', 2, 1, 1),
('2025-09-02', 1, 2, 3),
('2025-09-03', 4, 3, 2),
('2025-09-04', 1, 4, 6),
('2025-09-05', 1, 5, 8),
('2025-09-06', 1, 6, 9),
('2025-09-07', 2, 7, 4),
('2025-09-08', 3, 8, 5),
('2025-09-09', 1, 9, 10),
('2025-09-10', 2, 10, 7);
