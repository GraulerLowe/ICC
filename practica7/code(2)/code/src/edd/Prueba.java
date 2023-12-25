
package edd;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Prueba {
    public static void main(String args[]) {
        // Crea arreglo de transacciones.
        Transaction[] a = new Transaction[4];
        a[0] = new Transaction("Turing   6/17/1990  644.08");
        a[1] = new Transaction("Tarjan   3/26/2002 4121.85");
        a[2] = new Transaction("Knuth    6/14/1999  288.34");
        a[3] = new Transaction("Dijkstra 8/22/2007 2678.40");

        // Imprime dicho arreglo.
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        Transaction[] b = new Transaction[4];
        try {
            // Guarda el arreglo de transacciones en el archivo file.txt.
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < a.length; i++){
                objectOutputStream.writeObject(a[i]);
            }
            objectOutputStream.flush();
            objectOutputStream.close();

            // Lee el arreglo de transacciones del archivo file.txt.
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for (int i = 0; i < b.length; i++){
                b[i] = (Transaction) objectInputStream.readObject();
            }
            objectInputStream.close();
        } catch(IOException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }

        // Imprime el nuevo arreglo arreglo.
        System.out.println("\nAfter writing and reading file:\n");
        for (int i = 0; i < b.length; i++)
            StdOut.println(b[i]);

        // Literalmente ambos arreglos son iguales.
        System.out.println("\nAre they equal one on one?\n");
        for (int i = 0; i < b.length; i++)
            StdOut.println(a[i].equals(b[i]));
    }
}
