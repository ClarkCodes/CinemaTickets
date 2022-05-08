
package model;

import control.AdmSettings;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Abstract Class which others classes are meant to inherit from /
 * Clase Abstracta, de la cual heredarán otras clases
 * <p>
 * It has 2 attributes: id and name, both {@code String}.
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public abstract class ElementoCine
{
    protected String id;
    protected String nombre;

    /** Parameterized Constructor with its 2 attributes to initialize
     *
     * @param id     The ID for the element that inherits
     * @param nombre The name for the element that inherits
     */
    public ElementoCine ( String id, String nombre )
    {
        this.id = id;
        this.nombre = nombre;
    }

    /** Gets a this object's atributes data as text in natural language,
     * overriding the implementation by default with a customized one
     *
     * @return The organized {@code String} representation with this object's
     *         attributes values, one line each
     */
    @Override
    public String toString ()
    {
        return "\n" + AdmSettings.getLanguageBundle().getString( "lk_name_label" ) + nombre
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_super_code_id_label" ) + id;
    }

    // Getters and Setters
    /** Gets this object name
     * @return A {@code String} representation that contains this object name
     */
    public String getNombre ()
    {
        return nombre;
    }
    /** Sets this object name
     * @param nombre A {@code String} representation that contains this object name
     */
    public void setNombre ( String nombre )
    {
        this.nombre = nombre;
    }
    /** Gets this object identification
     * @return A {@code String} representation that contains this object id
     */
    public String getId ()
    {
        return id;
    }
    /** Sets this object identification
     * @param id A {@code String} representation that contains this object id
     */
    public void setId ( String id )
    {
        this.id = id;
    }

}
