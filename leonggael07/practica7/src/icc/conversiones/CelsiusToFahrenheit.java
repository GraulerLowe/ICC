package icc.conversiones;

public class CelsiusToFahrenheit {

    public double convert(double celsius) {
        
        celsius = (celsius * 9.0 / 5.0) + 32.0;
        return celsius;
    }
}