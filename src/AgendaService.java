import java.time.LocalDateTime;
import java.util.*;

public class AgendaService {

    private final List<Turno> turnos = new ArrayList<>();
    private final Map<Long, Cliente> clientes = new HashMap<>();
    private final List<Profesional> profesionales = new ArrayList<>();

    public void agregarTurno(Turno turno) {
        if (turno.getHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se puede reservar un turno en el pasado: " + turno.getHora());
        }

        for (Turno existente : turnos) {
            boolean mismoProfesional = existente.getProfesional().getId().equals(turno.getProfesional().getId());
            boolean mismaHora = existente.getHora().equals(turno.getHora());
            boolean noCancelado = existente.getEstado() != EstadoTurno.CANCELADO;

            if (mismoProfesional && mismaHora && noCancelado) {
                throw new HorarioOcupadoException(turno.getProfesional().getNombre(), turno.getHora());
            }
        }
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
        throw new TurnoNoEncontradoException(id);
    }

    public Cliente buscarClienteXId(Long id) {
        return clientes.get(id);
    }

    public void cancelarTurno(Long id) {
        Turno turno = buscarTurnoXId(id);
        turno.setEstado(EstadoTurno.CANCELADO);
    }

    public Set<String> obtenerEspecialidades() {
        Set<String> especialidades = new HashSet<>();
        for(Profesional p : profesionales) {
            especialidades.add(p.getEspecialidad());
        }
        return especialidades;
    }

}
