
package model;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.Commons;
import control.AdmPelicula.MovieGenres;
import control.AdmSettings;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/** Movie Class, represents a Movie entity with its respective attributes.
 * <pre>
 * It inherits from {@code ElementoCine}, so it has its 2 attributes id and name, also the following:
 *  - genero: A {@code String} that represents the gender of this movie
 *  - idioma: A {@code String} that represents the language of this movie
 *  - tieneSubtitulos: A {@code boolean} that represents if this movie has subtitles or not
 *  - idiomaSubtitulos: A {@code String} that represents the subtitles language of this movie
 *  - duracion: A {@code Duration} object that represents duration of this movie in format hh:mm
 *  - horariosDisponibles: A {@code ArrayList<LocalTime>} object that represents an available schedule list for this movie
 *  - fechaEstreno: A {@code LocalDate} object that represents the release date of this movie
 * </pre>
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Pelicula extends ElementoCine implements Serializable
{
    private MovieGenres genero;
    private String idioma;
    private boolean tieneSubtitulos;
    private String idiomaSubtitulos;
    private Duration duracion;
    private ArrayList<LocalTime> horariosDisponibles;
    private LocalDate fechaEstreno;

    /** Parameterized Constructor for creating movie objects.
     *
     * @param id                  this movie ID
     * @param nombre              this movie name
     * @param genero              this movie genre
     * @param idioma              this movie language
     * @param tieneSubtitulos     {@code boolean} identifier that indicates if
     *                            this movie has subtitles or not
     * @param idiomaSubtitulos    this movie's subtitles language
     * @param duracion            this movie duration in format h:mm
     * @param horariosDisponibles this movie's available schedule list
     * @param fechaEstreno        this movie release date
     */
    public Pelicula ( String id, String nombre, MovieGenres genero, String idioma, boolean tieneSubtitulos, String idiomaSubtitulos, Duration duracion, ArrayList<LocalTime> horariosDisponibles, LocalDate fechaEstreno )
    {
        super( id, nombre );
        this.genero = genero;
        this.idioma = idioma;
        this.tieneSubtitulos = tieneSubtitulos;
        this.idiomaSubtitulos = idiomaSubtitulos;
        this.duracion = duracion;
        this.horariosDisponibles = horariosDisponibles;
        this.fechaEstreno = fechaEstreno;
    }
    /** Sole Constructor */
    public Pelicula ()
    {
        super ( "", "" );
    }

    @Override
    public String toString ()
    {
        return "\n\n** " + AdmSettings.getLanguageBundle().getString( "lk_movie" ) + " **" + super.toString()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_genre_label" ) + AdmSettings.getLanguageBundle().getString( getGenero().getLangKey() )
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_language_label" ) + getIdioma()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_has_subs_label" ) + ( isTieneSubtitulos() ? ( AdmSettings.getLanguageBundle().getString( "lk_yes" ) + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_subs_language_label" ) + getIdiomaSubtitulos() ) : "No" )
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_duration_label" ) + obtenerDuracionFormateada()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_premiere_date_label" ) + getFechaEstreno().format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.FechaLarga ) );
    }

    /** Gets this movie's duration in format h:mm
     *
     * @return The {@code String} representation of this movie's duration
     */
    public String obtenerDuracionFormateada ()
    {   // Duracion Formateada
        return LocalTime.ofSecondOfDay( getDuracion().toSeconds() ).
                format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.Duracion ) );
    }

    // Getters and Setters
    /** Gets this movie genre
     * @return A {@code MovieGenres enum} constant that represents this movie 
     * genre
     */
    public MovieGenres getGenero ()
    {
        return genero;
    }
    /** Sets this movie genre
     * @param genero A {@code MovieGenres enum} constant that represents this 
     *               movie genre
     */
    public void setGenero ( MovieGenres genero )
    {
        this.genero = genero;
    }
    /** Gets this movie language
     * @return A {@code String} representation that contains this movie language
     */
    public String getIdioma ()
    {
        return idioma;
    }
    /** Sets this movie language
     * @param idioma A {@code String} representation that contains this movie 
     *               language
     */
    public void setIdioma ( String idioma )
    {
        this.idioma = idioma;
    }
    /** Gets this movie time duration
     * @return A {@code Duration} object that represents the time this movie 
     * lasts
     */
    public Duration getDuracion ()
    {
        return duracion;
    }
    /** Sets this movie time duration
     * @param duracion A {@code Duration} object that represents the time this 
     *                 movie lasts
     */
    public void setDuracion ( Duration duracion )
    {
        this.duracion = duracion;
    }
    /** Gets this movie indicator about if it has subtitles
     * @return {@code true} if this movie has subtitles, {@code false} otherwise
     */
    public boolean isTieneSubtitulos ()
    {
        return tieneSubtitulos;
    }
    /** Sets this movie indicator about if it has subtitles
     * @param tieneSubtitulos Shall be {@code true} if this movie has subtitles,
     *                        {@code false} otherwise
     */
    public void setTieneSubtitulos ( boolean tieneSubtitulos )
    {
        this.tieneSubtitulos = tieneSubtitulos;
    }
    /** Gets this movie subtitles language
     * @return A {@code String} representation that contains this movie 
     * subtitles language
     */
    public String getIdiomaSubtitulos ()
    {
        return idiomaSubtitulos;
    }
    /** Sets this movie subtitles language
     * @param idiomaSubtitulos A {@code String} representation that contains 
     *                         this movie subtitles language
     */
    public void setIdiomaSubtitulos ( String idiomaSubtitulos )
    {
        this.idiomaSubtitulos = idiomaSubtitulos;
    }
    /** Gets this movie available showtimes
     * @return A {@code ArrayList<LocalTime>} collection with {@code LocalTime}
     * objects as elements that represents available showtimes each
     */
    public ArrayList<LocalTime> getHorariosDisponibles ()
    {
        return horariosDisponibles;
    }
    /** Sets this movie available showtimes
     * @param horariosDisponibles A {@code ArrayList<LocalTime>} collection with
     *                            {@code LocalTime} objects as elements that 
     *                            represents available showtimes each
     */
    public void setHorariosDisponibles ( ArrayList<LocalTime> horariosDisponibles )
    {
        this.horariosDisponibles = horariosDisponibles;
    }
    /** Gets this movie premiere release date
     * @return A {@code LocalDate} object that represents this movie premiere 
     * release date
     */
    public LocalDate getFechaEstreno ()
    {
        return fechaEstreno;
    }
    /** Sets this movie premiere release date
     * @param fechaEstreno A {@code LocalDate} object that represents this movie
     *                     premiere release date
     */
    public void setFechaEstreno ( LocalDate fechaEstreno )
    {
        this.fechaEstreno = fechaEstreno;
    }

}
