package icc.modelo;
import icc.colors.Colors;

/**
** Representa un álbum musical título, género, artista y número de pistas.
**/
public class Album extends Coleccionable {
  private int pistas;

  /**
  ** Construye un objeto album con título, género, artista y número de pistas.
  ** @param title El título del álbum.
  ** @param gender El género del álbum.
  ** @param artista La agrupación o artista.
  ** @param pistas El número de pistas que contiene el álbum.
  **/
  public Album(String title, String gender, String artista, int pistas) {
    super(title, gender, artista);
    this.pistas = pistas;
  }

  /** Devuelve número de pistas del álbum.
  ** @return El número de pistas.
  **/
  public int getPistas() {
    return pistas;
  }

  /** Devuelve la representación en cadena de un objeto album con título, género, intéprete y número de pistas.
   ** @return la representación en cadena de un objeto album.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(Colors.colorear("intéprete: ", Colors.WHITE));
    sb.append(artist);
    sb.append("\n");
    sb.append(Colors.colorear("Número de pistas: ", Colors.WHITE));
    sb.append(pistas);
    sb.append("\n");
    return sb.toString();
  }
}
