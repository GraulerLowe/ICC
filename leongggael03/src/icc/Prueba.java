package icc;

import java.util.Scanner;
import icc.colors.Colors;
import icc.random.Dado;

public class Prueba {
public enum  opciones {

    PIEDRA,PAPEL,TIJERA;
}

    public static void main(String args[]) {
     String respuestaJugador, piedra = "PIEDRA", papel = "PAPEL", tijera= "TIJERA";
      Dado dado = new Dado();
      int random;
      Scanner scn = new Scanner(System.in);

      Colors.println("Este juego es Piedra, Papel y Tijera.", Colors.HIGH_INTENSITY);
      Colors.println("Escoje alguna de las 3 opciones y la otra se escojera otra aleatoriamente: ", Colors.HIGH_INTENSITY);
      Colors.println(opciones.PIEDRA, Colors.HIGH_INTENSITY);
      Colors.println(opciones.PAPEL, Colors.HIGH_INTENSITY);
      Colors.println(opciones.TIJERA, Colors.HIGH_INTENSITY);
while (true){
      respuestaJugador = scn.nextLine().toUpperCase();
      random = dado.lanzar();

      if (respuestaJugador.equals(piedra)||respuestaJugador.equals(papel)||respuestaJugador.equals(tijera)){
        Colors.println("Has elegido: " + respuestaJugador, Colors.HIGH_INTENSITY);

        if (random == 1){
            Colors.println("Se eligió: " + opciones.PIEDRA, Colors.HIGH_INTENSITY);
        }
        else if (random == 2){
            Colors.println("Se eligió: " + opciones.PAPEL, Colors.HIGH_INTENSITY);
        }
        else if (random == 3){
         Colors.println("Se eligió: " + opciones.TIJERA, Colors.HIGH_INTENSITY);
        }
        break;      }
      else {
        Colors.println("Ingresa un dato válido", Colors.HIGH_INTENSITY);
      }
}
      if ( (respuestaJugador.equals(piedra) && random == 1) || (respuestaJugador.equals(papel) && random == 2) || (respuestaJugador.equals(tijera) && random == 3)){
        Colors.println("EMPATE", Colors.HIGH_INTENSITY);
        }
      else if ( (respuestaJugador.equals(piedra) && random == 3) || (respuestaJugador.equals(papel) && random == 1) || (respuestaJugador.equals(tijera) && random == 2)){
            Colors.println("GANASTE", Colors.BGD_GREEN);
        }
      else if( (respuestaJugador.equals(piedra) && random == 2) || (respuestaJugador.equals(papel) && random == 3) || (respuestaJugador.equals(tijera) && random == 1)){
        Colors.println("PERDISTE", Colors.BGD_RED);
      }
    }
}
