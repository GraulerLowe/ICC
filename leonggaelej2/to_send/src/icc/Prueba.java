package icc;

import java.util.Scanner;

import icc.colors.Colors;

public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println(mensaje);
            if (scn.hasNextInt()) {
                val = scn.nextInt();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    System.out.println(error);
                } else {
                    return val;
                }
            } else {
                scn.next();
                System.out.println(error);
            }
        }
    }
    public static void cancion(int max) {
        for (int i = max; i >= 1; i--) {
            System.out.print(i);
            System.out.println(" bottles of beer on the wall");
            System.out.print(i);
            System.out.println(" bottles of beer");
            System.out.println("If one of those bottles should happen to fall");
            System.out.print(i - 1);
            System.out.println(" bottles of beer on the wall");
            System.out.println();
        }
    }
    public static void triangulo (int aux) {
        for (int i = 1; i <= aux; i++){
                    for(int e = 0; e < i; e++){
                      System.out.print("*");
                    }
                   System.out.println("");
                }
    }
    public static void triangulo1 (int aux) {
        for (int i = aux; i >= 1; i--){
                  for(int k=1; k<=aux-i; k++){
                    System.out.print(" ");
                  }
                    for(int e = 1; e <= i; e++){
                      System.out.print("*");
                    }
                   System.out.println("");
                }
    }

    public static void main(String args[]) {
        int opcion, aux;
        String mensaje, error;
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("Este programa realiza la impresion de algunos ejercicios con for.\n");
        sb.append("1. Cancion.\n");
        sb.append("2. Triangulo 1.\n");
        sb.append("3. Triangulo 2.\n");
        sb.append("4. Triangulo 3.\n");
        sb.append("5. Triangulo 4.\n");
        sb.append("6. Rombo 4\n");
        sb.append("7. Reloj de Arena 4\n");
        sb.append("0. Salir.\n");
        sb.append("Escoje una opcion.\n");

        aux = -1;
        do {
            opcion = getInt(sb.toString(), "Por favor ingresa una opcion valida.", 0, 7);

            if (opcion != 0) {
                aux = getInt("Por favor ingresa un numero entre 1 y 100", "Por favor ingresa una opcion valida.", 1, 100);
            }
            switch (opcion) {
                case 1:
                    cancion(aux);
                    break;
                case 2:
                    triangulo(aux);
                break;
                case 3:
                triangulo1(aux);
                break;
                case 4:
                for (int i = aux; i >= 1; i--){
                  for(int e=1; e<=i; e++){
                    System.out.print("*");
                  }
                  System.out.println("");
                }
                break;
                case 5:
                for (int i = 1; i <= aux; i++){
                  for(int k=1; k<=aux-i; k++){
                    System.out.print(" ");
                  }
                    for(int e = 0; e < i; e++){
                      System.out.print("**");
                    }
                   System.out.println("");
                }
                break;
                case 6:
                    for (int i = 1; i <= aux; i++){//Parte de Arriba
                       for (int k=1; k<=aux-i; k++){
                         System.out.print(" ");
                       }
                       for(int e = 0; e < i; e++){
                          System.out.print("**");
                       }
                       System.out.println("");
                    }
                    for (int i = aux; i >= 1; i--){//Parte de Abajo
                       for (int k=1; k<=aux-i; k++){
                         System.out.print(" ");
                       }
                       for(int e = 0; e < i; e++){
                          System.out.print("**");
                       }
                       System.out.println("");
                    }
                break;
                case 7:
                    for (int i = aux; i >= 1; i--){
                       for (int k=1; k<=aux-i; k++){
                         System.out.print(" ");
                       }
                       for(int e = 0; e < i; e++){
                          System.out.print("*");
                       }
                      for(int e = 0; e < i; e++){
                          System.out.print("*");
                       }
                       System.out.println("");
                    }
///////////////////////////////////////////////////////////
                    for (int i = 1; i <= aux; i++){
                       for (int k=1; k<=aux-i; k++){
                         System.out.print(" ");
                       }
                       for(int e = 0; e < i; e++){
                          System.out.print("*");
                       }
                      for(int e = 0; e < i; e++){
                          System.out.print("*");
                       }
                       System.out.println("");
                    }
                break;
                case 0:
                    Colors.println("Vuelve pronto.", Colors.BLUE + Colors.HIGH_INTENSITY);
                    break;
            }
        } while (opcion != 0);
    }

}
