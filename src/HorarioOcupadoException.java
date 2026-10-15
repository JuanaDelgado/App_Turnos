import java.time.LocalDateTime;

public class HorarioOcupadoException extends RuntimeException {

    public HorarioOcupadoException(String profesional, LocalDateTime hora) {
        super("El profesional " + profesional + " ya tiene un turno el " + hora);
    }

}
