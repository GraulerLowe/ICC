package icc.actas;
import icc.colors.Colors;

public class ActaNacimiento extends Acta {

  String ciudad;

  public ActaNacimiento (String nombre, String fecha,String ciudad){
    super (nombre, fecha);
    this.ciudad = ciudad;
  }

  public String getCiudad () {
    return this.ciudad;
  }

  public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append(super.toString());
      sb.append(Colors.HIGH_INTENSITY);
      sb.append("\tCiudad: ");
      sb.append(Colors.RESTORE);
      sb.append(this.ciudad);
      return sb.toString();
    }
}
