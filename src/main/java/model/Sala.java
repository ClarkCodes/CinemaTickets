
package model;

import control.AdmSettings;
import java.io.Serializable;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Cinema Theater Hall Class
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Sala extends ElementoCine implements Serializable
{
    private int numeroSala;
    private String tipoSala;
    private String asiento;

    /** Parameterized Constructor with 5 attributes to initialize
     *
     * @param id         This object's ID
     * @param nombre     This object's name
     * @param numeroSala Theater Hall number
     * @param tipoSala   Hall type
     * @param asiento    Seat/seats
     */
    public Sala ( String id, String nombre, int numeroSala, String tipoSala, String asiento )
    {
        super( id, nombre );
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.asiento = asiento;
    }
    /** Sole Constructor */
    public Sala ()
    {
        super ( "", "" );
    }

    @Override
    public String toString ()
    {
        return "\n\n** " + AdmSettings.getLanguageBundle().getString( "lk_cHeader_theater" ) + " **" + super.toString()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_theater_number_label" ) + getNumeroSala()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_theater_type_label" ) + getTipoSala()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_theater_seats_label" ) + getAsiento();
    }

    // Getters and Setters
    /** Gets this theater number identifier
     * @return An {@code int} number that represents this theater number 
     * identifier
     */
    public int getNumeroSala ()
    {
        return numeroSala;
    }
    /** Gets this theater number identifier
     * @param numeroSala An {@code int} number that represents this theater 
     *                   number identifier
     */
    public void setNumeroSala ( int numeroSala )
    {
        this.numeroSala = numeroSala;
    }
    /** Gets this theater type
     * @return A {@code String} representation that contains this theater type
     */
    public String getTipoSala ()
    {
        return tipoSala;
    }
    /** Sets this theater type
     * @param tipoSala A {@code String} representation that contains this 
     *                 theater type
     */
    public void setTipoSala ( String tipoSala )
    {
        this.tipoSala = tipoSala;
    }
    /** Gets this theater selected seats
     * @return A {@code String} representation that contains the selected seat/s
     * @deprecated MARKED FOR DELETION in a future verison for a logic 
     *             correction and reestructuration matter to stick to a real 
     *             scenario, given this approach was made just as part of a 
     *             school university project with stored data, it should be 
     *             corrected with a better approach to reflect the reality
     */
    @Deprecated
    public String getAsiento ()
    {
        return asiento;
    }
    /** @deprecated
     * MARKED FOR DELETION
     * Sets this theater selected seats
     * @param asiento A {@code String} representation that contains the selected
     *                seat/s
     * @deprecated MARKED FOR DELETION in a future verison for a logic 
     *             correction and reestructuration matter to stick to a real 
     *             scenario. Given this approach was made just as part of a 
     *             school university project with stored data, it should be 
     *             corrected with a better approach to reflect the reality
     */
    @Deprecated
    public void setAsiento ( String asiento )
    {
        this.asiento = asiento;
    }

}
