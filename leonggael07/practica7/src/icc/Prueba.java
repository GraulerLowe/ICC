package icc;

import icc.colors.Colors;
import icc.conversiones.FahrenheitToCelsius;
import icc.conversiones.CelsiusToFahrenheit;

import java.util.Scanner;

public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int val = 0;
        String s;
        Scanner scn = new Scanner(System.in);

        boolean continuar;

        do {
            try {
                Colors.println(mensaje, Colors.HIGH_INTENSITY);
                s = scn.next();
                val = Integer.parseInt(s);
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    throw new NumberFormatException();
                } else {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                continuar = true;
                scn.reset();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        } while (continuar);

        return val;
    }

    public static double getDouble(String mensaje, String error, double min, double max) {
        double val = 0;
        String s;
        Scanner scn = new Scanner(System.in);

        boolean continuar;

        do {
            try {
                Colors.println(mensaje, Colors.HIGH_INTENSITY);
                s = scn.next();
                val = Double.parseDouble(s);
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    throw new NumberFormatException();
                } else {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                continuar = true;
                scn.reset();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        } while (continuar);

        return val;
    }

    public static void main(String args[]) {

     int opcion;
     double aux;
     Scanner scn = new Scanner (System.in);
        String mensaje, error;
        StringBuilder sb;
        CelsiusToFahrenheit c = new CelsiusToFahrenheit();
        FahrenheitToCelsius f = new FahrenheitToCelsius();

        sb = new StringBuilder();
        sb.append("Bienvenido. Este programa convierte los grados Celsius a Fahrenheit y viceversa.\n");
        sb.append("1. Celsius a Fahrenheit.\n");
        sb.append("2. Fahrenheit a Celsius.\n");
        sb.append("0. Salir.\n");
        sb.append("Escoje una opcion.\n");

        do {
            opcion = getInt(sb.toString(), "Por favor ingresa una opcion valida.", 0, 2);

            switch (opcion) {
                case 1:
                    aux = getDouble("Ingresa los grados Celsius.", "Por favor ingresa un valor valido", -273.15 , Double.MAX_VALUE);
                    Colors.print((aux),  Colors.BLUE + Colors.HIGH_INTENSITY);
                    Colors.print(" grados Celsius son equivalentes a ", Colors.HIGH_INTENSITY);
                    aux = c.convert(aux);
                    Colors.print((aux),  Colors.GREEN + Colors.HIGH_INTENSITY);
                    Colors.println (" grados Fahrenheit", Colors.HIGH_INTENSITY);
                    System.out.println();
                    break;
                case 2:
                    aux = getDouble("Ingresa los grados Fahrenheit.", "Por favor ingresa un valor valido", -459.67 , Double.MAX_VALUE);
                    Colors.print((aux),  Colors.BLUE + Colors.HIGH_INTENSITY);
                    System.out.print(" grados Fahrenheit son equivalentes a ");
                    aux = f.convert(aux);
                    Colors.print((aux),  Colors.GREEN + Colors.HIGH_INTENSITY);
                    Colors.print(" grados Celsius", Colors.HIGH_INTENSITY);
                    System.out.println();
                    break;
                case 0:
                    Colors.println("Vuelve pronto.", Colors.BLUE + Colors.HIGH_INTENSITY);
                    break;
            }

        } while (opcion != 0);
    }
}
