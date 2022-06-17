#Creación de tabla sendero_seguro_schema.catalogo_tipo_usuario
CREATE TABLE sendero_seguro_schema.catalogo_tipo_usuario
(
    id_tipo_usuario serial NOT NULL,
    tipo_usuario character varying(20) NOT NULL,
    descripcion character varying(100) NOT NULL,
    fecha_creacion_bd timestamp without time zone NOT NULL,
    fecha_ultimo_movimiento timestamp without time zone NOT NULL,
    PRIMARY KEY (id_tipo_usuario),
    CONSTRAINT catalogo_tipo_usuario_tipo_usuario_unique UNIQUE (tipo_usuario)
)
WITH (
    OIDS = FALSE
);





CREATE TABLE sendero_seguro_schema.catalogo_rol_web
(
    id_rol_web serial NOT NULL,
    rol_web character varying(20) NOT NULL,
    descripcion character varying(100) NOT NULL,
    fecha_creacion_bd timestamp without time zone NOT NULL,
    fecha_ultimo_movimiento timestamp without time zone NOT NULL,
    PRIMARY KEY (id_rol_web),
    CONSTRAINT catalogo_rol_web_rol_web_unique UNIQUE (rol_web)
)
WITH (
    OIDS = FALSE
);





CREATE TABLE sendero_seguro_schema.catalogo_estatus_usuario
(
    id_estatus_usuario serial NOT NULL,
    estatus_usuario character varying(20) NOT NULL,
    descripcion character varying(100) NOT NULL,
    fecha_creacion_bd timestamp without time zone NOT NULL,
    fecha_ultimo_movimiento timestamp without time zone NOT NULL,
    PRIMARY KEY (id_estatus_usuario),
    CONSTRAINT catalogo_estatus_usuario_estatus_usuario_unique UNIQUE (estatus_usuario)
)
WITH (
    OIDS = FALSE
);




CREATE TABLE sendero_seguro_schema.usuario_web
(
    id_usuario_web serial NOT NULL,
    correo character varying(70) NOT NULL,
    contrasena character varying(60),
    nombres character varying(100) NOT NULL,
    apellidos character varying(100),
    id_rol_web integer NOT NULL,
    id_estatus integer NOT NULL,
    fecha_creacion_bd timestamp without time zone NOT NULL,
    fecha_ultimo_movimiento timestamp without time zone NOT NULL,
    PRIMARY KEY (id_usuario_web),
    CONSTRAINT id_rol_web_fk FOREIGN KEY (id_rol_web)
        REFERENCES sendero_seguro_schema.catalogo_rol_web (id_rol_web) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_estatus_fk FOREIGN KEY (id_estatus)
        REFERENCES sendero_seguro_schema.catalogo_estatus_usuario (id_estatus_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
WITH (
    OIDS = FALSE
);





CREATE TABLE sendero_seguro_schema.usuario_movil
(
    id_usuario_movil serial NOT NULL,
    correo character varying(70) NOT NULL,
    contrasena character varying(60),
    nombres character varying(100) NOT NULL,
    apellidos character varying(100),
    id_tipo_usuario integer NOT NULL,
    id_estatus integer NOT NULL,
    fecha_creacion_bd timestamp without time zone NOT NULL,
    fecha_ultimo_movimiento timestamp without time zone NOT NULL,
    PRIMARY KEY (id_usuario_movil),
    CONSTRAINT id_tipo_usuario_fk FOREIGN KEY (id_tipo_usuario)
        REFERENCES sendero_seguro_schema.catalogo_tipo_usuario (id_tipo_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_estatus_fk FOREIGN KEY (id_estatus)
        REFERENCES sendero_seguro_schema.catalogo_estatus_usuario (id_estatus_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
WITH (
    OIDS = FALSE
);




insert into sendero_seguro_schema.catalogo_estatus_usuario (estatus_usuario, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('ACTIVO', 'Este estaus representa a los usuarios activos.', now(), now());
insert into sendero_seguro_schema.catalogo_estatus_usuario (estatus_usuario, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('INACTIVO', 'Este estaus representa a los usuarios inactivos.', now(), now());

insert into sendero_seguro_schema.catalogo_rol_web (rol_web, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('ADMINISTRADOR', 'Este estaus representa a los usuarios administradores.', now(), now());
insert into sendero_seguro_schema.catalogo_rol_web (rol_web, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('VISUALIZADOR', 'Este estaus representa a los usuarios visualizadores.', now(), now());

insert into sendero_seguro_schema.catalogo_tipo_usuario (tipo_usuario, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('ALUMNO', 'Este estaus representa a los usuarios de tipo alumno.', now(), now());
insert into sendero_seguro_schema.catalogo_tipo_usuario (tipo_usuario, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('CONDUCTOR', 'Este estaus representa a los usuarios de tipo conductor.', now(), now());
insert into sendero_seguro_schema.catalogo_tipo_usuario (tipo_usuario, descripcion, fecha_creacion_bd, fecha_ultimo_movimiento)
values ('TUTOR', 'Este estaus representa a los usuarios de tipo tutor.', now(), now());
