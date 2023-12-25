
package icc;

import java.util.Scanner;

import icc.colors.Colors;
import icc.figuras.*;
import icc.puntos.Punto;

/**
 * Clase de introduccion.
 */
public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (scn.hasNextInt()) {
                val = scn.nextInt();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return val;
                }
            } else {
                scn.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static double getDouble(String mensaje, String error, double min, double max) {
        double val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (scn.hasNextDouble()) {
                val = scn.nextDouble();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return val;
                }
            } else {
                scn.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static String getLine(String msg) {
        Scanner scn = new Scanner(System.in);

        Colors.println(msg, Colors.HIGH_INTENSITY);

        return scn.next();
    }

    public static void reporte(Figura f, Circulo c) {
        String nombre1, nombre2;
        String arr[];

        arr = f.getClass().getName().split("\\.");
        nombre1 = arr[arr.length - 1];

        arr = c.getClass().getName().split("\\.");
        nombre2 = arr[arr.length - 1];

        Colors.println(nombre1 + " 1:", Colors.CYAN);
        System.out.println(f);
        Colors.println(nombre2 + " 2:", Colors.CYAN);
        System.out.println(c);

        if (f.encaja(c)) {
            Colors.println("El " + nombre1.toLowerCase() + " 1 encaja con el " + nombre2.toLowerCase() + " 2.", Colors.GREEN);
        } else {
            Colors.println("El " + nombre1.toLowerCase() + " 1 no encaja con el " + nombre2.toLowerCase() + " 2.", Colors.RED);
        }
    }

    public static void main(String args[]) {
        int opcion;
        double aux;
        Circulo c;
        Figura f;

        StringBuilder sb;

        f = null;
        c = null;

        sb = new StringBuilder();
        sb.append("Este programa realiza la revision de si alguna de las siguientes figuras encaja en un circulo.\n");
        sb.append("1. Circulo.\n");
        sb.append("2. Elipse.\n");
        sb.append("3. Triangulo Equilatero.\n");
        sb.append("4. Cuadrado.\n");
        sb.append("5. Pentagono.\n");
        sb.append("6. Hexagono.\n");
        sb.append("7. Heptagono.\n");
        sb.append("8. Octagono.\n");
        sb.append("0. Salir.\n");
        sb.append("Escoje una opcion.\n");

        do {
            opcion = getInt(sb.toString(), "Por favor ingresa una opcion valida.", 0, 8);

            if (opcion != 0 && opcion != 2) {
                aux = getDouble("Primero ingresa el radio del circulo a encajar:", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                c = new Circulo(aux);
            }

            switch (opcion) {
                case 1:
                    aux = getDouble("Ingresa el radio del otro circulo.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Circulo(aux);
                    break;
                case 2:
                    Colors.println("Elipse aun no esta implementado.", Colors.RED + Colors.HIGH_INTENSITY);
                    break;
                case 3:
                    aux = getDouble("Ingresa la base del triangulo equilatero.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new TrianguloEquilatero(aux);
                    break;
                case 4:
                    aux = getDouble("Ingresa la base del cuadrado.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Cuadrado(aux);
                    break;
                case 5:
                    aux = getDouble("Ingresa la base del pentagono.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Pentagono(aux);
                    break;
                case 6:
                    aux = getDouble("Ingresa la base del hexagono.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Hexagono(aux);
                    break;
                case 7:
                    aux = getDouble("Ingresa la base del heptagono.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Heptagono(aux);
                    break;
                case 8:
                    aux = getDouble("Ingresa la base del octagono.", "Por favor ingresa un numero positivo", 0, Double.MAX_VALUE);
                    f = new Octagono(aux);
                    break;
                case 0:
                    Colors.println("Vuelve pronto.", Colors.BLUE + Colors.HIGH_INTENSITY);
                    break;
            }

            reporte(f, c);
        } while (opcion != 0);
    }
}
