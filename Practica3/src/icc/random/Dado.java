
package icc.random;

import java.util.Random;

/**
 * Clase que se encarga de simular el comportamiento de un
 * <strong>dado</strong> de seis caras.
 *
 * @author Mindahrelfen
 */
public class Dado {

    /**
     * Metodo de devuelve un numero del 1 al 6.
     *
     * @return int Un numero aleatorio en un dado.
     */
    public int lanzar() {
        Random rdm = new Random();

        /**
         * Esta invocacion de nextInt devuelve un numero entero aleatorio en
         * [0, 6) o [0, 5]. Por ello, debemos sumar 1, para obtener un valor
         * entre [1, 6].
         */
        return rdm.nextInt(3) + 1;
    }
}
