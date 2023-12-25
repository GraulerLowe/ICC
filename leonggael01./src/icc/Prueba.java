package icc;

import java.math.BigInteger;
public class Prueba {

    public static void main(String[] args) {
        System.out.println("***** P R A C T I C A   1 ***** \n");

        /**
         * 1. Calcula el precio total resultante de la compra de tantos
         * artículos como indica numArticulos, cada uno con precio igual a
         * precioUnitario, declara una variable que almacene ese resultado e
         * imprime su valor en pantalla.
         */

        short numArticulos = 30;
        float precioUnitario = 15.42f;
        float precioResultante = 0;

        precioResultante = numArticulos * precioUnitario;

        System.out.println("\t 1. Calcula el precio total resultante \t ");
        System.out.println("\t Numero de Articulos:\t " + numArticulos);
        System.out.println("\t Precio Unitario:\t " + precioUnitario);
        System.out.println("\t Precio total resultante:\t " + precioResultante);

        /**
         * 2. Calcula el precio de todos los artículos con IVA incluido,
         * asignando el resultado a una variable e imprime su valor en pantalla.
         */

        final double IVA = 0.16;
        double precioIVA = 0;

        precioIVA = ((precioResultante * IVA) + precioResultante);
        System.out.println("\t 2. Calcula el precio total resultante con IVA incluido \t ");
        System.out.println("\t Porcentaje del IVA:\t " + IVA);
        System.out.println("\t Precio total resultante con IVA:\t " + precioIVA);
        /** \t
         * 3. imprime en pantalla los valores de las variables caracter y valor.
         */

        char caracter = 'c';
        boolean valor = true;
        System.out.println("\t 3. Imprime los valores de las variables caracter y valor \t ");
        System.out.println("\t Valor de variable caracter:\t " + caracter);
        System.out.println("\t Valor de variable valor:\t " + valor);
        /**
         * Define constantes o variables para representar los siguientes datos,
         * trata de usar un tipo de datos adecuado  (suficiente para que se
         * pueda representar lo que se necesita).
         */

        // 4. El numero de lados de una figura geométrica.
        int trig = 3, cu = 4;
        System.out.println("\t 4. El numero de lados de una figura geométrica.\t ");
        System.out.println("\t Numero de lados del triángulo: \t " + trig);
        System.out.println("\t Numero de lados del cuadrado: \t " + cu);
        // 5. ¿Eres menor de edad?
        int mayor = 18;
        String cadenaS = "Eres mayor a partir de los ";
        String cadenaN = " Eres menor si tienes menos de ";
        String cadenag = " años";
        String edad = cadenaS + mayor + cadenag;
        String edadn = cadenaN + mayor + cadenag;
        System.out.println("\t ¿Eres menor de edad? \t ");
        System.out.println("\t No, yo tengo \t "+ mayor);
        System.out.println(edad);
        System.out.println(edadn);
        // 6. El número 34567.236789.
        double decimal = 34567.236789;
        System.out.println("\t 6. El número 34567.236789 \t ");
        System.out.println("\t Numero: " + decimal);
        // 7. El símbolo $.
        String simbolo = " $";
        System.out.println("\t 7. El símbolo $.\t ");
        System.out.println (simbolo);
        // 8. El número 14506783914
        BigInteger num = new BigInteger("14506783914");
        System.out.println("\t 8. El número 14506783914");
        System.out.println("\t Numero: " + num);
        // 9. El área de un cuadrado cuya longitud de lado es a lo mucho 100 unidades.
        int lado = 100, area = 0;
        area = lado * lado;
        System.out.println("\t 9. El área de un cuadrado cuya longitud de lado es a lo mucho 100 unidades.");
        String cadena1 = "El area es: ";
        String cadena2 = " unidades";
        String resultado = cadena1 + +area + cadena2;
        System.out.println(resultado);
        // 10. El valor de PI.
        double pi = 3.1416;
        System.out.println("\t 7. El valor de pi\t ");
        System.out.println("\t Pi es: \t"+pi);

    }
}
