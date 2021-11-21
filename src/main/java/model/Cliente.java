package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Cliente Class, represents a Client in real life with 4 basic attributes
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class Cliente implements IGenero
{
    private String cedula;
    private String nombreCliente;
    private int edad;
    private char genero;
    
    /** Parameterized Constructor which loads a {@code Cliente} instance with its 4 basic attributes.
     * @param cedula Person's ID (In Ecuador it is a "Cedula de Ciudadania")
     * @param nombreCliente Client's name
     * @param edad Client's age
     * @param genero Client's gender: Male or Female for this case it is a char, so it must be a 'M' or a 'F'
     */
    public Cliente(String cedula, String nombreCliente, int edad, char genero) 
    {
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.edad = edad;
        this.genero = genero;
    }
    
    @Override
    public String toString() 
    {
        return """
               
               
               ** Cliente **
               C\u00e9dula de Identidad: """ + getCedula()
                + "\nNombre: " + getNombreCliente()
                + "\nEdad: " + getStrEdad()
                + "\nGénero: " + verGenero();
    }

    @Override
    public String verGenero() 
    {
        return ((getGenero() == 'M') ? "Masculino" : "Femenino");
    }
    
    /** Gets a {@code String} representation of this Client's age in human language, for example: 36 años
     * @return The age {@code String} representation
     */
    public String getStrEdad()
    {
        return edad + " años";
    }
    
    // Getters and Setters
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }  

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
