package icc.modelo;
import icc.colors.Colors;
/**
** Representa un libro con título, género, artista y tema.
**/
public class Book extends Coleccionable {
  private String tema;

  /**
  ** Construye un objeto book con título, género, escritor y tema.
  ** @param title El título del libro.
  ** @param gender El género del libro.
  ** @param escritor El escritor del libro.
  ** @param tema El tema de la publicación.
  **/
  public Book(String title, String gender, String escritor, String tema) {
    super(title, gender, escritor);
    this.tema = tema;

  }

  /** Devuelve el tema del libro.
  ** @return El tema del libro.
  **/
  public String getTema() {
    return tema;
  }

  /** Devuelve la representación en cadena de un objeto book con título, género, autor y tema.
   ** @return la representación en cadena de un objeto book.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(Colors.colorear("Autor: ", Colors.WHITE));
    sb.append(artist);
    sb.append("\n");
    sb.append(Colors.colorear("Tema: ", Colors.WHITE));
    sb.append(tema);
    sb.append("\n");
    return sb.toString();
  }

}
