public class TurnoNoEncontradoException extends RuntimeException {

    public TurnoNoEncontradoException(Long id) {
        super("No existe un turno con id " + id);
    }

}
