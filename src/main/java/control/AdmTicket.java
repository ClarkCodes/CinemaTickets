
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import data.DatosTickets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import model.*;

/** Main Management/Controller Class where the most important core methods are
 * stored
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class AdmTicket
{   // Atributos - Propiedades
    private HashMap<String, Ticket> tickets = null; // Coleccion HashMap Principal donde estaran almacenados los registros primordiales como objetos, en este caso de Tickets.
    private Ticket ticket = null; // Objeto Ticket declarado pero no inicializado(por eso es null o nulo) para luego si hacerlo y guardarlo como elemento en el HashMap tickets cada vez que quiera agregar un elemento.
    private int ticketsGenerados = 0; // ticketsGenerados: Cantidad de Tickets Generados para controlar el numero de ticket.
    private boolean ticketGeneradoExitosamente = false, saved = false;
    private DefaultTableModel tableModel;

    // Adms
    private final AdmCliente admCliente;
    private final AdmPelicula admPelicula;
    private final AdmSala admSala;
    private final Commons common;

    // Clase Datos
    private final DatosTickets datosTickets;

    // Objetos Temporales preparandolos para el Ticket
    private Cliente tempReadyClient = null;
    private Pelicula tempReadyPelicula = null;
    private Funcion tempReadyFuncion = null;
    private Sala tempReadySala = null;

    // Precio
    //private double tempReadyPrecio = 0.0;
    private AdmTicket () // Constructor por defecto puesto como privado, el cuï¿½l inicializa la colecciï¿½n HashMap.
    {
        this.tickets = new HashMap<>();
        this.datosTickets = DatosTickets.getDatosTickets();
        this.common = Commons.getAdm();
        this.admCliente = AdmCliente.getAdm();
        this.admPelicula = AdmPelicula.getAdm();
        this.admSala = AdmSala.getAdm();
    }

    private static AdmTicket adm = null; // Objeto estatico de esta misma clase declarado pero no inicializado, preparandolo para el patron Singleton.

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code AdmTicket} instance
     */
    public static AdmTicket getAdm () // Metodo estatico y publico de esta clase que devuelve la instancia unica de esta clase, si reciï¿½n se abre la aplicaciï¿½n y reciï¿½n se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fue creada se devuelve la que ya estï¿½, manteniendo una ï¿½nica instancia siempre.
        if ( adm == null )
            adm = new AdmTicket();
        return adm;
    }
    
    /** Enum helper to know how to fill a registry in a table */
    public enum TipoLlenarRegistro
    {   /** Registry filling type {@code enum} constant for Adding a Row, used to indicate that is necessary to add a row when populating a {@code JTable} object */
        AddRow, /** Registry filling type {@code enum} constant for Editing a Row, used to indicate not to add a row but to edit the ticket data in that certain {@code JTable} row */
        EditRow
    }

    /** Puts a just created {@code Ticket} object in the main tickets collection
     * as part of the generated tickets
     */
    public void generarTicket () // Metodo Nucleo en el que se guarda el Ticket en el HashMap Principal
    {
        aumentarTicketsGenerados( 1 );
        tickets.put( getTicket().getId(), getTicket() );
    }

    /** Updates an existing specified {@code Ticket} object with the
     * modifications a user does on it, replacing the current object in 
     * collection with a one with the modified information
     *
     * @param keyToModifyReplace A {@code String} representation that contains a
     *                           ticket key to specify the one that is being 
     *                           replaced
     */
    public void actualizarTicket ( String keyToModifyReplace )
    {
        tickets.replace( keyToModifyReplace, ticket );
        setTicketGeneradoExitosamente( true );
    }

    /** Deletes an existing specified {@code Ticket} object from the main
     * tickets collection with a given key
     *
     * @param keyToRemove A {@code String} representation of the ticket key to 
     *                    specify the one that is being deleted
     */
    public void eliminarTicket ( String keyToRemove )
    {
        tickets.remove( keyToRemove ); // Elimino el Ticket del HashMap
    }

    /** Increments the generated tickets count on a given integer parameter
     *
     * @param adicionExtra The amount that is going to be added
     */
    public void aumentarTicketsGenerados ( int adicionExtra )
    {
        this.ticketsGenerados += adicionExtra;
    }

    /** Prepares the client for a ticket in its generation proccess, retrieving 
     * the proper {@code Cliente} client object from the right source either in 
     * manual or stored mode, this is to get it ready to be included as part of 
     * its new {@code Ticket} instance when generating a Ticket
     * 
     * @param clientMode The current client mode in settings to determine the 
     *                   source to retrieve the client object from, either a 
     *                   stored client object or a just manually registered 
     *                   client
     * 
     * @since 1.0
     */
    public void prepararCliente ( AdmSettings.DataMode clientMode )
    {
        tempReadyClient = switch ( clientMode )
        {
            case Stored -> admCliente.generarCliente();
            case Manual -> admCliente.getTempClient();
        };
    }

    /** Prepares a selected existing movie {@code Pelicula} object to be ready
     * to be included as part of a new {@code Ticket} instance when generating a
     * Ticket
     *
     * @param nombrePelicula           Movie name to get the specified exitsting
     *                                 corresponding {@code Pelicula} movie
     *                                 object
     * @param tablaPelicula            {@code JTable} object where information
     *                                 of selected movie would be shown
     * @param comboHorariosDisponibles {@code JComboBox} object where the
     *                                 available showtimes for the selected
     *                                 movie are going to be loaded
     */
    public void prepararPelicula ( String nombrePelicula, JTable tablaPelicula, JComboBox comboHorariosDisponibles )
    {
        tempReadyPelicula = admPelicula.obtenerPelicula( nombrePelicula );
        admPelicula.llenarTablaPeliculaElegida( tempReadyPelicula.getId(), tablaPelicula, comboHorariosDisponibles );
    }

    /** Prepares a selected existing theater hall {@code Sala} object to be
     * ready to be included as part of a new {@code Ticket} instance when
     * generating a Ticket
     *
     * @param nombreSala Theater Hall name to get the specified exitsting
     *                   corresponding {@code Sala} object
     * @param tablaSala  {@code JTable} object where information of selected
     *                   theater hall would be shown
     */
    public void prepararSala ( String nombreSala, JTable tablaSala )
    {
        tempReadySala = admSala.obtenerSala( nombreSala );
        admSala.llenarTablaSalaElegida( tempReadySala.getId(), tablaSala );
    }

    /** Prepares a selected existing movie show {@code Funcion} object to be
     * ready to be included as part of a new {@code Ticket} instance when
     * generating a Ticket
     *
     * @param horarioElegido movie showtime selected by user
     * @param nombrePelicula movie name this show is related
     * @param funcionElegida {@code JTable} object where information of this
     *                       movie show would be shown
     */
    public void prepararFuncion ( String horarioElegido, String nombrePelicula, JTable funcionElegida )
    {
        tempReadyFuncion = admPelicula.obtenerFuncion( horarioElegido, nombrePelicula );
        llenarTablaFuncionElegida( funcionElegida );
    }

    /** * Prepares a ticket to be added to the main tickets collection depending
     * on a given {@code WindowMode} indicator.
     * <p>
     * On creation, a new {@code Ticket} instance object is created and 
     * populated with its respective attribute objects, which contains the 
     * information and options selected by a user in the ticket generation 
     * window.
     * <p>
     * On update/modification the {@code elementosCine} collection in the
     * current {@code Ticket} object is cleared to be populated with posibly
     * modified versions of these ones, the current chosen client is set on the
     * ticket and the ticket price is recalculated with this posibly new 
     * information in the ticket.
     *
     * @param formaProceder A {@code WindowMode enum} constant indicator to
     *                      determine what way to go: creation or modification
     *@see control.AdmTicket
     */
    public void prepararTicket ( Commons.WindowMode formaProceder )
    {
        switch ( formaProceder )
        {
            case Creacion ->
            {   // Se crea y se prepara la Instancia de Ticket lista para agregarla al HashMap Principal
                String codigoTicket = "T-" + tempReadySala.getId() + tempReadyFuncion.getId();
                setTicket( new Ticket() );
                getTicket().setId( codigoTicket );
                getTicket().setNombre( "Ticket - " + AdmSettings.getLanguageBundle().getString( "lk_ticket_name" ) + " - " + tempReadySala.getTipoSala() );
                getTicket().setNumeroTicket( getTicketsGenerados() + 1 );
            }

            case Edicion ->
                ticket.getElementosCine().clear();

            default ->
            {
            }
        }

        getTicket().setCliente( tempReadyClient );
        getTicket().getElementosCine().put( tempReadyPelicula.getId(), tempReadyPelicula );
        getTicket().getElementosCine().put( tempReadySala.getId(), tempReadySala );
        getTicket().getElementosCine().put( tempReadyFuncion.getId(), tempReadyFuncion );
        getTicket().generarPrecio();
    }

    /** Sets a custom {@code SpinnerNumberModel} to a given {@code JSpinner}
     * element to specify its boundaries
     *
     * @param spinnerClientAge A given {@code JSpinner} to set up the number
     *                         model on it, this element is meant to handle a
     *                         client age, so boundaries are related with that 
     *                         matter
     *
     * @since 1.6
     * @see visual.FrmBuscarTicket
     */
    public void setSpinnerRange ( JSpinner spinnerClientAge )
    {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel();
        spinnerModel.setMaximum( 100 );
        spinnerModel.setMinimum( 0 );
        spinnerClientAge.setModel( spinnerModel );
    }

    /** Populates a given {@code JTable} object with a specified client
     * information
     *
     * @param tablaCliente A given {@code JTable} object to be populated
     * @param cliente      A {@code Cliente} object to populate the table with 
     *                     its information
     */
    public void llenarTablaCliente ( JTable tablaCliente, Cliente cliente )
    {
        DefaultTableModel modeloCO = ( DefaultTableModel ) tablaCliente.getModel();
        DefaultTableColumnModel columnModelCO = ( DefaultTableColumnModel ) tablaCliente.getColumnModel();

        if ( tablaCliente.getRowCount() == 0 )
        {
            modeloCO.addRow( new Object[1] );
            common.centerTableColumns( tablaCliente ); // Centers information in table            
            columnModelCO.getColumn( 0 ).setPreferredWidth( 56 );
            columnModelCO.getColumn( 1 ).setPreferredWidth( 194 );
            columnModelCO.getColumn( 2 ).setPreferredWidth( 10 );
            columnModelCO.getColumn( 3 ).setPreferredWidth( 40 );
        }

        tablaCliente.setValueAt( cliente.getCedula(), 0, 0 );
        tablaCliente.setValueAt( cliente.getNombreCliente(), 0, 1 );
        tablaCliente.setValueAt( cliente.getStrEdad(), 0, 2 );
        tablaCliente.setValueAt( cliente.verGenero(), 0, 3 );
    }

    /** Populates a given {@code JTable} object with a specified movie show
     * information
     *
     * @param tablaCliente a given {@code JTable} object to be populated
     */
    private void llenarTablaFuncionElegida ( JTable funcionElegida )
    {
        DefaultTableModel modelFE = ( DefaultTableModel ) funcionElegida.getModel();

        if ( funcionElegida.getRowCount() == 0 )
        {
            modelFE.addRow( new Object[1] );
            common.centerTableColumns( funcionElegida );
        }

        funcionElegida.setValueAt( tempReadyFuncion.getId(), 0, 0 );
        funcionElegida.setValueAt( tempReadyFuncion.getNombre(), 0, 1 );
        funcionElegida.setValueAt( tempReadyFuncion.getEstrenoHabitual(), 0, 2 );
    }

    /** Lists all the existing tickets in main tickets collection on a given
     * {@code JTable} object
     *
     * @param tablaBusqueda A given {@code JTable} object to be populated with
     *                      every ticket information
     */
    public void buscarTicket ( JTable tablaBusqueda ) // Buscar Ticket - Lista Todos
    {
        ArrayList<String> allTicketsIDsList = new ArrayList<>();
        allTicketsIDsList.addAll( tickets.keySet().stream().toList() );
        Collections.sort( allTicketsIDsList );
        llenarTablaTickets( tablaBusqueda, allTicketsIDsList );
    }

    /** Manages searches for tickets that meet a certain specified criteria
     *
     * @param tablaBusqueda A given {@code JTable} object to be populated with
     *                      every ticket information that matches
     *
     * @param filter        A {@code Filters enum} constant specifiying the
     *                      search criteria to apply
     *
     * @since 1.6
     * @see model.Commons
     */
    public void buscarTicket ( JTable tablaBusqueda, Commons.Filters filter )
    {   // Buscar Ticket - Lista segun Filtro que se indique

        switch ( filter )
        {
            case Cedula ->
            {
                ArrayList<String> resultadosCedula = searchTicketByFilter( filter );

                if ( !resultadosCedula.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosCedula );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Precio ->
            {
                ArrayList<String> resultadosPrecio = searchTicketByFilter( filter );

                if ( !resultadosPrecio.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosPrecio );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Cedula_y_Precio ->
            {
                ArrayList<String> resultadosCedula = searchTicketByFilter( Commons.Filters.Cedula );
                ArrayList<String> resultadosPrecio = searchTicketByFilter( Commons.Filters.Precio );
                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosCedula, resultadosPrecio );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Edad ->
            {
                ArrayList<String> resultadosEdad = searchTicketByFilter( filter );

                if ( !resultadosEdad.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosEdad );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case GeneroCliente ->
            {
                ArrayList<String> resultadosGenero = searchTicketByFilter( filter );

                if ( !resultadosGenero.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosGenero );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Edad_y_Genero ->
            {
                ArrayList<String> resultadosEdad = searchTicketByFilter( Commons.Filters.Edad );
                ArrayList<String> resultadosGenero = searchTicketByFilter( Commons.Filters.GeneroCliente );
                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosEdad, resultadosGenero );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case NombrePelicula ->
            {
                ArrayList<String> resultadosNombrePelicula = searchTicketByFilter( filter );

                if ( !resultadosNombrePelicula.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosNombrePelicula );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case GeneroPelicula ->
            {
                ArrayList<String> resultadosGeneroPelicula = searchTicketByFilter( filter );

                if ( !resultadosGeneroPelicula.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosGeneroPelicula );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case IdiomaPelicula ->
            {
                ArrayList<String> resultadosIdiomaPelicula = searchTicketByFilter( filter );

                if ( !resultadosIdiomaPelicula.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosIdiomaPelicula );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case SubtitulosPelicula ->
            {
                ArrayList<String> resultadosSubPelicula = searchTicketByFilter( filter );

                if ( !resultadosSubPelicula.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, resultadosSubPelicula );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Gen_e_Idiom_Pelicula ->
            {
                ArrayList<String> resultadosMovieGen = searchTicketByFilter( Commons.Filters.GeneroPelicula );
                ArrayList<String> resultadosMovieLang = searchTicketByFilter( Commons.Filters.IdiomaPelicula );
                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosMovieGen, resultadosMovieLang );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Gen_y_Sub_Pelicula ->
            {
                ArrayList<String> resultadosMovieGen = searchTicketByFilter( Commons.Filters.GeneroPelicula );
                ArrayList<String> resultadosMovieSub = searchTicketByFilter( Commons.Filters.SubtitulosPelicula );
                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosMovieGen, resultadosMovieSub );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Idiom_y_Sub_Pelicula ->
            {
                ArrayList<String> resultadosMovieLang = searchTicketByFilter( Commons.Filters.IdiomaPelicula );
                ArrayList<String> resultadosMovieSub = searchTicketByFilter( Commons.Filters.SubtitulosPelicula );
                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosMovieLang, resultadosMovieSub );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

            case Gen_Idiom_Sub_Pelicula ->
            {
                ArrayList<String> resultadosMovieGen = searchTicketByFilter( Commons.Filters.GeneroPelicula );
                ArrayList<String> resultadosMovieLang = searchTicketByFilter( Commons.Filters.IdiomaPelicula );
                ArrayList<String> resultadosMovieSub = searchTicketByFilter( Commons.Filters.SubtitulosPelicula );

                ArrayList<String> commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( resultadosMovieGen, resultadosMovieLang );
                commonIDsFound = comparadorBusquedasCombinadasLlenarTabla( commonIDsFound, resultadosMovieSub );

                if ( !commonIDsFound.isEmpty() )
                {
                    llenarTablaTickets( tablaBusqueda, commonIDsFound );
                }
                else
                {
                    clearTable( tablaBusqueda );
                }
            }

        }
    }

    /** Method for all individual Searches for tickets that meet a certain
     * specified criteria. This method was implemented to enclosure all 
     * individual searches methods that were repeating their core loop, fixing a
     * nonsense repeating by avoiding boilerplate code and keeping atomicity 
     * principle.
     *
     * @param filter a given {@code Filters} enum constant value indicating the
     *               criteria to search for
     *
     * @return A {@code ArrayList<String>} collection with matching found
     *         results
     *
     * @since 1.6
     *
     * @see model.Filters model.FilterValue
     */
    private ArrayList<String> searchTicketByFilter ( Commons.Filters filter )
    {
        ArrayList<String> resultingIDs = new ArrayList<>();
        LinkedList <String> resultingLinkedIDs = new LinkedList<>();

        tickets.forEach( ( id, ticketInList ) ->
        {
            if ( ticketInList != null )
            {
                switch ( filter )
                {
                    case Cedula ->
                    {
                        if ( ticketInList.getCliente().getCedula().startsWith( FilterValue.getCedulaSearching() ) )
                            resultingLinkedIDs.add( ticketInList.getId() );
                    }

                    case Precio ->
                    {
                        if ( ticketInList.getPrecio() >= FilterValue.getTicketPriceSearching() )
                            resultingLinkedIDs.add( id );
                    }

                    case Edad ->
                    {
                        switch ( FilterValue.getClientAgeCriteria() )
                        {
                            case Clientes_con ->
                            {
                                if ( ticketInList.getCliente().getEdad() == FilterValue.getClientAgeSearching() )
                                    resultingLinkedIDs.add( id );
                            }
                            case Clientes_mayores_de ->
                            {
                                if ( ticketInList.getCliente().getEdad() > FilterValue.getClientAgeSearching() )
                                    resultingLinkedIDs.add( id );
                            }
                            case Clientes_menores_de ->
                            {
                                if ( ticketInList.getCliente().getEdad() < FilterValue.getClientAgeSearching() )
                                    resultingLinkedIDs.add( id );
                            }
                        }
                    }

                    case GeneroCliente -> //Buscar Ticket para Modificarlo segun el GeneroCliente del Cliente
                    {
                        if ( ticketInList.getCliente().getGenero() == FilterValue.getClientGenderSearching() )
                            resultingLinkedIDs.add( id );
                    }

                    case NombrePelicula ->
                    {
                        if ( ticketInList.getPelicula().getNombre().equalsIgnoreCase( FilterValue.getMovieNameSearching() ) )
                            resultingLinkedIDs.add( id );
                    }

                    case GeneroPelicula ->
                    {
                        if ( ticketInList.getPelicula().getGenero() == FilterValue.getMovieGenreSearching() )
                            resultingLinkedIDs.add( id );
                    }

                    case IdiomaPelicula ->
                    {
                        if ( ticketInList.getPelicula().getIdioma().equalsIgnoreCase( FilterValue.getMovieLanguageSearching() ) )
                            resultingLinkedIDs.add( id );
                    }

                    case SubtitulosPelicula ->
                    {
                        if ( ticketInList.getPelicula().getIdiomaSubtitulos().equalsIgnoreCase( FilterValue.getMovieSubSearching() ) )
                            resultingLinkedIDs.add( id );
                    }

                    default ->
                    {
                    }
                }

            }
        } );

        resultingIDs.addAll( resultingLinkedIDs );
        return resultingIDs;
    }

    /** Compares in a general way a pair of collections between each other,
     * populating a given {@code JTable} object
     * with elements that are matching results in both collections
     *
     * @param resultados1   a given first {@code ArrayList<String>} collection
     *                      to be compared
     * @param resultados2   a given second {@code ArrayList<String>} collection
     *                      to be compared
     * @param tablaBusqueda a given {@code JTable} to be populated with matching
     *                      results
     */
    private ArrayList<String> comparadorBusquedasCombinadasLlenarTabla ( ArrayList<String> resultados1, ArrayList<String> resultados2 )
    {   // Listas Helper para generalizacion de procesos comparativos
        ArrayList<String> lista1;
        ArrayList<String> lista2;
        LinkedList<String> commonsLinkedFound = new LinkedList<>(); // Uso una LinkedList por motivos de optimización para agregar los elementos y componer la lista dado que es más rápido agregar elementos en una LinkedList que es un ArrayList, y de esta manera maxizar 
        ArrayList<String> commonsFound = new ArrayList<>();

        if ( resultados1.size() < resultados2.size() ) // Determinamos cual es la mas pequenia para recorrer esa ya que tenemos que determinar los que se repiten en las dos unicamente
        {
            lista1 = resultados1;
            lista2 = resultados2;
        }
        else
        {
            lista1 = resultados2;
            lista2 = resultados1;
        }
        // Nos interesan solo las claves que se repitan, dado que significa que esa cumple con ambos criterios de busqueda, y el ticket con esa clave va a ser el que mostremos, es decir el que se agregue a la lista de comunes encontrados.
        lista1.forEach( id ->
        {   // Usando el metodo lamba forEach, para variar y simplificar el proceso, ademas que se comprende mejor, si se conoce el funcionamiento, claro.
            if ( lista2.contains( id ) )
                commonsLinkedFound.add( id );
        } );

        commonsFound.addAll( commonsLinkedFound );
        return commonsFound;
    }

    /**
     * Populates the given Tickets {@code JTable} in search window with the
     * tickets full information following the specified
     * {@code ArrayList<String>} ticketsIDs collection, wheather this collection
     * comes from a search result, or if it just listing all existing tickets,
     * this is the method for fullfill the tickets table in search window.
     *
     * @param tablaTickets The given tickets {@code JTable} to be populated
     *
     * @param ticketsIDs   A given {@code ArrayList<String>} collection with all
     *                     the tickets ids to retrieve their actual ticket and
     *                     populate the table with its information
     *
     * @since 1.6
     */
    private void llenarTablaTickets ( JTable tablaTickets, ArrayList<String> ticketsIDs )
    {   // rowIndex: The actual row index in a JTable, it's used to specify where to put a new registry row on a table, the registry indicator number is rowIndex + 1.
        int rowIndex = 0;

        clearTable( tablaTickets );

        for ( String id : ticketsIDs )
        {
            llenarRegistroTablaBusqueda( tablaTickets, tickets.get( id ), rowIndex, TipoLlenarRegistro.AddRow );
            rowIndex++;
        }

        centerTableTickets( tablaTickets );
    }

    /** Populates only one registry on a given {@code JTable} object with the
     * information of the specified given ticket
     *
     * @param tablaBusqueda    A given {@code JTable} to be populated
     * @param ticketEncontrado A given {@code Ticket} object to populate the
     *                         table with its information
     * @param rowIndex         A given {@code int} number that represents the
     *                         actual row index in the {@code JTable} object
     * @param modo             A specified {@code TipoLlenarRegistro enum}
     *                         constant to determine if it is necesary to add a
     *                         new row, this when populating the tickets table 
     *                         with existing tickets at the search window 
     *                         opening, but when editing a ticket it is not 
     *                         needed to add a row, just to re-populate a 
     *                         certain row where the just edited ticket is, in 
     *                         order to update its information in the table
     */
    public void llenarRegistroTablaBusqueda ( JTable tablaBusqueda, Ticket ticketEncontrado, int rowIndex, TipoLlenarRegistro modo )
    {
        if ( modo.equals( TipoLlenarRegistro.AddRow ) )
        {
            tableModel = ( DefaultTableModel ) tablaBusqueda.getModel();
            tableModel.addRow( new Object[1] );
        }

        tablaBusqueda.setValueAt( rowIndex + 1, rowIndex, 0 );
        tablaBusqueda.setValueAt( ticketEncontrado.getId(), rowIndex, 1 );
        tablaBusqueda.setValueAt( ticketEncontrado.getPrecioFormatoMoneda(), rowIndex, 2 );
        tablaBusqueda.setValueAt( ticketEncontrado.getCliente().getNombreCliente(), rowIndex, 3 );
        tablaBusqueda.setValueAt( ticketEncontrado.getCliente().getCedula(), rowIndex, 4 );
        tablaBusqueda.setValueAt( ticketEncontrado.getCliente().getStrEdad(), rowIndex, 5 );
        tablaBusqueda.setValueAt( ticketEncontrado.getCliente().verGenero(), rowIndex, 6 );
        tablaBusqueda.setValueAt( ticketEncontrado.getPelicula().getNombre(), rowIndex, 7 );
        tablaBusqueda.setValueAt( AdmSettings.getLanguageBundle().getString( ticketEncontrado.getPelicula().getGenero().getLangKey() ), rowIndex, 8 );
        tablaBusqueda.setValueAt( ticketEncontrado.getPelicula().getIdioma(), rowIndex, 9 );
        tablaBusqueda.setValueAt( ticketEncontrado.getPelicula().getIdiomaSubtitulos(), rowIndex, 10 );
        tablaBusqueda.setValueAt( ticketEncontrado.getPelicula().obtenerDuracionFormateada(), rowIndex, 11 );
        tablaBusqueda.setValueAt( ticketEncontrado.getFuncion().getEstrenoHabitual(), rowIndex, 12 );
        tablaBusqueda.setValueAt( ticketEncontrado.getSala().getNombre(), rowIndex, 13 );
        tablaBusqueda.setValueAt( ticketEncontrado.getSala().getNumeroSala(), rowIndex, 14 );
        tablaBusqueda.setValueAt( ticketEncontrado.getSala().getTipoSala(), rowIndex, 15 );
        tablaBusqueda.setValueAt( ticketEncontrado.getSala().getAsiento(), rowIndex, 16 );
        tablaBusqueda.setValueAt( ticketEncontrado.getFuncion().getTipoFuncion().toString(), rowIndex, 17 );
        tablaBusqueda.setValueAt( ticketEncontrado.getFuncion().getHorarioElegido(), rowIndex, 18 );
    }

    /**
     * Centers the content of the specified Tickets {@code JTable} in search
     * window and also distribute it in right proportions its columns. This 
     * method was moved to this class in version 1.6, but it existed since the 
     * release of version 1.5
     *
     * @param ticketsTable The tickets {@code JTable} to be centered
     *
     */
    private void centerTableTickets ( JTable ticketsTable )
    {   // TB: Tabla Busqueda
        common.centerTableColumns( ticketsTable );
        DefaultTableColumnModel columnModelTB = ( DefaultTableColumnModel ) ticketsTable.getColumnModel();

        columnModelTB.getColumn( 0 ).setPreferredWidth( 20 );
        columnModelTB.getColumn( 1 ).setPreferredWidth( 215 );
        columnModelTB.getColumn( 2 ).setPreferredWidth( 40 );
        columnModelTB.getColumn( 3 ).setPreferredWidth( 150 );
        columnModelTB.getColumn( 4 ).setPreferredWidth( 85 );
        columnModelTB.getColumn( 5 ).setPreferredWidth( 50 );
        columnModelTB.getColumn( 6 ).setPreferredWidth( 75 );
        columnModelTB.getColumn( 7 ).setPreferredWidth( 160 );
        columnModelTB.getColumn( 8 ).setPreferredWidth( 75 );
        columnModelTB.getColumn( 9 ).setPreferredWidth( 50 );
        columnModelTB.getColumn( 10 ).setPreferredWidth( 60 );
        columnModelTB.getColumn( 11 ).setPreferredWidth( 50 );
        columnModelTB.getColumn( 12 ).setPreferredWidth( 60 );
        columnModelTB.getColumn( 13 ).setPreferredWidth( 85 );
        columnModelTB.getColumn( 14 ).setPreferredWidth( 50 );
        columnModelTB.getColumn( 15 ).setPreferredWidth( 60 );
        columnModelTB.getColumn( 16 ).setPreferredWidth( 50 );
        columnModelTB.getColumn( 17 ).setPreferredWidth( 75 );
        columnModelTB.getColumn( 18 ).setPreferredWidth( 75 );
    }

    /**
     * Clears the content of the specified {@code JTable}
     *
     * @param ticketsTable The {@code JTable} to be cleared
     *
     * @since 1.6
     */
    private void clearTable ( JTable ticketsTable )
    {   // Metodo en el que eliminamos todos los elementos de la Tabla, segï¿½n se requiera, comunmente para volver a llenarla con los registros que coincidan con el criterio de busqueda
        tableModel = ( DefaultTableModel ) ticketsTable.getModel();

        if ( tableModel.getRowCount() > 0 )
            tableModel.setRowCount( 0 );
    }

    /** Verifies if exist created tickets that have not been saved in a Cinema
     * Tickets file and sugests to save them.
     * 
     * @return {@code true} if there is at least one ticket (or more) that has
     * not been saved yet, a suggestion to save is shown, the user takes the 
     * suggestion and decides to save.
     * <p>
     * {@code false} for the following reasons:
     * <pre>
     *   - There are tickets pending to save but when the suggestion to save is
     *     shown, the user decides not to save.
     *   - There is nothing to save because there are not tickets created, so 
     *     the tickets main collection {@code size} method returns 0.
     *   - There is nothing pending to save because the current tickets have 
     *     already been saved in a Cinema Tickets file.
     * </pre>
     */
    public boolean guardianDelGuardado ()
    {
        boolean faltabaGuardarDecideGuardar = false; // Devuelve false si No habia nada que guardar ya sea porque no se han generado tickets aun o porque ya se guardo y devuelve True si es que si habia que guardar y el usuario decide guardar.

        if ( !tickets.isEmpty() && !isSaved() )
        {   // Advertencia para Guardar
            if ( JOptionPane.showConfirmDialog( null, AdmSettings.getLanguageBundle().getString( "lk_save_tickets_not_saved_msj" ) + "\n" + AdmSettings.getLanguageBundle().getString( "lk_save_tickets_not_saved_confirmation" ), AdmSettings.getLanguageBundle().getString( "lk_save_tickets_not_saved_title" ), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION )
            {
                guardar();
                faltabaGuardarDecideGuardar = true;
            }
        }

        return faltabaGuardarDecideGuardar;
    }

    /** Saves the main tickets collection tickets in a Cinema Tickets file by
     * calling the {@code saveTicketsFile} manager method in 
     * {@code DatosTickets} class
     * @see data.DatosTickets
     */
    public void guardar ()
    {
        datosTickets.saveTicketsFile( tickets );
        if ( DatosTickets.getResult() == DatosTickets.OperationResult.Operacion_Exitosa )
            saved = true;
    }

    /** Saves the current user settings if is there anything to save, this is if
     * at least one setting (or more) has been changed by user
     *
     * @see data.DatosTickets
     */
    public void saveSettings ()
    {
        datosTickets.userSettingsSaver();
    }

    // Getters and Setters
    /** Gets the temporary client used in a ticket creation proccess
     * @return The Temporary Ready {@code Cliente} client object
     */
    public Cliente getTempReadyClient ()
    {
        return tempReadyClient;
    }
    /** Sets the temporary client used in a ticket creation proccess
     * @param tempReadyClient A {@code Cliente} temporary object
     */
    public void setTempReadyClient ( Cliente tempReadyClient )
    {
        this.tempReadyClient = tempReadyClient;
    }
    /** Gets The temporary movie used in a ticket creation proccess
     * @return The Temporary Ready {@code Pelicula} movie object
     * @since 1.5
     */
    public Pelicula getTempReadyPelicula ()
    {
        return tempReadyPelicula;
    }
    /** Gets The temporary show used in a ticket creation proccess
     * @return The Temporary Ready {@code Funcion} show object
     */
    public Funcion getTempReadyFuncion ()
    {
        return tempReadyFuncion;
    }
    /** Gets The temporary theater used in a ticket creation proccess
     * @return The Temporary Ready {@code Sala} theater object
     */
    public Sala getTempReadySala ()
    {
        return tempReadySala;
    }
    /** Sets the ticket helper used in a ticket creation proccess
     * @param ticket A {@code Ticket} helper ticket object
     */
    public void setTicket ( Ticket ticket )
    {
        this.ticket = ticket;
    }
    /** Gets the ticket helper used in a ticket creation proccess
     * @return The {@code Ticket} helper ticket object
     */
    public Ticket getTicket ()
    {
        return ticket;
    }
    /** Gets the generated tickets count
     * @return The Generated Tickets {@code int} indicator
     */
    public int getTicketsGenerados ()
    {
        return ticketsGenerados;
    }
    /** Gets the successfully generation tickets indicator
     * @return {@code true} if the ticket generation was successful, {@code false} 
     * otherwise
     */
    public boolean isTicketGeneradoExitosamente ()
    {
        return ticketGeneradoExitosamente;
    }
    /** Sets the successfully generation tickets indicator
     * @param ticketGeneradoExitosamente {@code true} if a ticket was 
     *                                   successfully generated, {@code false} 
     *                                   otherwise
     */
    public void setTicketGeneradoExitosamente ( boolean ticketGeneradoExitosamente )
    {
        this.ticketGeneradoExitosamente = ticketGeneradoExitosamente;
    }
    /** Gets the saved indicator
     * @return {@code true} if the current tickets list have been saved, 
     * {@code false} otherwise
     */
    public boolean isSaved ()
    {
        return saved;
    }
    /** Sets the current tickets list saved state
     * @param saved A {@code boolean} argument that indicates if the current 
     * tickets list are saved
     */
    public void setSaved ( boolean saved )
    {
        this.saved = saved;
    }
    /** Gets the tickets main collection
     * @return The {@code HashMap<String, Ticket>} main collection object
     */
    public HashMap<String, Ticket> getTickets ()
    {
        return tickets;
    }
    /** Sets the tickets main collection
     * @param tickets A {@code HashMap<String, Ticket>} collection object
     */
    public void setTickets ( HashMap<String, Ticket> tickets )
    {
        this.tickets = tickets;
    }
    /** Gets the Client Administration Class
     * @return The {@code AdmCliente} unique instance object, given its 
     * singleton pattern
     */
    public AdmCliente getAdmCliente ()
    {
        return admCliente;
    }
    /** Gets the Movie Administration Class
     * @return The {@code AdmPelicula} unique instance object, given its 
     * singleton pattern
     */
    public AdmPelicula getAdmPelicula ()
    {
        return admPelicula;
    }
    /** Gets the Theater Administration Class
     * @return The {@code AdmSala} unique instance object, given its 
     * singleton pattern
     */
    public AdmSala getAdmSala ()
    {
        return admSala;
    }
    /** Gets the Commonly used objects Class instance objects declared in this 
     * class
     * @return The {@code Commons} unique instance object, given its 
     * singleton pattern
     */
    public Commons getCommon ()
    {
        return common;
    }
    /** Gets the Application Data Administration Class
     * @return The {@code DatosTickets} unique instance object, given its 
     * singleton pattern
     */
    public DatosTickets getDatosTickets ()
    {
        return datosTickets;
    }

}
