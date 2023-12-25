
package icc.arreglos;

import java.text.DecimalFormat;
import java.util.Iterator;

import icc.colors.Colors;

/**
 * Clase que simula el comportamiento de un vector.
 */
public class Vector {

    /**
     * Arreglo que aloja al vector.
     */
    private double[] vector;

    /**
     * Constructor por defecto, crea un vector de tamaño cero.
     */
    public Vector() {
        vector = new double[0];
    }

    /**
     * Constructor que crea un vector cero de tamaño <code>size</code>.
     *
     * @param size Tamaño del nuevo vector.
     */
    public Vector(int size) {
        vector = new double[size];
    }

    /**
     * Constructor de copia.
     *
     * @param v Vector del cual basar los datos.
     */
    public Vector(Vector v) {
        this(v.vector);
    }

    /**
     * Constructor que crea un vector en base a un arreglo double.
     *
     * @param vector Arreglo que contiene el vector a crear.
     */
    public Vector(double vector[]) {
        this.vector = new double[vector.length];

        for(int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
    }

    /**
     * Operacion que suma sobre este vector. this = this + scalar * v
     *
     * @param scalar Valor del escalar por el cual multiplicar <code>v</code>.
     * @param v Vector a sumar.
     */
    public void add(double scalar, Vector v) {
        int min = this.vector.length < v.vector.length ? this.vector.length : v.vector.length;

        for(int i = 0; i < min; i++) {
            this.vector[i] = this.vector[i] + (scalar * v.vector[i]);
        }
    }

    /**
     * Operacion que realiza el producto por escalar. this = scalar * v
     *
     * @param scalar Valor del escalar por el cual multiplicar <code>this</code>.
     */
    public void scalarProduct(double scalar) {
        for(int i = 0; i < this.vector.length; i++) {
            this.vector[i] = scalar * this.vector[i];
        }
    }

    /**
     * Operacion que obtiene la magnitud de este vector.
     *
     * @return double Magnitud de este vector.
     */
    public double magnitude() {
        double magnitude = 0;

        for(int i = 0; i < this.vector.length; i++) {
            magnitude = magnitude + (this.vector[i] * this.vector[i]);
        }

        return Math.sqrt(magnitude);
    }

    /**
     * Operacion que obtiene el orden de este vector
     *
     * @return int Orden de este vector.
     */
    public int order() {
        return this.vector.length;
    }

    /**
     * Obtiene el valor en el indice dado.
     *
     * @return double Valor dentro de este vector en el indice dado.
     */
    public double get(int index) {
        return this.vector[index];
    }

    /**
     * Devuelve el indice del primer elemento en este vector distinto de cero.
     *
     * @return int Indice del primer elemento en este vector distinto de cero.
     */
    public int getFirstNonZero() {
        for (int i = 0; i < vector.length; i++) {
            if (!isAlmostZero(vector[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Revisa si el numero dado es casi cero.
     *
     * @param d Valor a revisar.
     * @return boolean true si d es casi cero, false en otro caso.
     */
    private boolean isAlmostZero(double d) {
        return -0.01 < d && d < 0.01;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat pattern = new DecimalFormat("0.0##");

        sb.append(Colors.WHITE + Colors.HIGH_INTENSITY);
        sb.append("[");
        for (int i = 0; i < this.vector.length; i++) {
            if (isAlmostZero(this.vector[i])) {
                this.vector[i] = 0;
                sb.append(pattern.format(this.vector[i]));
            } else {
                sb.append(Colors.CYAN + Colors.HIGH_INTENSITY);
                sb.append(pattern.format(this.vector[i]));
                sb.append(Colors.WHITE + Colors.HIGH_INTENSITY);
            }
            if (i < this.vector.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append(Colors.RESTORE);

        return sb.toString();
    }
}
