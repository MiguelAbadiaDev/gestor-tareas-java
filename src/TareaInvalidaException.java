/**
 * Excepcion personalizada para tareas con invalidez
 * @author Miguel Abadía
 * @version 1.0
 */
public class TareaInvalidaException extends Exception {
    public TareaInvalidaException(String msg) {
        super(msg);
    }
}
