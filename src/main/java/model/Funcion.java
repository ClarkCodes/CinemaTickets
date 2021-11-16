package model;
// Imports
import java.time.LocalTime;
import java.util.Random;

/** Movie Function Class to create {@code Funcion} objects with its respective attributes.
 * <p>
 * This Class has 3 attributes:
 * <pre>
 *   - horarioElegido: It is an {@code LocalTime} object, represents a schedule time chosen by user
 *
 *   - estreno: It is an {@code boolean} attribute, represents if a movie is a release
 *
 *   - tipoFuncion: It is a {@code TipoFuncion} enum attribute, represents the Function Type
 * </pre>
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class Funcion extends ElementoCine
{
    private LocalTime horarioElegido;
    private boolean estreno;
    private TipoFuncion tipoFuncion;

    /** Parameterized Constructor that receives 4 parameters
     * @param id A {@code String} ID for this {@code Funcion} object
     * @param nombre A {@code String} name for this {@code Funcion} object
     * @param horarioElegido A {@code LocalTime} object that it is the chosen schedule time for this {@code Funcion} object
     * @param estreno A {@code boolean} parameter that indicates if the movie related is or not a new release
     */
    public Funcion(String id, String nombre, LocalTime horarioElegido, boolean estreno) 
    {
        super(id, nombre); // El nombre viene vacio solamente para no romper el esquema del constructor de la superclase para el cual es necesario.
        this.horarioElegido = horarioElegido;
        this.estreno = estreno;
        this.tipoFuncion = determinarVermouth();
        this.nombre = asignarNombre();
    }
    
    @Override
    public String toString() 
    {
        return "\n\n** Función **" + super.toString()  
                + "\nHorario Elegido: " + getHorarioElegido().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos))
                + "\nEstreno o Habitual: " + getEstrenoHabitual()
                + "\nVermouth o Normal: " + getTipoFuncion().toString();
    }
 
    /** Gets a value that determines if the movie is or not a Vermouth
     * @return A {@code TipoFuncion} value representing if the movie is Vermouth or Normal
     * @see model.TipoFuncion
     */
    private TipoFuncion determinarVermouth()
    {
        TipoFuncion isVermouth = TipoFuncion.Normal;
        Random rnd = new Random();

        if(rnd.nextInt(2) == 1)
            isVermouth = TipoFuncion.Vermouth;

        return isVermouth;
    }
    
    /** Gets the name of this {@code Funcion} object
     * @return The {@code String} function name
     */
    private String asignarNombre()
    {
        return "Funcion " + getTipoFuncion().toString();
    }
    
    /** Gets a value that represents if this fuctions aims to a release or habitual movie
     * @return The {@code String} value wether "Estreno" if it is a realse or "Habitual" if it is not
     */
    public String getEstrenoHabitual()
    {
        return (isEstreno() ? "Estreno" : "Habitual");
    }

    // Getters and Setters
    public LocalTime getHorarioElegido() {
        return horarioElegido;
    }

    public void setHorarioElegido(LocalTime horarioElegido) {
        this.horarioElegido = horarioElegido;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        this.estreno = estreno;
    }

    public TipoFuncion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(TipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }
}
