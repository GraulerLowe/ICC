
package icc.figuras;

import java.text.DecimalFormat;

import icc.colors.Colors;

/**
 * Clase que simula el funcionamiento de una figura.
 *
 * @author Mindahrelfen
 */
public abstract class Figura implements Matchable {

    /**
     * Distancia del centro de esta figura al borde mas lejano de esta.
     */
    protected double distancia;

    /**
     * Metodo que calcula el perimetro de esta figura
     *
     * @return double Perimetro de esta figura.
     */
    public abstract double perimetro();

    /**
     * Metodo que calcula el area de esta figura
     *
     * @return double Area de esta figura.
     */
    public abstract double area();


    @Override
    public boolean encaja(Circulo c) {
        return Matchable.almostEquals(c.radio(), distancia, 0.0005);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat pattern = new DecimalFormat("0.0##");

        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tPerimetro: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(perimetro()) + "\n");
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tArea: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(area()) + "\n");

        return sb.toString();
    }
}
