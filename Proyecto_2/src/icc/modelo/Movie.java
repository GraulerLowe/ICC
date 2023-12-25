package icc.modelo;
import icc.colors.Colors;
/**
** Representa una película con título, género, artista y año de  filmación.
**/
public class Movie extends Coleccionable {
  private int year;

  /**
  ** Construye un objeto movie con título, género, actore principal y año de filmación.
  ** @param title El título de la película.
  ** @param gender El género de la película.
  ** @param actore El actor o la actriz estelar.
  ** @param year El año de filmación.
  **/
  public Movie(String title, String gender, String actore, int year) {
    super(title, gender, actore);
    this.year = year;
  }

  /** Devuelve el año de filmación de la película.
  ** @return El año de filmación.
  **/
  public int getYear() {
    return year;
  }

  /** Devuelve la representación en cadena de un objeto movie con título, género, actore y año de filmación.
   ** @return la representación en cadena de un objeto movie.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(Colors.colorear("Actor o actriz pricipal: ", Colors.WHITE));
    sb.append(artist);
    sb.append("\n");
    sb.append(Colors.colorear("Año de filmación: ", Colors.WHITE));
    sb.append(year);
    sb.append("\n");
    return sb.toString();
  }
}
