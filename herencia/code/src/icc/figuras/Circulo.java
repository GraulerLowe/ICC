
package icc.figuras;

import java.text.DecimalFormat;

import icc.colors.Colors;

/**
 * Clase que simula el funcionamiento de un circulo.
 *
 * @author Mindahrelfen
 */
public class Circulo extends Figura{

    /**
     * Double que denota el radio de un circulo.
     */
    private double radio;

    /**
     * Constructor que crea un circulo con el radio dado.
     *
     * @param radio Valor del radio.
     */
    public Circulo(double radio) {
        this.radio = radio;
        this.distancia = radio;
    }

    /**
     * Metodo de acceso al radio de este circulo.
     *
     * @return double Radio de este circulo.
     */
    public double radio() {
        return this.radio;
    }

    /**
     * Metodo de acceso al diametro de este circulo.
     *
     * @return double Diametro de este circulo.
     */
    public double diametro() {
        return radio() * 2.0;
    }

    @Override
    public double perimetro() {
        return Math.PI * diametro();
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radio(), 2.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat pattern = new DecimalFormat("0.0##");

        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tRadio: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(radio()) + "\n");
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tDiametro: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(diametro()) + "\n");
        sb.append(super.toString());

        return sb.toString();
    }
}
