import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hola mundo!");

        Cliente c1 = new Cliente(1L, "Juan", "juana@gmail.com", "1123456789");
        Cliente c2 = new Cliente(2L, "María", "maria@gmail.com", "1198765432");

        Profesional p1 = new Profesional(3L, "Laura", "Arquitecta");
        Profesional p2 = new Profesional(4L, "Mario", "Medico");

        List<Persona> personas = List.of(c1, c2, p1, p2);
        c1.setEmail("juan@gmail.com");
        for (Persona p : personas) {
            System.out.println(p);
        }

        Turno t1 = new Turno(5L, c1, p1, LocalDateTime.of(2026, 11, 10, 10, 30), EstadoTurno.PENDIENTE);
        System.out.println(t1);

        Turno t2 = new Turno(6L, c1, p1, LocalDateTime.of(2026, 11, 12, 11, 30), EstadoTurno.CANCELADO);
        t2.setProfesional(p2);
        t2.setEstado(EstadoTurno.PENDIENTE);
        System.out.println(t2);
        c1.notificar("Hola " + c1.getNombre() + " Te avisamos que tu turno del 12/11 a las 11:30 "
        + "ahora será con " + t2.getProfesional().getNombre()
        + ". Su estado actual es " + t2.getEstado() + ". Te esperamos");

        AgendaService agenda = new AgendaService();
        agenda.agregarCliente(c1);
        agenda.agregarCliente(c2);

        agenda.agregarProfesional(p1);
        agenda.agregarProfesional(p2);

        agenda.agregarTurno(t1);
        agenda.agregarTurno(t2);

        System.out.println("--- Todos los turnos ---");
        for (Turno t : agenda.listarTurnos()) {
            System.out.println(t);
        }

        System.out.println("\n --- Búsqueda de turnos ---");
        System.out.println("Turno 2: " + agenda.buscarTurnoXId(6L));

        System.out.println("\n --- Cancelación ---");
        agenda.cancelarTurno(5L);
        System.out.println("Estado del turno 1: " + agenda.buscarTurnoXId(5L).getEstado());

        System.out.println("\n --- Búsqueda de clientes ---");
        System.out.println("Cliente 2: " + agenda.buscarClienteXId(2L));
        System.out.println("Cliente 10: " + agenda.buscarClienteXId(10L));

        System.out.println("\n --- Especialidades ---");
        System.out.println(agenda.obtenerEspecialidades());

        // Horario ocupado: Usá un profesuonal y una fecha que ya tengan turno
        try {
            agenda.agregarTurno(new Turno(7L, c2, p1, LocalDateTime.of(2026, 11, 12, 11, 0), EstadoTurno.PENDIENTE));
            System.out.println("Turno agregado");
        } catch (HorarioOcupadoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Turno que no existe
        try {
            agenda.cancelarTurno(99L);
        } catch (TurnoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            agenda.agregarTurno(new Turno(8L, c1, p2, LocalDateTime.of(2025, 1, 10, 9, 0), EstadoTurno.PENDIENTE));
            System.out.println("Turno agregado");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}