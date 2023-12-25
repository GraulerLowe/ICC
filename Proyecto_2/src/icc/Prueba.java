package icc;

import java.util.Scanner;
import icc.colors.Colors;
import icc.gestor.Gestor;
import icc.modelo.*;
import icc.excepciones.*;

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

    public static void main(String[] args) {
      Colors.println("Bienvenido. Este programa es un gestor de artículos de entretenimiento.", Colors.CYAN + Colors.HIGH_INTENSITY);
      StringBuilder sb = new StringBuilder("Escoge una opción:\n\n");
      sb.append("1. Gestionar libros.\n");
      sb.append("2. Gestionar discos.\n");
      sb.append("3. Gestionar películas.\n");
      sb.append("0. Salir.\n");

      boolean sigue = true; // Lleva el control de si el programa se sigue ejecutando.
      do {
        int opc = getInt(sb.toString(), "Por favor, ingresa un valor entero entre 0 y 3 (inclusivo).", 0, 3);

         switch (opc) {
           case 1:
            menuLibros();
           break;
           case 2:
            menuDiscos();
           break;
           case 3:
            menuPelis();
           break;
           default:
            sigue = false;
         }
      } while (sigue);

      Colors.println("Vuelve pronto.", Colors.MAGENTA + Colors.HIGH_INTENSITY);
    }
    /**
    ** Se encarga de crear un menú para los  libros.
    ** En el menú se puede consultar por tema, título, consulta general y
    ** añadir un nuevo libro.
    **/
    public static void menuLibros() {
      StringBuilder sb = new StringBuilder("Menú de libros.\n1. Consulta por autor.\n");
      sb.append("2. Consulta por tema.\n");
      sb.append("3. Consulta por título.\n");
      sb.append("4. Consulta completa.\n");
      sb.append("5. Añadir libro.\n");
      sb.append("0. Regresar al menú anterior.\n");

      boolean sigue = true;
      Scanner teclitas = new Scanner(System.in);

      do {
        int opc = getInt(sb.toString(), "Por favor, elige una opción correcta.", 0, 5);
        switch (opc){
          case 1:
          System.out.println("Ingrese el autor que desee buscar.");
          try{
            Gestor.leerYComparar("libros.csv", teclitas.nextLine(), 2);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 2:
          System.out.println("Ingrese el tema sobre el que desee consultar libros.");
          try{
            Gestor.leerYComparar("libros.csv", teclitas.nextLine(), 3);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 3:
          System.out.println("Ingrese el título del libro que desee consultar.");
          try{
            Gestor.leerYComparar("libros.csv", teclitas.nextLine(), 0);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 4:
            Gestor.consultarTodo(1);
          break;
          case 5:
          Gestor.insertaLibros();
          break;
          default:
          sigue = false;
        }
      } while (sigue);

    }
    /**
    ** Se encarga de crear un menu para las películas.
    ** En el menú se puede consultar actores, género de las peliculas, consulta general y
    ** añadir una nueva película.
    **/
    public static void menuPelis() {
      StringBuilder sb = new StringBuilder("Menú de películas.\n1. Consultar los filmes grabados en un año en específico o posterior.\n");
      sb.append("2. Consultar actores o actrices que aparezcan en más de una pelicula.\n");
      sb.append("3. Consulta por género.\n");
      sb.append("4. Consulta completa.\n");
      sb.append("5. Añadir pelicula.\n");
      sb.append("0. Regresar al menú anterior.\n");

      boolean sigue = true;
      Scanner teclitas = new Scanner(System.in);
      do {
        int opc = getInt(sb.toString(), "Por favor, elige una opción correcta.", 0, 5);
        switch(opc){
          case 1:
          Gestor.filmByYear(getInt("Ingrese el año a partir del cuál quiere consultar películas.", "Ingrese un número y año válido. (>= 1888)", 1888, Integer.MAX_VALUE));
          break;
          case 2:
          Gestor.actoresChambeadores();
          break;
          case 3:
          System.out.println("Ingrese el género que quiera consultar.");
          try{
            Gestor.leerYComparar("peliculas.csv", teclitas.nextLine(), 1);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 4:
          Gestor.consultarTodo(3);
          break;
          case 5:
          Gestor.insertaPelis();
          break;
          default:
            sigue = false;
        }
      } while (sigue);

    }
    /**
    ** Se encarga de crear un menú para los discos.
    ** En el menú se puede consultar por género, más de 10 pistas, consulta general y
    ** añadir un nuevo disco.
    **/
    public static void menuDiscos() {
      StringBuilder sb = new StringBuilder("Menú de Discos.\n1. Consulta por intérprete.\n");
      sb.append("2. Consulta por género.\n");
      sb.append("3. Consulta por más de 10 pistas.\n");
      sb.append("4. Consulta completa.\n");
      sb.append("5. Añadir disco.\n");
      sb.append("0. Regresar al menú anterior.\n");

      boolean sigue = true;
      Scanner teclitas = new Scanner(System.in);
      do {
        int opc = getInt(sb.toString(), "Por favor, elige una opción correcta.", 0, 5);
        switch (opc){
          case 1:
          System.out.println("Ingrese el nombre del artista cuyos discos quiera consultar.");
          try{
            Gestor.leerYComparar("discos.csv", teclitas.nextLine(), 2);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 2:
          System.out.println("Ingrese el nombre del género cuyos discos quiera consultar.");
          try{
            Gestor.leerYComparar("discos.csv", teclitas.nextLine(), 1);
          }
          catch (Exception e) {
            Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
          }
          break;
          case 3:
          Gestor.tenPlusTracks();
          break;
          case 4:
          Gestor.consultarTodo(2);
          break;
          case 5:
          Gestor.insertaDiscos();
          break;
          default:
          sigue = false;
        }
      } while (sigue);

    }

}
