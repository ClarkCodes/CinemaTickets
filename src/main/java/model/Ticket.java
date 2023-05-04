
package model;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.Commons;
import control.AdmSettings;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/** Cinema Ticket Class, this is part of the core of this project.
 * When a Ticket is created, an instance of this class is produced in a new
 * {@code Ticket} object, such instance has all the necessary information about 
 * everything needed to identify every aspect of the ticket and the client 
 * inside the Cinema.
 * It has several interesting attributes:
 * <pre>
 *  - numeroTicket: The number of this Ticket. Type: {@code int}
 *  - precio: This Ticket's price. Type: {@code double}
 *  - fechaGeneracion: This Ticket's generation date. Type: {@code LocalDate}
 *  - cliente: This Ticket's owner, this is the client that owns this ticket. Type: {@code Cliente}
 *  - elementosCine: Collection meant to store objects that inherits from the super class {@code ElementoCine},
 * </pre>
 * which are related and attached to this ticket particularly, this is the
 * movie, function and theater hall,
 * ergo {@code Pelicula}, {@code Funcion} and {@code Sala} objects. Type:
 * {@code HashMap<String, ElementoCine>}
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 * @see model.Cliente model.Pelicula model.Funcion model.Sala control.AdmTicket
 */
public final class Ticket extends ElementoCine implements IPrecio, Serializable
{   // Colección HashMap de Elementos Cine
    private HashMap<String, ElementoCine> elementosCine = new HashMap<>();

    // Objeto Cliente
    private Cliente cliente;

    // Otros Atributos - Campos - Propiedades
    private int numeroTicket = 0;
    private double precio = 0.0;
    private LocalDate fechaGeneracion = LocalDate.now();

    /** Sole Constructor to initialize a Ticket instance */
    public Ticket ()
    {   // Constructor por Defecto. Se optó por un Constructor por defecto y no uno parametrizado por conveniencia y comodidad a la hora de Generar el Ticket.
        super( "", "" );
    }

    @Override
    public String toString ()
    {
        return "\n\n***** Ticket *****" + super.toString()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_ticket_number_label" ) + getNumeroTicket()
                + "\n" + AdmSettings.getLanguageBundle().getString( "lk_ticket_price_label" ) + getPrecioFormatoMoneda()
                + "\n\n***** " + AdmSettings.getLanguageBundle().getString( "lk_details" ) + " *****"
                + cliente
                + getPelicula()
                + getSala()
                + getFuncion() + "\n";
    }

    /** Sets this ticket price based on a certain criteria.
     * <p>
     * This method must be invoked just when the ticket has been created, once
     * the creation has ocurred,
     * this method verifies several attributes to set the price, as follows:
     * <p>
     * 1. The price starts with a base of $2.00, it verifies the theater hall
     * type, adding a certain amount in every case:
     * <pre>
     * VIP   : +4
     * 4D    : +3
     * 3D"   : +2
     * Normal: +0.50
     * </pre>
     * 2. It verifies if the movie is a release or not, adding a certain amount
     * in every case:
     * <pre>
     * true : +2
     * false: +0.50
     * </pre>
     * 3. It verifies if this corresponds to a Vermouth function, if true and
     * only if simultaneously the theater hall type is not VIP,
     * a 50% discount is calculated on the final price, otherwise the price
     * persists as it was at the previous step.
     */
    @Override
    public void generarPrecio ()
    {   // Generar el Precio con este método tomando en cuenta los parámetros para ello
        double price = 2.00; // Precio Base
        boolean vermouth = false;
        boolean isVIP = false;

        if ( this.precio == 0.0 )
        {
            for ( Map.Entry e : elementosCine.entrySet() )
            {
                if ( e != null )
                {   // Verificamos Criterios de la Sala para establecer el precio
                    if ( e.getValue() instanceof Sala sala )
                    {
                        switch ( sala.getTipoSala() )
                        {
                            case "VIP" ->
                            {
                                price += 4;
                                isVIP = true;
                            }
                            case "4D" -> price += 3;
                            case "3D" -> price += 2;
                            case "Normal" -> price += 0.50;
                        }
                    }
                    // Verificamos Criterios de la Funcion para establecer el precio
                    if ( e.getValue() instanceof Funcion funcion )
                    {
                        if ( funcion.isEstreno() )
                        {
                            price += 2;
                        }
                        else
                        {
                            price += 0.50;
                        }

                        if ( funcion.getTipoFuncion() == Commons.TipoFuncion.Vermouth )
                            vermouth = true;
                    }
                }
            }

            if ( !isVIP && vermouth ) // Si es una funcion Vermouth, adquiere un 50% de descuento, pero solo si no es VIP, de serlo no obtiene el descuento
                price *= 0.50;
        }

        this.precio = price;
    }

