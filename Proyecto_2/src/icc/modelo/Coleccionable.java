package icc.modelo;
import icc.colors.Colors;

/**
** Clase que representa un coleccionable con título, género y artista.
** Se pueden acceder a estos datos.
**/
public class Coleccionable {
  protected String title;
  protected String gender;
  protected String artist;

  /**
  ** Construye un objeto Coleccionable con el título, género y artista especificado.
  **
  ** @param title El nombre del coleccionable.
  ** @param gender El género al que pertenece el coleccionable.
  ** @param artist El artista que participa en la elaboración del coleccionable.
  **/
  public Coleccionable(String title, String gender, String artist) {
    this.title = title;
    this.gender = gender;
    this.artist = artist;
  }

  /** Devuelve una representación de cadena del título del coleccionable.
   ** @return El título del coleccionable.
   **/
  public String getTitle() {
    return title;
  }

  /** Devuelve una representación de cadena del género del coleccionable.
   ** @return El género del coleccionable.
   **/
  public String getGender() {
    return gender;
  }

  /** Devuelve una representación de cadena del artista que participa en el coleccionable.
   ** @return El artista que intervino en el coleccionable.
   **/
  public String getArtist() {
    return artist;
  }

  /** Devuelve la representación en cadena de un objeto coleccionable con título y género.
   ** @return La representación en cadena de un objeto coleccionable.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(Colors.colorear("Título: ", Colors.WHITE));
    sb.append(title);
    sb.append("\n");
    sb.append(Colors.colorear("Género: ", Colors.WHITE));
    sb.append(gender);
    sb.append("\n");

    return sb.toString();
  }





}
