package icc;

import icc.colors.Colors;
import java.util.Scanner;

public class Prueba {
    public static void main (String args[]){

      int opcion;
      Scanner scn = new Scanner (System.in);
      Colors.println("Este es un programa que imprime una cancion por versos.", Colors.HIGH_INTENSITY);
      Colors.println("Elige un número del 1 al 12: ", Colors.HIGH_INTENSITY);

      opcion = scn.nextInt();

      do {
      if (opcion < 1 || opcion > 12){
        Colors.println("ingresa un dato valido.", Colors.HIGH_INTENSITY);
        opcion = scn.nextInt();
      }
    }while (opcion < 1 || opcion > 12);

    for (int c = 1; c <= opcion; c++){
        switch (c){
          case 1:
            Colors.println("On the first day of Christmas, my true love sent to me ", Colors.RED);
            Colors.println("A partridge in a pear tree ", Colors.HIGH_INTENSITY);
            System.out.println();
          break;
          case 2:
            Colors.println("On the second day of Christmas, my true love sent to me ", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 3:
            Colors.println("On the third day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 4:
            Colors.println("On the fourth day of Christmas, my true love sent to me ", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 5:
            Colors.println("On the fifth day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 6:
            Colors.println("On the sixth day of Christmas, my true love sent to me ", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 7:
            Colors.println("On the seventh day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Seven swans a-swimming", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 8:
            Colors.println("On the eighth day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Eight maids a-milking", Colors.RED);
            Colors.println("Seven swans a-swimming", Colors.HIGH_INTENSITY);
            Colors.println("Six geese a-laying", Colors.GREEN);
            Colors.println("Five golden rings", Colors.HIGH_INTENSITY);
            Colors.println("Four calling birds", Colors.RED);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 9:
            Colors.println("On the ninth day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Nine ladies dancing", Colors.RED);
            Colors.println("Eight maids a-milking", Colors.HIGH_INTENSITY);
            Colors.println("Seven swans a-swimming", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 10:
            Colors.println("On the tenth day of Christmas, my true love sent to me ", Colors.GREEN);
            Colors.println("Ten lords a-leaping", Colors.HIGH_INTENSITY);
            Colors.println("Nine ladies dancing", Colors.RED);
            Colors.println("Eight maids a-milking", Colors.HIGH_INTENSITY);
            Colors.println("Seven swans a-swimming", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 11:
            Colors.println("On the eleventh day of Christmas, my true love sent to me ", Colors.HIGH_INTENSITY);
            Colors.println("Eleven pipers piping", Colors.GREEN);
            Colors.println("Ten lords a-leaping", Colors.HIGH_INTENSITY);
            Colors.println("Nine ladies dancing", Colors.RED);
            Colors.println("Eight maids a-milking", Colors.HIGH_INTENSITY);
            Colors.println("Seven swans a-swimming", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
          case 12:
            Colors.println("On the twelfth day of Christmas, my true love sent to me ", Colors.RED);
            Colors.println("Twelve drummers drumming", Colors.HIGH_INTENSITY);
            Colors.println("Eleven pipers piping", Colors.GREEN);
            Colors.println("Ten lords a-leaping", Colors.HIGH_INTENSITY);
            Colors.println("Nine ladies dancing", Colors.RED);
            Colors.println("Eight maids a-milking", Colors.HIGH_INTENSITY);
            Colors.println("Seven swans a-swimming", Colors.GREEN);
            Colors.println("Six geese a-laying", Colors.HIGH_INTENSITY);
            Colors.println("Five golden rings", Colors.RED);
            Colors.println("Four calling birds", Colors.HIGH_INTENSITY);
            Colors.println("Three french hens", Colors.GREEN);
            Colors.println("Two turtle doves, and", Colors.HIGH_INTENSITY);
            Colors.println("A partridge in a pear tree ", Colors.RED);
            System.out.println();
          break;
        }
    }
  }
}
