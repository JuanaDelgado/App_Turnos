create table clientes (
    id BIGSERIAL primary key,
    nombre VARCHAR(100) not null,
    email VARCHAR(100) not null unique,
    telefono VARCHAR(20)
);

create table profesionales (
    id BIGSERIAL primary key,
    nombre VARCHAR(100) not null,
    especialidad VARCHAR(100) not null
);

create table turnos (
    id BIGSERIAL primary key,
    cliente_id BIGINT not null references clientes(id),
    profesional_id BIGINT not null references profesionales(id),
    fecha_hora TIMESTAMP not null,
    estado VARCHAR(20) not null
);

alter table turnos
add constraint uq_turnos_profesional_fecha unique (profesional_id, fecha_hora);

create index idx_turnos_fecha_hora on turnos (fecha_hora);