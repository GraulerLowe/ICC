
package icc;

import icc.colors.Colors;
import icc.arreglos.Vector;

public class Prueba {

    public static void main(String args[]) {
        Vector v[], x, y, z;
        double m_x, m_y, m_z;
        double[] m;
        int index = args.length;
        String s[];

        v = new Vector[index];

        for (int i = 0; i < index; i++) {
            s = args[i].split(",");
            m = new double[s.length];
            for (int j = 0; j < s.length; j++) {
                m[j] = Double.valueOf(s[j]);
            }
            v[i] = new Vector(m);
        }

        for (int i = 0; i < index - 1; i++) {
            x = v[i];
            y = v[i + 1];
            z = new Vector(x);
            z.add(1, y);

            System.out.println("Indexes: " + (i) + ", " + (i + 1));

            System.out.println("X: " + x + ", order: "+ x.order() + ", first NonZero: "+ x.getFirstNonZero());

            System.out.println("Y: " + y + ", order: "+ y.order() + ", first NonZero: "+ y.getFirstNonZero());

            System.out.println("Z: " + z + ", order: "+ z.order() + ", first NonZero: "+ z.getFirstNonZero());

            m_x = x.magnitude();
            m_y = y.magnitude();
            m_z = z.magnitude();

            System.out.println(m_x + "^2 + " + m_y + "^2 = " + m_z + "^2");

            m_x *= m_x;
            m_y *= m_y;
            m_z *= m_z;

            System.out.println(m_x + " + " + m_y + " = " + m_z);
            System.out.println();
        }
    }
}
