
package model;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

/** Movie Show Class to create {@code Funcion} objects with its respective
 * attributes.
 * <p>
 * This Class has 3 attributes:
 * <pre>
 *   - horarioElegido: It is an {@code LocalTime} object, represents a schedule time chosen by user
 *
 *   - estreno: It is an {@code boolean} attribute, represents if a movie is a release
 *
 *   - tipoFuncion: It is a {@code TipoFuncion} enum attribute, represents the Show Type
 * </pre>
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Funcion extends ElementoCine implements Serializable
{
    private LocalTime horarioElegido;
    private boolean estreno;
    private Commons.TipoFuncion tipoFuncion;

    /** Parameterized Constructor that receives 4 parameters
     *
     * @param id             A {@code String} ID for this {@code Funcion} object
     * @param nombre         A {@code String} name for this {@code Funcion}
     *                       object
     * @param horarioElegido A {@code LocalTime} object that it is the chosen
     *                       schedule time for this {@code Funcion} object
     * @param estreno        A {@code boolean} parameter that indicates if the
     *                       movie related is or not a new release
     */
    public Funcion ( String id, String nombre, LocalTime horarioElegido, boolean estreno )
    {
        super( id, nombre ); // El nombre viene vacio solamente para no romper el esquema del constructor de la superclase para el cual es necesario.
        this.horarioElegido = horarioElegido;
        this.estreno = estreno;
        this.tipoFuncion = determinarVermouth();
        this.nombre = asignarNombre();
    }
    /** Sole Constructor */
    public Funcion ()
    {
        super ( "", "" );
    }

    @Override
    public String toString ()
    {
        return "\n\n** " + AdmSettings.getLanguageBundle().getString( "lk_cHeader_show" ) + " **" + super.toString()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_selected_showtime_label" ) + getHorarioElegido().format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) )
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_movie_premiere_habitual_label" ) + getEstrenoHabitual()
                + "\nVermouth/Normal: " + getTipoFuncion().toString();
    }

    /** Gets this object show type: Vermouth or Normal as its respective enum 
     * constant
     *
     * @return A {@code TipoFuncion} value representing if the movie is Vermouth
     *         or Normal
     *
     * @see model.TipoFuncion
     */
    private Commons.TipoFuncion determinarVermouth ()
    {
        Commons.TipoFuncion isVermouth = Commons.TipoFuncion.Normal;
        Random rnd = new Random();

        if ( rnd.nextInt( 2 ) == 1 )
            isVermouth = Commons.TipoFuncion.Vermouth;

        return isVermouth;
    }

    /** Gets this object name
     *
     * @return The {@code String} representation that contains this show object 
     * name
     */
    private String asignarNombre ()
    {
        return AdmSettings.getLanguageBundle().getString( "lk_cHeader_show" ) + " " + getTipoFuncion().toString();
    }

    /** Gets this object premiere type: Premiere or Habitual
     *
     * @return The {@code String} representation that contains "Estreno" if it 
     *         is a premiere release or "Habitual" if it is not
     */
    public String getEstrenoHabitual ()
    {
        return ( isEstreno() ? AdmSettings.getLanguageBundle().getString( "lk_movie_premiere" ) : "Habitual" );
    }

    // Getters and Setters
    /** Gets the selected showtime
     * @return This show {@code LocalTime} object that represents the selected 
     * showtime
     */
    public LocalTime getHorarioElegido ()
    {
        return horarioElegido;
    }
    /** Sets the selected showtime
     * @param horarioElegido This show {@code LocalTime} object that represents
     *                       the selected showtime
     */
    public void setHorarioElegido ( LocalTime horarioElegido )
    {
        this.horarioElegido = horarioElegido;
    }
    /** Gets the premiere indicator
     * @return {@code true} if this is a premiere movie show, {@code false} 
     * otherwise
     */
    public boolean isEstreno ()
    {
        return estreno;
    }
    /** Sets the premiere indicator
     * @param estreno It shall be {@code true} if this is a premiere movie show,
     *                {@code false} otherwise
     */
    public void setEstreno ( boolean estreno )
    {
        this.estreno = estreno;
    }
    /** Gets this Show type
     * @return A {@code TipoFuncion enum} constant that represents the type or
     * kind of show this is
     */
    public Commons.TipoFuncion getTipoFuncion ()
    {
        return tipoFuncion;
    }
    /** Sets this Show type
     * @param tipoFuncion A {@code TipoFuncion enum} constant that represents 
     *                    the type or kind of show this is
     */
    public void setTipoFuncion ( Commons.TipoFuncion tipoFuncion )
    {
        this.tipoFuncion = tipoFuncion;
    }

}
