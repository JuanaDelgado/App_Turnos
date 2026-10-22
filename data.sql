insert into clientes (nombre, email, telefono)
values
    ('Noelia Martínez', 'noelia@gmail.com', '1112345678')
    ('Tomas Lopez', 'tomas1@gmail.com', '1112348765'),
    ('María Garcia', 'margarcia@gmail.com', '1187654321'),
    ('Juan Pérez', 'juan@gmail.com', '1187651234'),
    ('Lucía Fernandez', 'lucia@gmail.com', NULL);

insert into profesionales (nombre, especialidad)
values
    ('Sebastian Brey', 'cirujano'),
    ('Antonia Blanco', 'dermatologa'),
    ('Veronica Marínez', 'traumatologa');

insert into turnos (cliente_id, profesional_id, fecha_hora, estado)
values
    (1, 1, '2026-11-02 10:00:00', 'COMPLETADO'),
    (2, 2, '2026-11-02 11:30:00', 'CANCELADO'),
    (3, 3, '2026-11-03 10:00:00', 'PENDIENTE'),
    (4, 1, '2026-11-03 10:45:00', 'PENDIENTE'),
    (5, 2, '2026-11-03 12:00:00', 'CONFIRMADO'),
    (1, 3, '2026-11-04 15:00:00', 'CONFIRMADO'),
    (2, 1, '2026-11-04 15:30:00', 'PENDIENTE'),
    (3, 2, '2026-11-04 15:50:00', 'PENDIENTE'),
    (4, 3, '2026-11-04 10:30:00', 'PENDIENTE'),
    (5, 1, '2026-11-04 9:40:00', 'CONFIRMADO');