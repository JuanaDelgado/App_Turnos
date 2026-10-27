# App Turnos

Sistema de gestión de turnos para un centro médico, desarrollado en Java puro como práctica de programación orientada a objetos, colecciones, excepciones y streams.

Permite registrar clientes y profesionales, reservar turnos, cancelarlos y consultarlos con distintos filtros, validando que no haya horarios superpuestos ni turnos en el pasado.

## Tecnologías

- Java 21
- IntelliJ IDEA
- Git y GitHub

## Estructura del proyecto

| Clase | Descripción |
|---|---|
| `Persona` | Clase abstracta con los datos comunes (id y nombre) |
| `Cliente` | Hereda de `Persona`; tiene email y teléfono, y puede recibir notificaciones |
| `Profesional` | Hereda de `Persona`; tiene una especialidad |
| `Turno` | Relaciona un cliente con un profesional en una fecha y hora, con un estado |
| `EstadoTurno` | Enum con los estados posibles: PENDIENTE, CONFIRMADO, CANCELADO y COMPLETADO |
| `Notificable` | Interfaz para las entidades que pueden recibir notificaciones |
| `AgendaService` | Gestiona clientes, profesionales y turnos, y aplica las reglas de negocio |
| `TurnoNoEncontradoException` | Se lanza al buscar un turno que no existe |
| `HorarioOcupadoException` | Se lanza al reservar un horario que el profesional ya tiene ocupado |

## Funcionalidades

- Alta y búsqueda de clientes por id
- Alta de profesionales y listado de especialidades sin repetir
- Reserva de turnos con validaciones:
    - No se permiten turnos en el pasado
    - Un profesional no puede tener dos turnos a la misma hora
- Cancelación de turnos (cambia el estado, sin borrar el registro)
- Consultas: turnos de un profesional, turnos por estado, turnos ordenados por fecha y cantidad de turnos por estado

## Conceptos aplicados

- **POO:** clases, encapsulamiento, herencia, clases abstractas, interfaces y polimorfismo
- **Colecciones:** `List`, `Map` y `Set`
- **Excepciones:** excepciones personalizadas, `throw` y `try/catch`
- **Fechas:** `LocalDateTime`
- **Programación funcional:** streams, lambdas, `Collectors.groupingBy` y `Optional`

## Cómo ejecutarlo

1. Clonar el repositorio:
```
   git clone https://github.com/TU-USUARIO/app-turnos.git
```
2. Abrir el proyecto en IntelliJ IDEA (requiere JDK 21).
3. Ejecutar la clase `Main`, que crea datos de prueba y muestra todas las funcionalidades por consola.

## Base de datos

El proyecto incluye scripts SQL para PostgreSQL:

- `schema.sql`: crea las tablas `clientes`, `profesionales` y `turnos`, con sus claves, restricciones e índices.
- `data.sql`: carga datos de prueba.
- `consultas.sql`: consultas de práctica (filtros, JOINs, agregaciones y transacciones).

Para levantar PostgreSQL con Docker:

```
docker run --name turnos-postgres -e POSTGRES_USER=turnos -e POSTGRES_PASSWORD=turnos123 -e POSTGRES_DB=turnos_db -p 5433:5432 -d postgres:16
```

Después, ejecutar `schema.sql` y luego `data.sql`.