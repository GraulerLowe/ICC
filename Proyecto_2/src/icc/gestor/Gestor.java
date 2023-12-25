package icc.gestor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;
import java.util.StringTokenizer;
import icc.colors.Colors;
import icc.modelo.Coleccionable;
import icc.modelo.Album;
import icc.modelo.Book;
import icc.modelo.Movie;
import icc.excepciones.RepeatedTitleException;
import icc.excepciones.IllegalSizeException;
import icc.excepciones.NoEncontrado;
import icc.files.ReaderWriter;
import icc.Prueba;


/**
** Esta clase maneja las operaciones de lectura y escritura sobre los archivos que guardan objetos de tipo Coleccionable.
**/
public class Gestor {
  public static final String ARCHIVO_PELIS = "peliculas.csv";
  public static final String ARCHIVO_LIBROS = "libros.csv";
  public static final String ARCHIVO_DISCOS = "discos.csv";

  /**
  ** Consulta e imprime todos los artículos colleccionables del tipo especificado.
  ** @param opc Entero enre 1 y 3 que especifica el tipo de artículo del que se trata; 1 si es un libro,
  ** 2 si es un disco y 3 si es una película.
  **/
  public static void consultarTodo(int opc) {
    FileReader fr = null;
    BufferedReader bf = null;
    try {
      if (opc == 1)
        fr = new FileReader("libros.csv");
      else if (opc == 2)
        fr = new FileReader("discos.csv");
      else
        fr = new FileReader("peliculas.csv");

      bf = new BufferedReader(fr);
      String cadenaLeida = bf.readLine();
      while (cadenaLeida != null) {
        String[] arr = separar(cadenaLeida);
        Coleccionable col = null;
        if (opc == 1)
          col = new Book(arr[0], arr[1], arr[2], arr[3]);
        else if (opc == 2)
          col = new Album(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
        else if (opc == 3)
          col = new Movie(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));

        System.out.println(col.toString());
        cadenaLeida = bf.readLine();
      }
    }
    catch (FileNotFoundException fnfe) {
      System.out.println(fnfe);
    }
    catch (IOException ioe) {
      System.out.println(ioe);
    }
    finally {
      try {
        bf.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }

  }


  /**
  ** Lee el archivo especificado, compara e imprime los artículos que coinciden en un
  ** campo o atributo especificado con una cadena clave.
  ** @param nombreArchivo Es el nombre del archivo sobre el que se quiere realizar la operación. Se esperan solamente las cadenas: "libros.csv", "peliculas.csv" y "discos.csv".
  ** @param search La cadena de la cuál se quieren encontrar igualdades en el campo especificado.
  ** @param cual Es el campo sobre el cuál se quieren buscar igualdades. En general, se espera 0 si se opera sobre el título del artículo, 1 si es el género, 2 si es el artista. Si se trata de un libro, 3 indica el tema; si es una película, 3 indica el año de filmación; si se trata de un disco, 3 indica el número de pistas.
  ** @throws NoEncontrado Si no hubo alguna coincidencia con la búsqueda.
  **/
  public static void leerYComparar(String nombreArchivo, String search, int cual) throws NoEncontrado {
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader(nombreArchivo));
      String cad;
      boolean encontrado = false;
      while ((cad = bf.readLine()) != null) {
        String arr[] = separar(cad);
        if (arr[cual].equals(search)) { // Compara los campos
          encontrado = true; // No se encontró
          Coleccionable art = null;
          if (nombreArchivo.equals("libros.csv"))
            art = new Book(arr[0], arr[1], arr[2], arr[3]);
          else if (nombreArchivo.equals("discos.csv"))
            art = new Album(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
          else
            art = new Movie(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
          System.out.println(art);

        }
      }
      if (!encontrado) {
        throw new NoEncontrado("No se encontró ninguna coincidencia.");
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
    catch (NoEncontrado ne) {
      throw ne;
    }
    finally {
      try {
        if (bf != null)
          bf.close();
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }
  }

  /** Imprime los objetos movie cuyo año de filmación sea igual o posterior al indicado.
  ** @param year Año de búsqueda.
  **/
  public static void filmByYear(int year) {
    BufferedReader br = null;
    boolean noHubo = true;
    try {
      br = new BufferedReader(new FileReader("peliculas.csv"));
      String cad = null;
      while ((cad = br.readLine()) != null) {
        String[] arr = separar(cad);
        if (Integer.parseInt(arr[3]) >= year) {
          System.out.println(new Movie(arr[0], arr[1], arr[2], Integer.parseInt(arr[3])));
          noHubo = false;
        }
      }
      if (noHubo) {
        throw new NoEncontrado("No se encontró ningún filme grabado en el mismo año o posterior al indicado.");
      }
    }
    catch (NoEncontrado ne) {
      Colors.println(ne.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
    catch (IOException e) {
      System.out.println(e);
    }
    finally {
      try {
        br.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }

  }

  public static void actoresChambeadores() {
    BufferedReader br = null;
    boolean noHubo = true;
    String[] nombres = null;
    try {
      nombres = new String[totalPelis()];
    }
    catch (Exception e) {
    }
    int contador = 0;
    try {
      br = new BufferedReader(new FileReader("peliculas.csv"));
      String cad = null;
      while ((cad = br.readLine()) != null) {
        String[] arr = separar(cad);
        int cuantos = 0;
        BufferedReader br2 = null;
        try {
          br2 = new BufferedReader(new FileReader("peliculas.csv"));
          String cad2 = null;
          while ((cad2 = br2.readLine()) != null) {
            String[] arr2 = separar(cad2);
            if (arr2[2].equals(arr[2])) { // Este if hace los arreglitos
              cuantos++;
            }
          }
          if (cuantos >= 2) {
            noHubo = false;
            nombres[contador] = arr[2];
            contador++;
          }
        }
        catch (IOException e) {
          System.out.println(e);
        }
        finally {
          try {
            br2.close();
          }
          catch (Exception e) {
            System.out.println(e);
          }
        }
      }
      if (noHubo) {
        throw new NoEncontrado("No se encontró ningún actor que haya aparecido en más de una película.");
      }
      else
        actores2(nombres);
    }
    catch (NoEncontrado ne) {
      Colors.println(ne.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
    catch (IOException e) {
      System.out.println(e);
    }
    finally {
      try {
        br.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }

  }

  public static void tenPlusTracks() {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(ARCHIVO_DISCOS));
      String cad = null;
      boolean noHubo = true;
      while ((cad = br.readLine()) != null) {
        String[] arr = separar(cad);
        if (Integer.parseInt(arr[3]) >= 10) { // Compara si hay más de 10 pistas.
          System.out.println(new Album(arr[0], arr[1], arr[2], Integer.parseInt(arr[3])));
          noHubo = false;
        }
      }
      if (noHubo) {
        throw new NoEncontrado("No se encontró ningún disco que tenga más de 10 pistas.");
      }
    }
    catch (NoEncontrado ne) {
      Colors.println(ne.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
    catch (Exception ioe) {
      Colors.println(ioe.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
    finally {
      try {
        br.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  private static void actores2(String[] actores) {
    for (int i = 0; i < actores.length; i++)
      if (actores[i] != null) {
        String cad = actores[i];
        Colors.print("Actriz o actor: ", Colors.YELLOW + Colors.HIGH_INTENSITY);
        System.out.println(actores[i]);
        try {
          leerYComparar("peliculas.csv", actores[i], 2);
        }
        catch (Exception e) {
          System.out.println(e.getMessage());
        }
        System.out.println();
        for (int j = 0; j < actores.length; j++)
          if (actores[j] != null && cad.equals(actores[j]))
            actores[j] = null;
      }
  }

  /**
  ** Separa una cadena delimitada por comas y devuelve un arreglo de 4 cadenas
  ** separadas.
  ** @param s La cadena a separar.
  ** @return El arreglo de longitud 4 con las cadenas separadas.
  **/
  public static String[] separar(String s) {
    StringTokenizer st = new StringTokenizer(s, ",");
    String[] cadenas = new String[4];
    cadenas[0] = st.nextToken();
    cadenas[1] = st.nextToken();
    cadenas[2] = st.nextToken();
    cadenas[3] = st.nextToken();
    return cadenas;
  }

  /**
  ** Regresa la cantidad de libros guardados. Lanza una excepción si el número de artículos
  ** es mayor a 32.
  ** @return El número de libros guardados.
  ** @throws IllegalSizeException Si la cantidad de libros es mayor a 32.**/
  public static int totalLibros() throws IllegalSizeException{
      BufferedReader br = null;
      int cuantos = 0;
      try {
        br = new BufferedReader(new FileReader("libros.csv"));
        while (br.readLine() != null)
          cuantos++;
      }
      catch (IOException ioe) {
        System.out.println(ioe);
      }
      finally {
        try {
          if (br != null)
            br.close();
        }
        catch (Exception e) {
          System.out.println(e);
        }
      }
      if (cuantos > 32)
        throw new IllegalSizeException("Se ha alcanzado el límite de libros permitido (32). Por lo que no se puede introducir otro libro.");

      return cuantos;
  }

  /**
  ** Regresa la cantidad de películas guardadas. Lanza una excepción si el número de artículos
  ** es mayor a 32.
  ** @return El número de películas guardadas.
  ** @throws IllegalSizeException Si la cantidad de películas es mayor a 32.**/
  public static int totalPelis() throws IllegalSizeException {
    int cuantos = ReaderWriter.read("peliculas.csv").length;
    if (cuantos > 32)
      throw new IllegalSizeException("Se ha alcanzado el límite de películas permitido (32). Por lo que no se puede introducir otro filme.");
    return cuantos;
  }

  /**
  ** Regresa la cantidad de discos guardados. Lanza una excepción si el número de artículos
  ** es mayor a 32.
  ** @return El número de discos guardados.
  ** @throws IllegalSizeException Si la cantidad de discos es mayor a 32.**/
  public static int totalDiscos() throws IllegalSizeException {
    int cuantos = ReaderWriter.read("discos.csv").length;
    if (cuantos > 32)
      throw new IllegalSizeException("Se ha alcanzado el límite de discos permitido (32). Por lo que no se puede introducir otro disco.");
    return cuantos;
  }

  /**
  ** Compara si ya existe el título de un libro en el archivo.
  ** @param title Es el título del cual se quiere verificar su existencia.
  ** @throws RepeatedTitleException Cuando el título está repetido.**/
  public static void librosRepetidos(String title) throws RepeatedTitleException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("libros.csv"));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] arr = separar(line);
        if (title.equals(arr[0]))
          throw new RepeatedTitleException("Se ha encontrado un libro con el mismo título que el que se quiere introducir.");
      }
    }
    catch (IOException ioe) {
      System.out.println(ioe);
    }
    finally {
      try {
        if (br != null) {
          br.close();
        }
      }
      catch (Exception e) {
        System.out.println();
      }
    }
  }

  /**
  ** Compara si ya existe el título de un disco en el archivo.
  ** @param title Es el título del cual se quiere verificar su existencia.
  ** @throws RepeatedTitleException Cuando el título está repetido.**/
  public static void discosRepetidos(String title) throws RepeatedTitleException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("discos.csv"));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] arr = separar(line);
        if (title.equals(arr[0]))
          throw new RepeatedTitleException("Se ha encontrado un disco con el mismo título que el que se quiere introducir.");
      }
    }
    catch (IOException ioe) {
      System.out.println(ioe);
    }
    finally {
      try {
        if (br != null) {
          br.close();
        }
      }
      catch (Exception e) {
        System.out.println();
      }
    }
  }

  /**
  ** Compara si ya existe el título de una película en el archivo.
  ** @param title Es el título del cual se quiere verificar su existencia.
  ** @throws RepeatedTitleException Cuando el título está repetido.**/
  public static void pelisRepetidos(String title) throws RepeatedTitleException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("peliculas.csv"));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] arr = separar(line);
        if (title.equals(arr[0]))
          throw new RepeatedTitleException("Se ha encontrado una película con el mismo título que la que se quiere introducir.");
      }
    }
    catch (IOException ioe) {
      System.out.println(ioe);
    }
    finally {
      try {
        if (br != null) {
          br.close();
        }
      }
      catch (Exception e) {
        System.out.println();
      }
    }
  }

