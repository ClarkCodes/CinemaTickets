package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Cinema Theater Hall Class to make {@code Sala} objects
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class Sala extends ElementoCine
{
    private int numeroSala;
    private String tipoSala;
    private String asiento;

    /** Parameterized Constructor with 5 attributes to initialize
     * @param id This object's ID
     * @param nombre This object's name
     * @param numeroSala Theater Hall number
     * @param tipoSala Hall type
     * @param asiento Seat/seats
     */
    public Sala(String id, String nombre, int numeroSala, String tipoSala, String asiento) 
    {
        super(id, nombre);
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.asiento = asiento;
    }

    @Override
    public String toString() 
    {
        return "\n\n** Sala **" + super.toString()  
                + "\nNúmero de Sala: " + getNumeroSala()
                + "\nTipo de Sala: " + getTipoSala()
                + "\nAsiento: " + getAsiento();
    }
    
    // Getters and Setters
    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
}
