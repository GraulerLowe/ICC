package icc.excepciones;

/**
 * Indica que no se encontró una búsqueda.
 */
public class NoEncontrado extends Exception {

    /**
     * Constructor.
     */
    public NoEncontrado() {
        super();
    }

    /**
     * Constructor.
     *
     * @param message Informacion detallada sobre el contexto en que ocurre
     * la excepcion.
     */
    public NoEncontrado(String message){
        super(message);
    }
}
