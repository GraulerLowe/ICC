
package icc.figuras;

/**
 * Interfaz que define metodos para saber si una figura encaja con un circulo o
 * un punto.
 *
 * @author Mindahrelfen
 */
public interface Matchable {

    /**
     * Metodo que revisa si el circulo dado encaja exactamente con este elipse.
     *
     * @param c Circulo con quien hacer la comparacion.
     * @return boolean true Si el circulo dado encaja exactamente con este elipse.
     */
    public boolean encaja(Circulo c);

    /**
     * Metodo que revisa si dos valores flotantes son casi iguales.
     *
     * @param d1 Primer valor a revisar.
     * @param d2 Segundo valor a revisar.
     * @param c Cota a igualar.
     *
     * @return boolean - true si d1 y d2 son casi iguales.
     */
    public static boolean almostEquals(double d1, double d2, double c) {
        if (d2 > d1) {      // d1 = 5, d2 = 7
            d1 = d1 + d2;   // d1 = 12
            d2 = d1 - d2;   // d2 = 5
            d1 = d1 - d2;   // d1 = 7
        }

        return 0 <= (d1 - d2) && (d1 - d2) <= c;
    }
}
