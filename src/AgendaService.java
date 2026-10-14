import java.util.*;

public class AgendaService {

    private final List<Turno> turnos = new ArrayList<>();
    private final Map<Long, Cliente> clientes = new HashMap<>();
    private final List<Profesional> profesionales = new ArrayList<>();

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void agregarProfesional(Profesional profesional) {
        profesionales.add(profesional);
    }

    public List<Turno> listarTurnos() {
        return turnos;
    }

    public Turno buscarTurnoXId(Long id) {
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    public Cliente buscarClienteXId(Long id) {
        return clientes.get(id);
    }

    public void cancelarTurno(Long id) {
        Turno turno = buscarTurnoXId(id);
        if(turno != null){
            turno.setEstado(EstadoTurno.CANCELADO);
        }
    }

    public Set<String> obtenerEspecialidades() {
        Set<String> especialidades = new HashSet<>();
        for(Profesional p : profesionales) {
            especialidades.add(p.getEspecialidad());
        }
        return especialidades;
    }

}
