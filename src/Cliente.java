public class Cliente extends Persona implements Notificable {

    private String email;
    private String telefono;

    public Cliente(Long id, String nombre, String email, String telefono) {
        super(id, nombre);
        setEmail(email);
        setTelefono(telefono);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return "Cliente: " + super.toString() + ", email= " + email + ", telefono= " + telefono;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando email a " + email + ": " + mensaje );
    }

}
