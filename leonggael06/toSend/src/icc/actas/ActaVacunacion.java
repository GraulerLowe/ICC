package icc.actas;
import icc.colors.Colors;

public class ActaVacunacion extends Acta {

  String [] vacunas;

  public ActaVacunacion (String nombre, String fecha, String [] vacunas){
  super(nombre, fecha);
  this.vacunas = vacunas;
  }

  public String [] getVacunas() {
    return this.vacunas;
  }
  public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append(super.toString ());
      sb.append(Colors.HIGH_INTENSITY);
      sb.append("\tVacunas: ");
      sb.append(Colors.RESTORE);
       if (vacunas.length >= 1) {
         for (int i = 0; i < this.vacunas.length; i++){
           sb.append(Colors.HIGH_INTENSITY);
           sb.append(this.vacunas[i]);
           sb.append(Colors.RESTORE);
         }
       }
      return sb.toString();
  }
}
