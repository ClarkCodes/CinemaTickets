package model;
// Imports
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
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class Pelicula extends ElementoCine
{
    private String genero;
    private String idioma;
    private boolean tieneSubtitulos;
    private String idiomaSubtitulos;
    private Duration duracion;
    private ArrayList<LocalTime> horariosDisponibles;
    private LocalDate fechaEstreno;

    /** Parameterized Constructor for creating movie objects.
     * @param id this movie ID
     * @param nombre this movie name
     * @param genero this movie genre
     * @param idioma this movie language
     * @param tieneSubtitulos {@code boolean} identifier that indicates if this movie has subtitles or not
     * @param idiomaSubtitulos this movie's subtitles language
     * @param duracion this movie duration in format h:mm
     * @param horariosDisponibles this movie's available schedule list
     * @param fechaEstreno this movie release date
     */
    public Pelicula(String id, String nombre, String genero, String idioma, boolean tieneSubtitulos, String idiomaSubtitulos, Duration duracion, ArrayList<LocalTime> horariosDisponibles, LocalDate fechaEstreno) 
    {
        super(id, nombre);
        this.genero = genero;
        this.idioma = idioma;
        this.tieneSubtitulos = tieneSubtitulos;
        this.idiomaSubtitulos = idiomaSubtitulos;
        this.duracion = duracion;
        this.horariosDisponibles = horariosDisponibles;
        this.fechaEstreno = fechaEstreno;
    }

    @Override
    public String toString() 
    {
        return "\n\n** Película **" + super.toString()  
                + "\nGénero: " + getGenero()
                + "\nIdioma: " + getIdioma()
                + "\nTiene Subtítulos: " + (isTieneSubtitulos() ? ("Si" + "\nIdioma de los Subt\u00edtulos:" + getIdiomaSubtitulos()) : "No")
                + "\nDuración: " + obtenerDuracionFormateada()
                + "\nFecha de Estreno: " + getFechaEstreno().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaLarga));
    }

    /** Gets this movie's duration in format h:mm 
     * @return The {@code String} representation of this movie's duration
     */
    public String obtenerDuracionFormateada()
    {   // Duracion Formateada
        return LocalTime.ofSecondOfDay(getDuracion().toSeconds()).
                format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.Duracion));
    }
    
    // Getters and Setters
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public boolean isTieneSubtitulos() {
        return tieneSubtitulos;
    }

    public void setTieneSubtitulos(boolean tieneSubtitulos) {
        this.tieneSubtitulos = tieneSubtitulos;
    }

    public String getIdiomaSubtitulos() {
        return idiomaSubtitulos;
    }

    public void setIdiomaSubtitulos(String idiomaSubtitulos) {
        this.idiomaSubtitulos = idiomaSubtitulos;
    }

    public ArrayList<LocalTime> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(ArrayList<LocalTime> horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

}
