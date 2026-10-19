import java.time.LocalDateTime;
import java.util.List;

public class Turno {

    private Long id;
    private Cliente cliente;
    private Profesional profesional;
    private LocalDateTime hora;
    private EstadoTurno estado;

    public Turno(Long id, Cliente cliente, Profesional profesional, LocalDateTime hora, EstadoTurno estado) {
        setId(id);
        setCliente(cliente);
        setProfesional(profesional);
        setHora(hora);
        setEstado(estado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id  = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente  = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional  = profesional;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora  = hora;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado  = estado;
    }

    public String toString() {
        return "Turno: id= " + id + ", cliente= " + cliente + ", profesional= " + profesional + ", hora= " + hora + ", estado= " + estado;
    }

}
