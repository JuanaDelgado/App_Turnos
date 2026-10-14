public abstract class Persona {

    private Long id;
    private String nombre;

    public Persona(Long id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "id= " + id + ", nombre= " + nombre;
    }
}
