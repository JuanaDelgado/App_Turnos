--1. Todos los lcientes
select * from clientes;

--2. Solo nombre y especialidad de los profesionales
select nombre, especialidad from profesionales;

--3. Turnos pendientes
select * from turnos where estado = 'PENDIENTE';

--4. Especialidad traumatologa
select * from profesionales where especialidad = 'traumatologa';

--5. Turnos de Sebastian (profesional 1)
select * from turnos where profesional_id = 1;

--6. Turnos de Noelia (cliente 1)
select * from turnos where cliente_id = 1;

--7. Clientes sin telefono
select * from clientes where telefono is null;

--8. Turnos del más próximo al más lejano
select * from turnos order by fecha_hora;

--9. Clientes en orden alfabético
select * from clientes order by nombre;

--10. Los 3 turnos más próximos
select * from turnos order by fecha_hora limit 3;

--11. Turnos confirmados del 4/11, ordenados por hora
select * from turnos
where estado = 'PENDIENTE'
  and fecha_hora >= '2026-11-04'
  and fecha_hora < '2026-11-05'
order by fecha_hora;

--12. Cambiar el estado del turno 3. De pendiente a confirmado
select * from turnos where id = 3;
update turnos set estado = 'CONFIRMADO'where id = 3;
select  * from turnos where id = 3;

--13. Borrar el turno 2 (cancelado)
select * from turnos where id = 2;
delete from turnos where id = 2;
select * from turnos;

-- Listado de turnos con el nombre del cliente y del profesional
select t.id, c.nombre as cliente, p.nombre as profesional, t.fecha_hora, t.estado
from turnos t
inner join clientes c on t.cliente_id  = c.id
inner join profesionales p on t.profesional_id = p.id
order by t.fecha_hora;

-- Listado de profesionales, tengan o no turnos
select p.nombre as profesional, t.id as turno, t.fecha_hora
from profesionales p
left join turnos t on t.profesional_id = p.id
order by p.nombre ;

-- Contar turnos por profesional
select p.nombre as profesional, count(t.id) as cantidad_turnos
from profesionales p
left join turnos t on t.profesional_id = p.id
group by  p.nombre
order by cantidad_turnos desc;

-- Mostrar solo profesionales con más de 2 turnos
select p.nombre as profesional, COUNT(t.id) as cantidad_turnos
from profesionales p
left join turnos t on t.profesional_id = p.id
group by p.nombre
having COUNT(t.id) > 2
order by cantidad_turnos desc;

-- Prueba: Debe fallar porque Sebastian (1) ya tiene turno el 20/11 a las 10:00
insert into turnos (cliente_id, profesional_id, fecha_hora, estado)
values (2, 1, '2026-11-02 10:00:00', 'PENDIENTE');

explain select * from turnos where fecha_hora >= '2026-11-04';

-- Transacción que falla: el turno choca, asi que Carlos tampoco se registra
begin;
insert into clientes (nombre, email, telefono)
values ('Carlos Díaz', 'carlos@gmail.com', '1133334444');
insert into turnos (cliente_id, profesional_id, fecha_hora, estado)
values ((select id from clientes where email = 'carlos@gmail.com'), 1, '2026-11-02 10:00:00', 'PENDIENTE');
rollback;

-- Trasacción exitosa: horario libre, se guardan los dos
begin;
insert into clientes (nombre, email, telefono)
values ('Carlos Díaz', 'carlos@gmail.com', '1133334444');
insert into turnos (cliente_id, profesional_id, fecha_hora, estado)
values ((select id from clientes where email = 'carlos@gmail.com'), 1, '2026-11-10 11:00:00', 'PENDIENTE');
commit;