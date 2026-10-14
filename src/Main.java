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

        Turno t1 = new Turno(5L, c1, p1, LocalDateTime.of(2026, 10, 15, 10, 30), EstadoTurno.PENDIENTE);
        System.out.println(t1);

        Turno t2 = new Turno(6L, c1, p1, LocalDateTime.of(2026, 10, 20, 11, 30), EstadoTurno.CANCELADO);
        t2.setProfesional(p2);
        t2.setEstado(EstadoTurno.PENDIENTE);
        System.out.println(t2);
        c1.notificar("Hola " + c1.getNombre() + " Te avisamos que tu turno del 20/10 a las 11:30 "
        + "ahora será con " + t2.getProfesional().getNombre()
        + ". Su estado actual es " + t2.getEstado() + ". Te esperamos");

    }
}