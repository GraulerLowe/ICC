
package icc.conversiones;

public class DecimalToDegrees {

    private int degrees;
    private int minutes;
    private double seconds;

    public void convert(double decimalDegrees) {
        // COMPLETA AQUI
        degrees = (int) decimalDegrees;
        double calcular = (decimalDegrees - degrees) * 60.0;
        minutes = (int) calcular;
        seconds = (calcular - minutes) * 60.0;
    }

    public int degrees() {
        return degrees;
    }

    public int minutes() {
        return minutes;
    }

    public double seconds() {
        return seconds;
    }
}
