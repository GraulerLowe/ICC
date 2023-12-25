
package icc.figuras;

import java.text.DecimalFormat;

import icc.colors.Colors;
import icc.puntos.Punto;

/**
 * Clase que simula el funcionamiento de un elipse.
 *
 * @author Mindahrelfen
 */
public class Elipse extends Figura {

    private double ejeMayor;

    private double ejeMenor;

    /**
     * Constructor que crea un elipse con ambos ejes dados.
     *
     * @param ejeMayor Valor del eje mayor.
     * @param ejeMenor Valor del eje menor.
     */
    public Elipse(double ejeMayor, double ejeMenor) {
        if (ejeMayor > ejeMenor) {
            this.ejeMayor = ejeMayor;
            this.ejeMenor = ejeMenor;
        } else {
            this.ejeMayor = ejeMenor;
            this.ejeMenor = ejeMayor;
        }
        super.distancia = this.ejeMenor / 2.0;
    }

    /**
     * Metodo de acceso al eje mayor de este elipse.
     *
     * @return double Eje mayor de este elipse.
     */
    public double ejeMayor() {
        return this.ejeMayor;
    }

    /**
     * Metodo de acceso al eje menor de este elipse.
     *
     * @return double Eje menor de este elipse.
     */
    public double ejeMenor() {
        return this.ejeMenor;
    }

    @Override
    public double perimetro() {
        double a, b;
        a = ejeMayor() / 2.0;
        b = ejeMenor() / 2.0;
        return Math.PI * ((3 * (a + b)) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }

    @Override
    public double area() {
        return Math.PI * ejeMayor() * ejeMenor() / 4.0;
    }

    /**
     * Metodo que revisa si el punto dado encaja exactamente con este elipse.
     *
     * @param p Punto con quien hacer la comparacion.
     * @return boolean true Si el punto dado encaja exactamente con este elipse.
     */
    public boolean encaja(Punto p) {
        double x, y, a, b;
        a = ejeMayor() / 2.0;
        b = ejeMenor() / 2.0;
        x = p.getX();
        y = p.getY();

        return almostEquals(1.0, ((x * x) / (a * a)) + ((y * y) / (b * b)));
    }

    /**
     * Metodo que revisa si el punto se encuentra estrictamente dentro este elipse.
     *
     * @param p Punto con quien hacer la comparacion.
     * @return boolean true Si el punto dado se encuentra dentro de este elipse.
     */
    public boolean pertenece(Punto p) {
        double x, y, a, b;

        if (encaja(p)) {
            return false;
        } else {
            a = ejeMayor() / 2.0;
            b = ejeMenor() / 2.0;
            x = p.getX();
            y = p.getY();

            return 1.0 > (((x * x) / (a * a)) + ((y * y) / (b * b)));
        }
    }

    /**
     * Metodo que revisa si dos valores flotantes son casi iguales.
     *
     * @param d1 Primer valor a revisar.
     * @param d2 Segundo valor a revisar.
     *
     * @return boolean - true si d1 y d2 son casi iguales.
     */
    public static boolean almostEqualsC(double d1, double d2) {
        if (d2 > d1) {      // d1 = 5, d2 = 7
            d1 = d1 + d2;   // d1 = 12
            d2 = d1 - d2;   // d2 = 5
            d1 = d1 - d2;   // d1 = 7
        }

        return 0 <= (d1 - d2) && (d1 - d2) <= 0.0005;
    }

    /**
     * Metodo que revisa si dos valores flotantes son casi iguales.
     *
     * @param d1 Primer valor a revisar.
     * @param d2 Segundo valor a revisar.
     *
     * @return boolean - true si d1 y d2 son casi iguales.
     */
    public static boolean almostEquals(double d1, double d2) {
        if (d2 > d1) {      // d1 = 5, d2 = 7
            d1 = d1 + d2;   // d1 = 12
            d2 = d1 - d2;   // d2 = 5
            d1 = d1 - d2;   // d1 = 7
        }

        return 0 <= (d1 - d2) && (d1 - d2) <= 0.00001;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat pattern = new DecimalFormat("0.0##");

        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tEje Mayor: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(ejeMayor()) + "\n");
        sb.append(Colors.HIGH_INTENSITY);
        sb.append("\tEje Menor: ");
        sb.append(Colors.RESTORE);
        sb.append(pattern.format(ejeMenor()) + "\n");
        sb.append(super.toString());

        return sb.toString();
    }
}
