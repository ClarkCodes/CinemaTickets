package model;

/** Super Abstract Class from where others classes are meant to inherit / 
 * Super Clase ElementoCine, de la cual heredarán las demás.
 * <p>
 * It has 2 attributes: id and name, both {@code String}.
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public abstract class ElementoCine 
{
    protected String id;
    protected String nombre;

    /** Parameterized Constructor with its 2 attributes to initialize
     * @param id The ID for the element that inherits
     * @param nombre The name for the element that inherits
     */
    public ElementoCine(String id, String nombre) 
    {
        this.id = id;
        this.nombre = nombre;
    }

    /** Method {@code toString} with this object's atributes
     * @return The organized {@code String} representation with this object's attributes values, one line each
     */
    @Override
    public String toString() 
    {
        return "\nNombre: " + nombre 
                + "\nCódigo - ID: " + id;
    }
    
    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