  /**
  ** Se encarga de guardar un objeto coleccionable en su archivo corespondiente.
  ** No se inserta si en el archivo ya existe un ítem con el mismo titulo.
  ** @param art El artículo coleccionable a guardar.
  **/
  public static void instertarArt(Coleccionable art) {
    try {
      String archivo = null;
      String extra = null;
      if (art instanceof Book) {
        librosRepetidos(art.getTitle());
        archivo = ARCHIVO_LIBROS;
        Book b = (Book) art;
        extra = b.getTema();
      }
      else if (art instanceof Album) {
        discosRepetidos(art.getTitle());
        archivo = ARCHIVO_DISCOS;
        Album a = (Album) art;
        extra = Integer.toString(a.getPistas());
      }
      else {
        pelisRepetidos(art.getTitle());
        archivo = ARCHIVO_PELIS;
        Movie m = (Movie) art;
        extra = Integer.toString(m.getYear());
      }
      FileOutputStream fos = null;
      try {
        fos = new FileOutputStream(new File(archivo), true);
        StringBuilder sb = new StringBuilder();
        sb.append(art.getTitle());
        sb.append(",");
        sb.append(art.getGender());
        sb.append(",");
        sb.append(art.getArtist());
        sb.append(",");
        sb.append(extra);
        fos.write(sb.toString().getBytes());
        fos.write('\n');
        Colors.println("¡El artículo se agregó a la colección existosamente!\n", Colors.GREEN + Colors.HIGH_INTENSITY);
      }
      catch (IOException ioe) {
        System.out.println(ioe.getMessage());
      }
      finally {
        try {
          if (fos != null) {
            fos.close();
          }
        }
        catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
    catch (Exception e) {
      Colors.println(e.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
  }
  /**
  ** Se encarga de guardar un objeto de peliculas en su archivo corespondiente.
  ** No se inserta si en el archivo ya existe un ítem con el mismo titulo.
  **
  **/
  public static void insertaPelis () {
    Scanner teclitas = new Scanner (System.in);
    try {
      Gestor.totalPelis(); // Verifica primero si hay espacio para añadir uno más.
      System.out.println("Ingrese el título de la película.");
      String title = teclitas.nextLine();
      System.out.println("Ingrese el género de la película.");
      String gen = teclitas.nextLine();
      System.out.println("Ingrese el actor o la actriz principal del filme.");
      String actore = teclitas.nextLine();
      System.out.println("Ingrese el año de filmación.");
      int year = Prueba.getInt("Ingrese el año de filmación.", "Por favor, ingrese un número entero (año) mayor a 1888", 1888, Integer.MAX_VALUE);

      Gestor.instertarArt(new Movie(title, gen, actore, year));
    }
    catch (IllegalSizeException ise) {
      Colors.println(ise.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
  }
  /**
  ** Se encarga de guardar un objeto de discos en su archivo corespondiente.
  ** No se inserta si en el archivo ya existe un ítem con el mismo titulo.
  **
  **/
  public static void insertaDiscos (){
    Scanner teclitas = new Scanner (System.in);
    try {
      Gestor.totalDiscos(); // Verifica primero si hay espacio para añadir uno más.
      System.out.println("Ingrese el título del disco.");
      String title = teclitas.nextLine();
      System.out.println("Ingrese el género del disco.");
      String gen = teclitas.nextLine();
      System.out.println("Ingrese nombre de la banda o artista.");
      String artist = teclitas.nextLine();
      System.out.println("Ingrese el número de pistas.");
      int pistas = teclitas.nextInt();
       if (pistas < 1){
        System.out.println("Por favor, ingrese un número mayor o igual a 1.");
       }
      Gestor.instertarArt(new Album(title, gen, artist, pistas));
    }
    catch (IllegalSizeException ise) {
      Colors.println(ise.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
  }
  /**
  ** Se encarga de guardar un objeto de libros en su archivo corespondiente.
  ** No se inserta si en el archivo ya existe un ítem con el mismo titulo.
  **
  **/
  public static void insertaLibros (){
    Scanner teclitas = new Scanner (System.in);
    try {
      Gestor.totalLibros(); // Verifica primero si hay espacio para añadir uno más.
      System.out.println("Ingrese el título del libro.");
      String title = teclitas.nextLine();
      System.out.println("Ingrese el género del libro.");
      String gen = teclitas.nextLine();
      System.out.println("Ingrese el autor del libro.");
      String autor = teclitas.nextLine();
      System.out.println("Ingrese el tema del libro.");
      String tema = teclitas.nextLine();
      Gestor.instertarArt(new Book(title, gen, autor, tema));
    }
    catch (IllegalSizeException ise) {
      Colors.println(ise.getMessage(), Colors.RED + Colors.HIGH_INTENSITY);
    }
  }
}
