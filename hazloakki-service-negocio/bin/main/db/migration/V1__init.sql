CREATE TABLE negocio (
  id_negocio VARCHAR(255) PRIMARY KEY,
  nombre varchar(45) DEFAULT NULL,
  id_categoria NUMERIC,
  email varchar(45) DEFAULT NULL,
  descripcion varchar(45) DEFAULT NULL,
  telefono varchar(45) DEFAULT NULL,
  domicilio varchar(45) DEFAULT NULL,
  latitud double precision DEFAULT NULL,
  longitud double precision DEFAULT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  codigo_postal varchar(45) DEFAULT NULL,
  delegacion varchar(45) DEFAULT NULL,
  colonia varchar(45) DEFAULT NULL,
  calle varchar(45) DEFAULT NULL,
  numero_exterior varchar(45) DEFAULT NULL,
  horario varchar(45) DEFAULT NULL,
  responsable varchar(45) DEFAULT NULL,
  id_cuenta varchar(255) DEFAULT NULL,
  id_accion NUMERIC,
  sitio_web varchar(255) DEFAULT NULL
);


CREATE TABLE cat_metodo_pago (
 id VARCHAR(255) PRIMARY KEY,
 nombre varchar(255) DEFAULT NULL,
 descripcion varchar(255) DEFAULT NULL,
 estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_metodo_pago(id, nombre, descripcion, estatus) VALUES(1,'pago efectivo','pagos realizados en efectivo',true);
insert into cat_metodo_pago(id, nombre, descripcion, estatus) VALUES(2,'monedero electronico','pagos realizados por modenero electronico',true);
insert into cat_metodo_pago(id, nombre, descripcion, estatus) VALUES(3,'metodo transferencia','pagos realizados por transferencia electronica',true);
insert into cat_metodo_pago(id, nombre, descripcion, estatus) VALUES(4,'tarjeta','pagos realizados por tarjeta de credito o debito',true);
insert into cat_metodo_pago(id, nombre, descripcion, estatus) VALUES(5,'cheque','pagos realizados con cheque bancario',true);

CREATE TABLE negocios_metodo_pago(
	 id_negocio VARCHAR(255),
	 id_pago VARCHAR(255),
	 PRIMARY KEY(id_negocio, id_pago),
	 FOREIGN KEY (id_negocio) REFERENCES negocio (id_negocio),
	  FOREIGN KEY (id_pago) REFERENCES cat_metodo_pago (id)
);



CREATE TABLE cat_servicios(
 	id VARCHAR(255) PRIMARY KEY,
	nombre varchar(255) DEFAULT NULL,
 	descripcion varchar(255) DEFAULT NULL,
 	estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_servicios(id, nombre, descripcion, estatus) VALUES(1,'servicio a domicilio','te llevan tus solicitudes a casa',true);
insert into cat_servicios(id, nombre, descripcion, estatus) VALUES(2,'estacionamiento','zona para estacionarse',true);
insert into cat_servicios(id, nombre, descripcion, estatus) VALUES(3,'internet','wifi gratis',true);
insert into cat_servicios(id, nombre, descripcion, estatus) VALUES(4,'reservaciones','admite reservaciones',true);
insert into cat_servicios(id, nombre, descripcion, estatus) VALUES(5,'para llevar','puede solicitar llevarse los productos',true);


CREATE TABLE negocios_servicios(
	 id_negocio VARCHAR(255) ,
	 id_servicio VARCHAR(255),
	 PRIMARY KEY(id_negocio, id_servicio),
	 FOREIGN KEY (id_negocio) REFERENCES negocio (id_negocio),
	 FOREIGN KEY (id_servicio) REFERENCES cat_servicios (id)
);

CREATE TABLE cat_tipo_tarjeta(
 	id VARCHAR(255) PRIMARY KEY,
	nombre varchar(255) DEFAULT NULL,
 	descripcion varchar(255) DEFAULT NULL,
 	estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_tipo_tarjeta(id, nombre, descripcion, estatus) VALUES(1,'visa','tarjetas de tipo visa',true);
insert into cat_tipo_tarjeta(id, nombre, descripcion, estatus) VALUES(2,'master-card','tarjetas de tipo mastercard',true);


CREATE TABLE negocios_tarjetas(
	 id_negocio VARCHAR(255),
	 id_tarjeta VARCHAR(255) ,
	 PRIMARY KEY(id_negocio, id_tarjeta),
	 FOREIGN KEY (id_negocio) REFERENCES negocio (id_negocio),
	 FOREIGN KEY (id_tarjeta) REFERENCES cat_tipo_tarjeta (id)
);

CREATE TABLE cat_categoria_negocios (
  id_categoria NUMERIC PRIMARY KEY,
  nombre varchar(255) DEFAULT NULL,
  descripcion varchar(255) DEFAULT NULL,
  estatus  BOOLEAN NOT NULL DEFAULT FALSE,
  fecha varchar(255) DEFAULT NULL
);

INSERT INTO cat_categoria_negocios (id_categoria,nombre,descripcion,estatus,fecha) VALUES (1,'restaurante','restaurante de mariscos',true,'2018-07-07');
INSERT INTO cat_categoria_negocios (id_categoria,nombre,descripcion,estatus,fecha) VALUES (2,'hotel','hotel 5 estrellas',true,'2018-07-07');

CREATE TABLE cat_dias(
id_dia NUMERIC PRIMARY KEY,
nombre varchar(255) DEFAULT NULL,
descripcion varchar(255) DEFAULT NULL,
estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(2,'lunes','lunes',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(3,'martes','martes',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(4,'miercoles','miercoles',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(5,'jueves','jueves',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(6,'viernes','viernes',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(7,'sabado','sabado',true);
insert into cat_dias(id_dia, nombre, descripcion, estatus) VALUES(1,'domingo','domingo',true);


CREATE TABLE negocio_horario(
id_negocio VARCHAR(255),
id_dia NUMERIC,
horario_inicial TIME NOT NULL,
horario_final TIME NOT NULL,
estatus BOOLEAN NOT NULL DEFAULT FALSE,
FOREIGN KEY (id_negocio) REFERENCES negocio (id_negocio),
FOREIGN KEY (id_dia) REFERENCES cat_dias (id_dia)
);

