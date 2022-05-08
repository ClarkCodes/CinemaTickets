
package model;

import control.AdmSettings;
import java.io.Serializable;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Cliente Class, represents a Client in real life with 4 basic attributes
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Cliente implements IGenero, Serializable
{
    private String cedula, nombreCliente;
    private int edad;
    private char genero;

    /** Parameterized Constructor which loads a {@code Cliente} instance with
     * its 4 basic attributes.
     *
     * @param cedula        Person's ID (In Ecuador it is a "Cedula de
     *                      Ciudadania")
     * @param nombreCliente Client's name
     * @param edad          Client's age
     * @param genero        Client's gender: Male or Female for this case it is
     *                      a char, so it must be a 'M' or a 'F'
     */
    public Cliente ( String cedula, String nombreCliente, int edad, char genero )
    {
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.edad = edad;
        this.genero = genero;
    }
    
    /** Sole Constructor */
    public Cliente() {}

    @Override
    public String toString ()
    {
        return "\n\n** " + AdmSettings.getLanguageBundle().getString( "lk_client" ) + " **"
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_client_only_id_label" ) + getCedula()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_name_label" ) + getNombreCliente()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_age_label" ) + getStrEdad()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_gender_label" ) + verGenero();
    }

    /** Gets this client gender as the corresponding word in natural language
     * 
     * @return A {@code String} representation of the word that corresponds to 
     * this {@code Cliente} client instance object gender
     */
    @Override
    public String verGenero ()
    {
        return ( ( getGenero() == 'M' ) ? AdmSettings.getLanguageBundle().getString( "lk_search_male" ) : AdmSettings.getLanguageBundle().getString( "lk_search_female" ) );
    }

    /** Gets a {@code String} representation of this Client age in human
     * language, for example: 36 years old / 36 años
     *
     * @return The {@code String} age representation
     * 
     * @since 1.6
     */
    public String getStrEdad ()
    {
        return edad + " " + AdmSettings.getLanguageBundle().getString( "lk_search_years" );
    }

    // Getters and Setters
    /** Gets this client age
     * @return An {@code int} number that indicates this client age
     */
    public int getEdad ()
    {
        return edad;
    }
    /** Sets this client age
     * @param edad An {@code int} number that indicates this client age
     */
    public void setEdad ( int edad )
    {
        this.edad = edad;
    }
    /** Gets this client gender
     * @return A {@code char} M or F that indicates the client gender, M: Male, 
     * F: Female
     */
    public char getGenero ()
    {
        return genero;
    }
    /** Sets this client gender
     * @param genero A {@code char} M or F that indicates the client gender, 
     *               M: Male, F: Female
     */
    public void setGenero ( char genero )
    {
        this.genero = genero;
    }
    /** Gets this client cedula identification
     * @return A {@code String} representation that contains this client cedula 
     * identification
     */
    public String getCedula ()
    {
        return cedula;
    }
    /** Sets this client cedula identification
     * @param cedula A {@code String} representation that contains this client cedula 
     *               identification
     */
    public void setCedula ( String cedula )
    {
        this.cedula = cedula;
    }
    /** Gets this client name
     * @return A {@code String} representation that contains this client name
     */
    public String getNombreCliente ()
    {
        return nombreCliente;
    }
    /** Sets this client name
     * @param nombreCliente A {@code String} representation that contains this 
     *                      client name
     */
    public void setNombreCliente ( String nombreCliente )
    {
        this.nombreCliente = nombreCliente;
    }

}
