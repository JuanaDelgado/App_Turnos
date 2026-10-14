public class Profesional extends Persona {

    private String especialidad;

    public Profesional(Long id, String nombre, String especialidad) {
        super(id, nombre);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String toString() {
        return "Profesional: " + super.toString() + ", especialidad= " +especialidad;
    }

}
