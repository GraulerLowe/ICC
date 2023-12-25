package icc.actas;
import icc.colors.Colors;

public class ActaMatrimonio extends Acta {

  String conyuge;
  String ciudad;

  public ActaMatrimonio (String nombre, String fecha, String conyuge, String ciudad){
    super (nombre, fecha);
    this.conyuge = conyuge;
    this.ciudad = ciudad;
  }
  public String getConyuge () {
    return this.conyuge;
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
      sb.append(Colors.HIGH_INTENSITY);
      sb.append("\tConyuge: ");
      sb.append(Colors.RESTORE);
      sb.append(this.conyuge);
      return sb.toString();
    }
}
