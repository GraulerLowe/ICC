
package icc.figuras;

import java.text.DecimalFormat;

import icc.colors.Colors;

/**
 * Clase que simula el funcionamiento de un triangulo equilatero.
 *
 * @author Mindahrelfen
 */
public class TrianguloEquilatero extends Poligono {

    /**
     * Constructor que crea un triangulo equilatero con la base dada.
     *
     * @param base Valor del base.
     */
    public TrianguloEquilatero(double base) {
        super(3, base);
    }
}
