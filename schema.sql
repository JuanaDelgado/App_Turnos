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