    /** Gets the respective {@code Pelicula} instance object from the collection 
     * where it is stored in this Ticket
     *
     * @return The proper {@code Pelicula} object stored in and that belongs to
     *         this Ticket instance
     * @see model.ElementoCine
     */
    public Pelicula getPelicula ()
    {
        Pelicula pelicula = null;

        for ( Map.Entry e : elementosCine.entrySet() )
        {
            if ( e != null && e.getValue() instanceof Pelicula movie )
            {   //Aplicando instanceof matching pattern ya no es necesario realizar un casting
                pelicula = movie;
                break;
            }
        }

        return pelicula;
    }

    /** Gets the respective {@code Sala} instance object from the collection 
     * where it is stored in this Ticket
     *
     * @return The proper {@code Sala} object stored in and that belongs to this
     *         Ticket instance
     * @see model.ElementoCine
     */
    public Sala getSala ()
    {
        Sala sala = null;

        for ( Map.Entry e : elementosCine.entrySet() )
        {
            if ( e != null && e.getValue() instanceof Sala hall )
            {   //Aplicando instanceof matching pattern ya no es necesario realizar un casting
                sala = hall;
                break;
            }
        }

        return sala;
    }

    /** Gets the respective {@code Funcion} instance object from the collection 
     * where it is stored in this Ticket
     *
     * @return The proper {@code Funcion} object stored in and that belongs to
     *         this Ticket instance
     * @see model.ElementoCine
     */
    public Funcion getFuncion ()
    {
        Funcion funcion = null;
        
        for ( Map.Entry e : elementosCine.entrySet() )
        {   //Aplicando instanceof matching pattern ya no es necesario realizar un casting
            if ( e != null && e.getValue() instanceof Funcion show)
            {
                funcion = show;
                break;
            }
        }

        return funcion;
    }

    /** Gets this ticket price properly formatted for currency
     *
     * @return The proper currency {@code String} representation of this Ticket
     *         price
     */
    public String getPrecioFormatoMoneda ()
    {
        NumberFormat cf = DecimalFormat.getCurrencyInstance();
        return cf.format( precio );
    }

    // Getters and Setters
    /** Gets this cinema tickets elements collection
     * @return This Ticket {@code HashMap<String, ElementoCine>} collection that
     * contains {@code Funcion}, {@code Sala} {@code Pelicula} objects belonged
     * to this Ticket
     */
    public HashMap<String, ElementoCine> getElementosCine ()
    {
        return elementosCine;
    }
    /** Sets this cinema tickets elements collection
     * @param elementosCine A Ticket {@code HashMap<String, ElementoCine>} 
     * collection that contains {@code Funcion}, {@code Sala} {@code Pelicula} 
     * objects belonged to this Ticket
     */
    public void setElementosCine ( HashMap<String, ElementoCine> elementosCine )
    {
        this.elementosCine = elementosCine;
    }
    /** Gets this ticket client
     * @return This ticket {@code Cliente} object that is this ticket client
     */
    public Cliente getCliente ()
    {
        return cliente;
    }
    /** Sets this ticket client
     * @param cliente This ticket {@code Cliente} object that is this ticket 
     *                client
     */
    public void setCliente ( Cliente cliente )
    {
        this.cliente = cliente;
    }
    /** Gets this ticket number
     * @return This ticket {@code int} number identifier
     */
    public int getNumeroTicket ()
    {
        return numeroTicket;
    }
    /** Sets this ticket number
     * @param numeroTicket This ticket {@code int} number identifier
     */
    public void setNumeroTicket ( int numeroTicket )
    {
        this.numeroTicket = numeroTicket;
    }
    /** Gets this ticket price
     * @return This ticket {@code double} number that represents its price
     */
    public double getPrecio ()
    {
        return this.precio;
    }
    /** Sets this ticket price
     * @param precio A {@code double} number that represents this ticket price
     */
    public void setPrecio ( double precio )
    {
        this.precio = precio;
    }
    /** Gets this generation date
     * @return This ticket {@code LocalDate} object that represents this ticket
     * generation date
     */
    public LocalDate getFechaGeneracion ()
    {
        return fechaGeneracion;
    }
    /** Sets this generation date
     * @param fechaGeneracion A {@code LocalDate} object that represents this 
     *                        ticket generation date
     */
    public void setFechaGeneracion ( LocalDate fechaGeneracion )
    {
        this.fechaGeneracion = fechaGeneracion;
    }

}
