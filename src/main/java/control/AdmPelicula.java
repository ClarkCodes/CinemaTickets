
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import model.Commons;
import model.Funcion;
import model.Pelicula;

/** Movie Mamagement Class, hosts tasks and important things related to it
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class AdmPelicula
{   // Atributos - Attributes - Fields
    private static AdmPelicula adm = null; // Instancia Singleton única de la Clase - Unique Singleton Instance of the Class, Singleton Pattern Static Object, declared yet not initialized
    private Commons common = null;
    private HashMap<String, Pelicula> peliculas = null; // HashMap Main Colection for Movies where these are stored as objects / Colección HashMap Principal donde estarán almacenados los registros primordiales como objetos, en este caso de Peliculas
    private HashMap<String, String> nombresPeliculas = null; // HashMap Helper auxiliar con los campos invertidos, tiene el nombre de película como Key para así poder obtener rápidamente la Key correcta y poder obtener el objeto en películas / Movies Class HashMap Secondary Helper with inverted Key-Value from the main HashMap <code>peliculas</code>, it has movie name as key and movie code as value, this way the search for a movie can be made with the name of that movie (from a ComboBox selected by a user) and with its key obtained as value a new search can be made on main HashMap for a quick movie get
    private Pelicula tempMovie = null;
    
    // Listas LinkedList auxiliares para posteriorment llenar Combos designados a estos aspectos
    private LinkedList<String> sortedMoviesListForCombo = null; // Lista ordenada para ponerla en el ComboBox de Películas
    private LinkedList<String> sortedMoviesLanguagesListForCombo = null; // Lista ordenada de Idiomas de Peliculas para ponerla en el ComboBox de Idiomas de Peliculas
    private LinkedList<String> sortedMoviesSubsListForCombo = null;

    /** Enum helper to handle movie genres
     * @since 1.6
     * @see model.Pelicula
     */
    public enum MovieGenres
    {
        Comedy( "lk_movie_genre_comedy" ),
        Sci_Fi( "lk_movie_genre_scifi" ),
        Action( "lk_movie_genre_action" ),
        Gaming_Sci_Fi( "lk_movie_genre_gaming_scifi" ),
        Super_Hero_Sci_Fi( "lk_movie_genre_superhero_scifi" ),
        Horror_Terror( "lk_movie_genre_horror_terror" ),
        Drama( "lk_movie_genre_drama" );
        
        private final String lk_key;
        
        MovieGenres ( String lk_key )
        {
            this.lk_key = lk_key;
        }
        
        /** Gets the corresponding {@code String} language key asociated to its
         * corresponding {@code enum} constant
         * 
         * @return The asociated {@code String} language key
         * @since 1.6
         */
        public String getLangKey()
        {
            return lk_key;
        }
        
        /** Parses a {@code String} language key to its corresponding 
         * {@code MovieGenres} enum constant
         * @param langKey A specified {@code String MovieGenres} language key 
         *                available in the application
         * @return        The corresponding {@code MovieGenres} enum constant
         * @since 1.6
         * @see control.AdmTicket
         */
        public static MovieGenres valueOfLangKey( String langKey )
        {
            MovieGenres resultGenre = null;

            for ( MovieGenres genre : MovieGenres.values() )
            {
                if ( langKey.equalsIgnoreCase( genre.getLangKey() ) )
                {
                    resultGenre = genre;
                    break;
                }
            }

            return resultGenre;
        }
        
        /** Parses a {@code String} to its corresponding {@code MovieGenres}
         * enum constant
         * @param str A specified {@code String} that contains a 
         *            {@code MovieGenres} shown text format of any available 
         *            language in the application
         * @return    The corresponding {@code MovieGenres} enum constant
         * @since 1.6
         * @see control.AdmTicket
         */
        public static MovieGenres valueOfLocalizedString ( String str )
        {
            MovieGenres result = null;
            
            for ( MovieGenres c : values() )
            {
                if ( str.equalsIgnoreCase( AdmSettings.getLanguageBundle().getString( c.getLangKey() ) ) )
                {
                    result = c;
                    break;
                }
            }
            
            return result;
        }
    }

    
    /** Sole Constructor which loads the {@code AdmPelicula} unique instance
     * following Singleton Design Pattern */
    private AdmPelicula () // Constructor por defecto puesto como privado, el cuál inicializa la colección HashMap
    {
        this.peliculas = new HashMap<>();
        this.nombresPeliculas = new HashMap<>();
        this.sortedMoviesListForCombo = new LinkedList<>();
        this.sortedMoviesLanguagesListForCombo = new LinkedList<>();
        this.sortedMoviesSubsListForCombo = new LinkedList<>();
        this.common = Commons.getAdm();
        initMovies();
    }

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code AdmPelicula} instance
     */
    public static AdmPelicula getAdm () // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre
        if ( adm == null )
            adm = new AdmPelicula();
        return adm;
    }
    
    /** Registers a new movie using the {@code Pelicula} helper object setting 
     * its attributes with the received ones
     * 
     * @param id                  A {@code String} with this movie's id code
     * @param nombre              A {@code String} with this movie's name
     * @param genero              A {@code String} with this movie's genre
     * @param idioma              A {@code String} with this movie's language
     * @param tieneSubtitulos     A {@code boolean} that indicates wheter this 
     *                            movie has subtitles or not
     * @param idiomaSubtitulos    A {@code String} with this movie's subtitles
     *                            language
     * @param duracion            A {@code Duration} object with this movie's 
     *                            duration as a time representation
     * @param horariosDisponibles A {@code ArrayList<LocalTime>} list collection
     *                            with the Showtimes available for this movie
     * @param fechaEstreno        A {@code LocalDate} object with this movie's 
     *                            premiere date as a date representation
     * 
     * @since 1.6
     * @see model.Pelicula
     */
    private void registerMovie( String id, 
            String nombre, 
            MovieGenres genero, 
            String idioma, 
            boolean tieneSubtitulos, 
            String idiomaSubtitulos, 
            Duration duracion, 
            ArrayList<LocalTime> horariosDisponibles, 
            LocalDate fechaEstreno )
    {
        tempMovie = new Pelicula(id, nombre, genero, idioma, tieneSubtitulos, idiomaSubtitulos, duracion, horariosDisponibles, fechaEstreno );
    }

    /** Initializes and sorts 10 predefined movies for stored mode, also its
     * genres and languages collections for searching purposes
     * @see model.Pelicula
     */
    private void initMovies ()
    {
        registerMovie( "M-001", "Free Guy", MovieGenres.Comedy, "English", true, "Español", Duration.ofMinutes( 120 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "12:45:00.00" ), horarioSetter( "15:00:00.00" ), horarioSetter( "18:00:00.00" ), horarioSetter( "20:15:00.00" ), horarioSetter( "22:30:00.00" ) ) ), LocalDate.parse("26/08/2021", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-002", "Spider-Man No Way Home", MovieGenres.Super_Hero_Sci_Fi, "English", true, "Español", Duration.ofMinutes( 150 ), horariosLister( Arrays.asList( horarioSetter( "11:20:00.00" ), horarioSetter( "14:10:00.00" ), horarioSetter( "17:00:00.00" ), horarioSetter( "19:45:00.00" ), horarioSetter( "22:30:00.00" ) ) ), LocalDate.parse("15/12/2021", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-003", "Avengers End Game", MovieGenres.Super_Hero_Sci_Fi, "English", true, "Español", Duration.ofMinutes( 180 ), horariosLister( Arrays.asList( horarioSetter( "09:00:00.00" ), horarioSetter( "12:45:00.00" ), horarioSetter( "17:30:00.00" ), horarioSetter( "21:00:00.00" ) ) ), LocalDate.parse("22/04/2019", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-004", "Dr. Strange Multiverse of Madness", MovieGenres.Super_Hero_Sci_Fi, "English", true, "Español", Duration.ofMinutes( 130 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "13:00:00.00" ), horarioSetter( "15:40:00.00" ), horarioSetter( "18:30:00.00" ), horarioSetter( "21:30:00.00" ) ) ), LocalDate.parse("23/03/2022", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-005", "Terminator", MovieGenres.Action, "English", false, "N/A", Duration.ofMinutes( 110 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "12:45:00.00" ) ) ), LocalDate.parse("26/10/1984", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-006", "Ready Player One", MovieGenres.Gaming_Sci_Fi, "English", true, "Español", Duration.ofMinutes( 140 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "12:45:00.00" ), horarioSetter( "15:20:00.00" ), horarioSetter( "18:30:00.00" ) ) ), LocalDate.parse("11/03/2018", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-007", "The Edge of Tomorrow", MovieGenres.Sci_Fi, "English", true, "Español", Duration.ofMinutes( 145 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "12:45:00.00" ), horarioSetter( "15:20:00.00" ), horarioSetter( "18:30:00.00" ) ) ), LocalDate.parse("28/05/2014", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-008", "Justice League - Snyder Cut", MovieGenres.Super_Hero_Sci_Fi, "English", true, "Español", Duration.ofMinutes( 245 ), horariosLister( Arrays.asList( horarioSetter( "11:20:00.00" ), horarioSetter( "15:40:00.00" ), horarioSetter( "20:00:00.00" ) ) ), LocalDate.parse("18/03/2021", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-009", "Deadpool 2", MovieGenres.Comedy, "Español", false, "N/A", Duration.ofMinutes( 120 ), horariosLister( Arrays.asList( horarioSetter( "16:20:00.00" ), horarioSetter( "18:40:00.00" ), horarioSetter( "21:00:00.00" ) ) ), LocalDate.parse("1/05/2018", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );
        registerMovie( "M-010", "Guardians of the Galaxy Volume 3", MovieGenres.Super_Hero_Sci_Fi, "Español", false, "N/A", Duration.ofMinutes( 130 ), horariosLister( Arrays.asList( horarioSetter( "10:30:00.00" ), horarioSetter( "14:00:00.00" ), horarioSetter( "16:30:00.00" ), horarioSetter( "19:00:00.00" ) ) ), LocalDate.parse("5/05/2023", Commons.getParsingDateFormatter() ) );
        peliculas.put( tempMovie.getId(), tempMovie );

        peliculas.forEach( ( movieKey, movie ) -> 
        {
            nombresPeliculas.put( movie.getNombre(), movieKey );
            sortedMoviesListForCombo.add( movie.getNombre() );

            if ( !sortedMoviesLanguagesListForCombo.contains( movie.getIdioma() ) )
                sortedMoviesLanguagesListForCombo.add( movie.getIdioma() );

            if ( !sortedMoviesSubsListForCombo.contains( movie.getIdiomaSubtitulos() ) )
                sortedMoviesSubsListForCombo.add( movie.getIdiomaSubtitulos() );
        } );

        // Ordenamiento de listas para ponerlas en Combos (Sorting)
        Collections.sort( sortedMoviesListForCombo );
        Collections.sort( sortedMoviesLanguagesListForCombo );
        Collections.sort( sortedMoviesSubsListForCombo );
    }

    /** Parses a valid {@code String} to a {@code LocalTime} object
     *
     * @param time A {@code String} representation of hours and minutes, to be 
     *             a valid {@code String} it must have the format hh:mm
     *
     * @return A {@code LocalTime} object representation of the time received as
     *         parameter
     */
    private LocalTime horarioSetter ( String time )
    {   // Método que convierte la cadena recibida en una hora tipo LocalTime
        return LocalTime.parse( time );
    }

    /** Transforms a {@code List<LocalTime>} object into an
     * {@code ArrayList<LocalTime>} collection.
     * 
     * @param horarios The given {@code List<LocalTime>} object
     *
     * @return An {@code ArrayList<LocalTime>} object with all items in the
     *         given horarios list object
     */
    private ArrayList<LocalTime> horariosLister ( List<LocalTime> horarios )
    {   // Recibe una lista de elementos LocalTime, y devuelve un nuevo ArrayList<LocalTime> con ellos, la lista puede variar su tamaño cada vez que se llama a este método.
        ArrayList<LocalTime> listaHorarios = new ArrayList<>();
        listaHorarios.addAll( horarios );
        return listaHorarios;
    }

    /** Fills a given {@code JComboBox} object with the sorted predefined movies
     * list used in stored mode
     *
     * @param comboMovies The given {@code JComboBox} object to be filled
     * 
     * @param mode        The Specified {@code WindowMode} parameter to know if
     *                    it is in the search window, if so, the word All is 
     *                    inserted as the first element, otherwise this word is 
     *                    ommited
     * 
     * @see model.Commons
     */
    public void llenarComboPeliculas ( JComboBox comboMovies, Commons.WindowMode mode )
    {   //np: Nombre Pelicula
        if ( mode.equals( Commons.WindowMode.Busqueda ) )
            comboMovies.addItem( AdmSettings.getLanguageBundle().getString("lk_search_all_fem") );

        sortedMoviesListForCombo.forEach( np -> comboMovies.addItem( np ) );
    }

    /** Fills a given {@code JComboBox} object with the sorted predefined movies
     * genres list used as searching criterias
     *
     * @param comboGenerosPeliculas The given {@code JComboBox} object to be 
     *                              filled with movie genres
     */
    public void llenarComboGenerosPeliculas ( JComboBox comboGenerosPeliculas )
    {   //g: Generos Peliculas
        comboGenerosPeliculas.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_all" ) );
        LinkedList<String> genres = new LinkedList<>();
        ArrayList<String> genresForCombo = new ArrayList<>();
        
        for ( MovieGenres g : MovieGenres.values() )
            genres.add( AdmSettings.getLanguageBundle().getString( g.getLangKey() ) );
        
        Collections.sort( genres );
        genresForCombo.addAll( genres );
        
        genresForCombo.forEach( g -> comboGenerosPeliculas.addItem( g ) );
    }

    /** Fills a given {@code JComboBox} object with the sorted predefined movies
     * languages list
     *
     * @param comboIdiomas The given {@code JComboBox} object to be filled
     */
    public void llenarComboIdiomasPeliculas ( JComboBox comboIdiomas )
    {   //ip: Idiomas Peliculas
        comboIdiomas.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_all" ) );
        sortedMoviesLanguagesListForCombo.forEach( ip -> comboIdiomas.addItem( ip ) );
    }

    /** Fills a given {@code JComboBox} object with the sorted predefined movies
     * subtitles languages list
     *
     * @param combitoSubtitulos The given {@code JComboBox} object to be filled
     * @since 1.6
     */
    public void llenarComboSubtitulosPeliculas ( JComboBox combitoSubtitulos )
    {   //sub: Subtitulo de las Peliculas
        combitoSubtitulos.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_all" ) );
        sortedMoviesSubsListForCombo.forEach( sub -> combitoSubtitulos.addItem( sub ) );
    }

    /** Populates a given {@code JTable} object with the respective movie data
     * indicated with a given key and centers the information in the table
     *
     * @param key                 The given {@code String} that contains the
     *                            key to get the movie from the movies main
     *                            collection
     * @param tablaPelicula       The given {@code JTable} object to be
     *                            populated
     * @param horariosDisponibles A {@code JComboBox} object to be filled with 
     *                            the showtimes associated to the movie 
     *                            specified
     *
     * @see model.Commons
     */
    public void llenarTablaPeliculaElegida ( String key, JTable tablaPelicula, JComboBox horariosDisponibles )
    {   // Aquí también se llena el Combo Horarios Disponibles
        DefaultTableModel modelTP = ( DefaultTableModel ) tablaPelicula.getModel();

        if ( tablaPelicula.getRowCount() == 0 )
        {
            modelTP.addRow( new Object[1] );
            common.centerTableColumns( tablaPelicula );
            
            DefaultTableColumnModel columnModelTP = ( DefaultTableColumnModel ) tablaPelicula.getColumnModel();
            columnModelTP.getColumn( 0 ).setPreferredWidth( 100 );
            columnModelTP.getColumn( 1 ).setPreferredWidth( 310 );
            columnModelTP.getColumn( 2 ).setPreferredWidth( 120 );
            columnModelTP.getColumn( 3 ).setPreferredWidth( 120 );
            columnModelTP.getColumn( 3 ).setPreferredWidth( 120 );
        }

        tablaPelicula.setValueAt( peliculas.get( key ).getId(), 0, 0 );
        tablaPelicula.setValueAt( AdmSettings.getLanguageBundle().getString( peliculas.get( key ).getGenero().getLangKey() ), 0, 1 );
        tablaPelicula.setValueAt( peliculas.get( key ).getIdioma(), 0, 2 );
        tablaPelicula.setValueAt( peliculas.get( key ).isTieneSubtitulos() ? peliculas.get( key ).getIdiomaSubtitulos() : "N/A", 0, 3 );
        tablaPelicula.setValueAt( peliculas.get( key ).obtenerDuracionFormateada(), 0, 4 );

        llenarComboHorariosDisponibles( key, horariosDisponibles );
    }

    /** Populates a given {@code JComboBox} object with the showtimes associated
     * to the movie specified with a given movie {@code String} key
     * 
     * @param key            The given {@code String} that contains the key to
     *                       get the movie from the movies main collection
     * @param comboShowtimes The given {@code JComboBox} object to be populated
     * @see model.Commons
     */
    public void llenarComboHorariosDisponibles ( String key, JComboBox comboShowtimes )
    {
        if ( comboShowtimes.getItemCount() > 0 )
            comboShowtimes.removeAllItems();
        
        //hd Horarios Disponibles
        peliculas.get( key ).getHorariosDisponibles().forEach( hd -> comboShowtimes.addItem( hd.format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) ) ) );
    }

    /** Gets an existing {@code Pelicula} object that matches with a given 
     * {@code String} movie name
     *
     * @param nombrePelicula The specified {@code String} that contains a movie
     *                       name
     *
     * @return The {@code Pelicula} object that matches with the given movie 
     * name
     *
     * @see model.Pelicula
     */
    public Pelicula obtenerPelicula ( String nombrePelicula )
    {
        return peliculas.get( nombresPeliculas.get( nombrePelicula ) );
    }

    /** Gets a new {@code Funcion} object with a given time and movie name both
     * as {@code String}, which represents a movie show.
     * <p>
     * In order to achieve this, it parses the given hour to a LocalTime object,
     * gets the respective movie object from movies main collection 
     * using the given movie name and calculates the days between this movie 
     * release date and today. Then it validates it, if this calculated time is 
     * lesser than 7 days, it is a new premiere movie release, otherwise it is
     * an already realeased movie and it is considered habitual. So knowing 
     * this, the {@code Funcion} movie show id, which is needed, can be set up.
     * <p>
     * The show id has to have the following structure:
     * <p>
     * F-movieId-nowDate-choosedScheduleHour-choosedScheduleMinute
     * <p>
     * The movie {@code Funcion} show id starts with a F precisely for being 
     * related to the word 'Funcion', and the movie id has the format "M-001", 
     * the now date has the format "yyMMdd", the hours have the format "h"
     * and the minutes have the format "m", it follows the 24 hour convention 
     * (if hour = 9 and minutes = 0, it means it is scheduled for 9:00 AM, and
     * so on).
     * <p>
     * An example of this id would be as follows:
     * <p>
     * F-M-003-21110690
     *
     * @param hora           The specified {@code String} that contains time 
     *                       data in format "hh:mm"
     * @param nombrePelicula The specified {@code String} that contains a movie
     *                       name
     *
     * @return A new {@code Funcion} object that is structured with the 
     * specified given parameters
     *
     * @see model.Funcion
     */
    public Funcion obtenerFuncion ( String hora, String nombrePelicula )
    {
        boolean estreno = false;

        Pelicula pelicula = obtenerPelicula( nombrePelicula );
        LocalTime horarioElegido = LocalTime.parse( hora );
        Period tiempoEstrenada = Period.between( pelicula.getFechaEstreno(), LocalDate.now() );

        if ( tiempoEstrenada.getDays() <= 7 )
            estreno = true;

        String codigoFuncion = "F-" + pelicula.getId() + "-" + LocalDate.now().format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.FechaCompacta ) ) + horarioElegido.getHour() + horarioElegido.getMinute();

        return new Funcion( codigoFuncion, "", horarioElegido, estreno );
    }

}
