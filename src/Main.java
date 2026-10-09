//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hola mundo!");

        Cliente c1 = new Cliente(1L, "Juan", "juana@gmail.com", "1123456789");
        System.out.println(c1);

        c1.setEmail("juan1@gmail.com");
        System.out.println("Nuevo email de Juana: " + c1.getEmail());

        Cliente c2 = new Cliente(2L, "María", "maria@gmail.com", "1198765432");
        System.out.println(c2);

        Profesional p1 = new Profesional(3L, "Laura", "Arquitecta");
        System.out.println(p1);

        Profesional p2 = new Profesional(4L, "Mario", "Medico");
        System.out.println(p2);


    }
}