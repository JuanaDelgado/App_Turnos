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
