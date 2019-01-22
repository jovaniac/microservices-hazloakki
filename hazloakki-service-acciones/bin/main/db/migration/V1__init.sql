CREATE TABLE cat_acciones (
 id_accion VARCHAR(255) PRIMARY KEY,
 nombre varchar(255) DEFAULT NULL,
 descripcion varchar(255) DEFAULT NULL,
 estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(1,'Comer','Encuentra cualquier tipo de lugar para comer',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(2,'Beber','Todos los lugares donde podras encontrar una buena cerveza o vino',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(3,'Bailar','Diviertete y quitate el estres, los mejores lugares para bailar',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(4,'Cantar','Te gusta el Karaoke o simplemente quieres escuchar musica',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(5,'Descanzar','Encuentra los mejores hoteles de la ciudad',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(6,'Viajar','Vacaciones?, busca las mejores agencias',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(7,'Leer','Encontraras todos los titulos que busques, y claro en oferta',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(8,'Nadar','Práctica, aprende o busca clases efectivas',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(9,'Divertirme','Deja la rutina un poco y encuentra los mejores lugares',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(10,'Comprar','Buscamos apoyar los negocios pequeños, aqui encuentras todo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(11,'Dormir','Encuentra hoteles, moteles y más',true);
