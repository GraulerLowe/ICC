package icc.conversiones;

public class FahrenheitToCelsius {

    public double convert(double fahrenheit) {
        
        fahrenheit = (fahrenheit - 32.0) * (5.0 / 9.0);
        return fahrenheit;
    }
}