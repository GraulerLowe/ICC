package icc.actas;


import icc.colors.Colors;
public class Acta {

  String nombre;
  String fecha;

  public Acta(String nombre, String fecha){
    this.nombre = nombre;
    this.fecha = fecha;
  }
  public String getNombre() {
    return this.nombre;
  }
  public String getFecha () {
    return this.fecha;
  }
  public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append(Colors.HIGH_INTENSITY);
      sb.append("\tNombre: ");
      sb.append(Colors.RESTORE);
      sb.append(this.nombre);
      sb.append(Colors.HIGH_INTENSITY);
      sb.append("\tFecha: ");
      sb.append(Colors.RESTORE);
      sb.append(this.fecha);
      return sb.toString();
  }
}
