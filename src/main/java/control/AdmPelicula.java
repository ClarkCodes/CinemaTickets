package control;
// Imports
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pelicula;
import model.Funcion;
import model.CommonlyUsedObjects;

/** Movie Mamagement Class, hosts tasks and important things related to it
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class AdmPelicula
{   // Atributos - Attributes - Fields
    private static AdmPelicula adm = null; // Instancia Singleton única de la Clase - Unique Singleton Instance of the Class, Singleton Pattern Static Object, declared yet not initialized
    private CommonlyUsedObjects common = null;
    private HashMap<String, Pelicula> peliculas = null; // HashMap Main Colection for Movies where these are stored as objects / Colección HashMap Principal donde estarán almacenados los registros primordiales como objetos, en este caso de Peliculas
    private HashMap<String, String> nombresPeliculas = null; // HashMap Helper auxiliar con los campos invertidos, tiene el nombre de película como Key para así poder obtener rápidamente la Key correcta y poder obtener el objeto en películas / Movies Class HashMap Secondary Helper with inverted Key-Value from the main HashMap <code>peliculas</code>, it has movie name as key and movie code as value, this way the search for a movie can be made with the name of that movie (from a ComboBox selected by a user) and with its key obtained as value a new search can be made on main HashMap for a quick movie get
    
    // Listas ArrayList auxiliares para llenar Combos
    private ArrayList<String> sortedMoviesListForCombo = null; // Lista ordenada para ponerla en el ComboBox de Películas
    private ArrayList<String> sortedMoviesGenresListForCombo = null; // Lista ordenada de Generos de Peliculas para ponerla en el ComboBox de Generos de Pelicula
    private ArrayList<String> sortedMoviesLanguagesListForCombo = null; // Lista ordenada de Idiomas de Peliculas para ponerla en el ComboBox de Idiomas de Peliculas
    
    /** Sole Constructor which loads the {@code AdmPelicula} unique instance following Singleton Design Pattern */
    private AdmPelicula() // Constructor por defecto puesto como privado, el cuál inicializa la colección HashMap
    {
        this.peliculas = new HashMap<>();
        this.nombresPeliculas = new HashMap<>();
        this.sortedMoviesListForCombo = new ArrayList<>();
        this.sortedMoviesGenresListForCombo = new ArrayList<>();
        this.sortedMoviesLanguagesListForCombo = new ArrayList<>();
        this.common = CommonlyUsedObjects.getAdm();
        initMovies();
    }
    
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code AdmPelicula} instance
     */
    public static AdmPelicula getAdm() // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre
        if(adm == null)
            adm = new AdmPelicula();
        return adm;
    }
    
    /** Initializes and sorts 10 predefined movies for stored mode, also its genres and languages collections for searches purposes */
    private void initMovies()
    {   
        Pelicula tempMovie = new Pelicula("M-001", "Free Guy", "Comedia", "Inglés", true, "Español", Duration.ofMinutes(120), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("12:45:00.00"), horarioSetter("15:00:00.00"), horarioSetter("18:00:00.00"), horarioSetter("20:15:00.00"), horarioSetter("22:30:00.00"))), LocalDate.parse("26/08/2021", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-002", "Spider-Man No Way Home", "Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(150),  horariosLister(Arrays.asList(horarioSetter("11:20:00.00"), horarioSetter("14:10:00.00"), horarioSetter("17:00:00.00"), horarioSetter("19:45:00.00"), horarioSetter("22:30:00.00"))), LocalDate.parse("15/12/2021", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-003", "Avengers End Game", "Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(180), horariosLister(Arrays.asList(horarioSetter("09:00:00.00"), horarioSetter("12:45:00.00"), horarioSetter("17:30:00.00"), horarioSetter("21:00:00.00"))), LocalDate.parse("22/04/2019", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-004", "Dr. Strange Multiverse of Madness", "Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(130), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("13:00:00.00"), horarioSetter("15:40:00.00"), horarioSetter("18:30:00.00"), horarioSetter("21:30:00.00"))), LocalDate.parse("23/03/2022", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-005", "Terminator", "Acción", "Español", false, "N/A", Duration.ofMinutes(110), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("12:45:00.00"))), LocalDate.parse("26/10/1984", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-006", "Ready Player One", "Gaming Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(140), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("12:45:00.00"), horarioSetter("15:20:00.00"), horarioSetter("18:30:00.00"))), LocalDate.parse("11/03/2018", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-007", "The Edge of Tomorrow", "Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(145), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("12:45:00.00"), horarioSetter("15:20:00.00"), horarioSetter("18:30:00.00"))), LocalDate.parse("28/05/2014", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-008", "Justice League - Snyder Cut", "Hero Sci-Fi", "Inglés", true, "Español", Duration.ofMinutes(245), horariosLister(Arrays.asList(horarioSetter("11:20:00.00"), horarioSetter("15:40:00.00"), horarioSetter("20:00:00.00"))), LocalDate.parse("18/03/2021", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-009", "Deadpool 2", "Comedia", "Español", false, "N/A", Duration.ofMinutes(120), horariosLister(Arrays.asList(horarioSetter("16:20:00.00"), horarioSetter("18:40:00.00"), horarioSetter("21:00:00.00"))), LocalDate.parse("1/05/2018", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        tempMovie = new Pelicula("M-010", "Guardians of the Galaxy Volume 3", "Comedia", "Español", false, "N/A", Duration.ofMinutes(130), horariosLister(Arrays.asList(horarioSetter("10:30:00.00"), horarioSetter("14:00:00.00"), horarioSetter("16:30:00.00"), horarioSetter("19:00:00.00"))), LocalDate.parse("5/05/2023", CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
        peliculas.put(tempMovie.getId(), tempMovie);
        
        for(Map.Entry p : peliculas.entrySet())
        {
            Pelicula pelicula = ((Pelicula)p.getValue());
            nombresPeliculas.put(pelicula.getNombre(), (String)p.getKey());
            sortedMoviesListForCombo.add(pelicula.getNombre());
            
            if(!sortedMoviesGenresListForCombo.contains((String)pelicula.getGenero())) // Solo Si no lo contiene lo añade
            {
                sortedMoviesGenresListForCombo.add(pelicula.getGenero());
            }
            
            if(!sortedMoviesLanguagesListForCombo.contains((String)pelicula.getIdioma()))
            {
                sortedMoviesLanguagesListForCombo.add(pelicula.getIdioma());
            }
        }
        // Ordenamiento de listas para ponerlas en Combos (Sorting)
        Collections.sort(sortedMoviesListForCombo);
        Collections.sort(sortedMoviesGenresListForCombo);
        Collections.sort(sortedMoviesLanguagesListForCombo);
    }
    
    /** Parses a valid {@code String} to a {@code LocalTime} object
     * @param hora The valid {@code String} representation of an hour in format hh:mm
     * @return A {@code LocalTime} object representation of the hour received as parameter
     */
    private LocalTime horarioSetter(String hora)
    {   // Método que convierte la cadena recibida en una hora tipo LocalTime
        return LocalTime.parse(hora);
    }
    
    /** Transforms a {@code List<LocalTime>} object into an {@code ArrayList<LocalTime>} collection.
     * <p>
     * Esentially creates a new {@code ArrayList<LocalTime>} and adds all items in the given 
     * {@code List<LocalTime>} to it
     * @param horarios The given {@code List<LocalTime>} object
     * @return An {@code ArrayList<LocalTime>} object with all items in the given {@code List<LocalTime>} object
     */
    private ArrayList<LocalTime> horariosLister(List<LocalTime> horarios)
    {   // Recibe una lista de elementos LocalTime, y devuelve un nuevo ArrayList<LocalTime> con ellos, la lista puede variar su tamaño cada vez que se llama a este método.
        ArrayList<LocalTime> listaHorarios = new ArrayList<>();
        listaHorarios.addAll(horarios);
        return listaHorarios;
    }

    /** Fills a given {@code JComboBox} object with the sorted predefined movies list used in stored mode
     * @param combito The given {@code JComboBox} object to be filled
     */
    public void llenarComboPeliculas(JComboBox combito)
    {   //np: Nombre Pelicula
        sortedMoviesListForCombo.forEach(np -> { combito.addItem(np); });
    }
    
    /** Fills a given {@code JComboBox} object with the sorted predefined movies genres list used in stored mode
     * @param combitoGeneros The given {@code JComboBox} object to be filled
     */
    public void llenarComboGenerosPeliculas(JComboBox combitoGeneros)
    {   //gp: Generos Peliculas
        sortedMoviesGenresListForCombo.forEach(gp -> { combitoGeneros.addItem(gp); });
    }
    
    /** Fills a given {@code JComboBox} object with the sorted predefined movies languages list used in stored mode
     * @param combitoIdiomas The given {@code JComboBox} object to be filled
     */
    public void llenarComboIdiomasPeliculas(JComboBox combitoIdiomas)
    {   //ip: Idiomas Peliculas
        sortedMoviesLanguagesListForCombo.forEach(ip -> { combitoIdiomas.addItem(ip); });
    }
    
    /** Populates a given {@code JTable} object with the respective movie data indicated with a given key 
     * and centers that information in the table
     * @param key The given {@code String} that indicates the key to get the movie from the movies main HashMap
     * @param tablaPelicula The given {@code JTable} object to be populated
     * @param horariosDisponibles A third object, a {@code JComboBox} to be filled with the schedules asociated 
     * to the movie specificated for which the method in charge on this task is called
     * @see model.CommonlyUsedObjects
     */
    public void llenarTablaPeliculaElegida(String key, JTable tablaPelicula, JComboBox horariosDisponibles)
    {   // Aquí también se llena el Combo Horarios Disponibles
        DefaultTableModel modelTP = (DefaultTableModel) tablaPelicula.getModel();
        
        if(tablaPelicula.getRowCount() == 0)
        {
            modelTP.addRow(new Object[1]);
            common.centerTableColumns(tablaPelicula);
        }
        
        tablaPelicula.setValueAt(((Pelicula)peliculas.get(key)).getId(), 0, 0);
        tablaPelicula.setValueAt(((Pelicula)peliculas.get(key)).getGenero(), 0, 1);
        tablaPelicula.setValueAt(((Pelicula)peliculas.get(key)).getIdioma(), 0, 2);
        tablaPelicula.setValueAt(((Pelicula)peliculas.get(key)).isTieneSubtitulos() ? ((Pelicula)peliculas.get(key)).getIdiomaSubtitulos() : "N/A", 0, 3);
        tablaPelicula.setValueAt(((Pelicula)peliculas.get(key)).obtenerDuracionFormateada(), 0, 4);
        
        llenarComboHorariosDisponibles(key, horariosDisponibles);
    }
    
    /** Populates a given {@code JComboBox} object with the schedules asociated to the movie specificated 
     * in a given {@code String} key
     * @param key The given {@code String} that indicates the key to get the movie from the movies main HashMap
     * @param combito The given {@code JComboBox} object to be populated
     * @see model.CommonlyUsedObjects
     */
    public void llenarComboHorariosDisponibles(String key, JComboBox combito)
    {
        if(combito.getItemCount() > 0)
            combito.removeAllItems();
        
        ((Pelicula)peliculas.get(key)).getHorariosDisponibles().forEach(hd ->
        {   //hd Horarios Disponibles
            combito.addItem(hd.format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos)));
        });
    }
    
    /** Gets a existing {@code Pelicula} object which represents a movie from the main movies HashMap 
     * located with a given {@code String} as the movie name for which uses a helper collection 
     * to get the key of that movie and with it gets the movie object from the main movies HashMap collection
     * @param nombrePelicula The specified {@code String} movie name
     * @return The {@code Pelicula} object specified by its name from the main movies HashMap collection
     * @see model.Pelicula
     */
    public Pelicula obtenerPelicula(String nombrePelicula)
    {   
        return peliculas.get((String)nombresPeliculas.get(nombrePelicula));
    }
    
    /** Gets a new {@code Funcion} object with a given hour and name both as {@code String}, which 
     * represents a movie function.
     * <p>
     * In order to achieve this, it parses the given hour to a LocalTime object, gets the respective movie 
     * object from movies main HashMap collection using the given movie name and calculates the days between 
     * this movie's release date and today. Then it validates if this time calculated is lesser than 7 days,
     * if so, it is a new release movie, else, it is an already realeased movie ans considered habitual.
     * So knowing if it is a new release or not, the movie function id which is needed can be set.
     * <p>
     * The function's id has to have the following structure:
     * <p>
     * F-movieId-nowDate-choosedScheduleHour-choosedScheduleMinute
     * <p>
     * The movie function id starts with a F precisely for being related to the word 'function', 
     * the movie id has the format "M-001", the now date has the format "yyMMdd", the hours has the format "h" 
     * and the minutes has the format "m" (if hour = 9 and minutes = 0, it means it is scheduled for 9:00 AM, and so on).
     * <p>
     * An example of this id would be as follows:
     * <p>
     * F-M-003-21110690
     * 
     * @param hora The specified {@code String} hour in format hh:mm
     * @param nombrePelicula The specified {@code String} movie name 
     * @return A new {@code Funcion} object that corresponds with the specified given parameters
     * @see model.Funcion model.CommonlyUsedObjects
     */
    public Funcion obtenerFuncion(String hora, String nombrePelicula)
    {
        boolean estreno = false;
        
        Pelicula pelicula = obtenerPelicula(nombrePelicula);
        LocalTime horarioElegido = LocalTime.parse(hora);
        Period tiempoEstrenada = Period.between(pelicula.getFechaEstreno(), LocalDate.now());
        
        if(tiempoEstrenada.getDays() <= 7)
            estreno = true;
        
        String codigoFuncion = "F-" + pelicula.getId() + "-" + LocalDate.now().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCompacta)) + horarioElegido.getHour() + horarioElegido.getMinute(); 
        
        return new Funcion(codigoFuncion,"", horarioElegido, estreno);
    }
}
