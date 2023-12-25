
package icc.figuras;

import java.text.DecimalFormat;

import icc.colors.Colors;

/**
 * Clase que simula el funcionamiento de un poligono.
 *
 * @author Mindahrelfen
 */
public abstract class Poligono extends Figura {

    /**
     * Base del poligono.
     */
    protected double base;

    /**
     * Apotema del poligono.
     */
    protected double apotema;

    /**
     * Numero de lados.
     */
    protected int numLados;

    /**
     * Constructor que crea un Poligono con la apotema dada.
     *
     * @param numLados Numero de lados de esta figura
     * @param apotema Valor del base.
     */
    protected Poligono(int numLados, double base) {
        this.numLados = numLados;
        this.base = base;
        this.apotema = base / (2 * Math.tan(Math.PI / numLados));
        super.distancia = apotema / Math.cos(Math.PI / numLados);
    }

    /**
     * Metodo de acceso al base de este pentagono.
     *
     * @return double Base de este pentagono.
     */
    public double base() {
        return this.base;
    }

    /**
     * Metodo de acceso al apotema de este pentagono.
     *
     * @return double Apotema de este pentagono.
     */
    public double apotema() {
        return this.apotema;
    }

    /**
     * Metodo que calcula el perimetro del pentagono.
     *
     * @return double Perimetro de este pentagono.
     */
    public double perimetro() {
        return base() * this.numLados;
    }

    /**
     * Metodo que calcula el area del pentagono.
     *
     * @return double Area de este pentagono.
     */
    public double area() {
        return perimetro() * apotema() / 2.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat pattern = new DecimalFormat("0.0##");

        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tBase: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(base()) + "\n");
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tApotema: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(apotema()) + "\n");
        sb.append(super.toString());

        return sb.toString();
    }
}
