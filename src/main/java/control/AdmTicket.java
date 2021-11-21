package control;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import data.DatosTickets;
import java.util.ArrayList;
import model.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/** Main Management/Controller Class where the most important core methods are stored
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class AdmTicket
{   // Atributos - Propiedades
    private HashMap<String, Ticket> tickets = null; // Coleccion HashMap Principal donde estaran almacenados los registros primordiales como objetos, en este caso de Tickets.
    private Ticket ticket = null; // Objeto Ticket declarado pero no inicializado(por eso es null o nulo) para luego si hacerlo y guardarlo como elemento en el HashMap tickets cada vez que quiera agregar un elemento.
    private int ticketsGenerados = 0; // Cantidad de Tickets Generados para controlar el numero de ticket.
    private boolean ticketGeneradoExitosamente = false;
    private boolean saved = false;
    
    // Adms
    public AdmCliente admCliente;
    public AdmPelicula admPelicula;
    public AdmSala admSala;
    private final CommonlyUsedObjects common;
    
    // Clase Datos
    public DatosTickets datosTickets;
    
    // Objetos Temporales preparandolos para el Ticket
    private Cliente tempReadyClient = null;
    private Pelicula tempReadyPelicula = null;
    private Funcion tempReadyFuncion = null;
    private Sala tempReadySala = null;
    
    // Precio
    private double tempReadyPrecio = 0.0;
    
    private AdmTicket() // Constructor por defecto puesto como privado, el cuï¿½l inicializa la colecciï¿½n HashMap.
    {
        this.tickets = new HashMap<>();
        this.common = CommonlyUsedObjects.getAdm();
        this.admCliente = AdmCliente.getAdm();
        this.admPelicula = AdmPelicula.getAdm();
        this.admSala = AdmSala.getAdm();
        this.datosTickets = DatosTickets.getDatosTickets();
        this.datosTickets.defaultSettingsVerifier();
        this.datosTickets.userSettingsVerifier();
        this.datosTickets.userSettingsLoader();
    }
    private static AdmTicket adm = null; // Objeto estatico de esta misma clase declarado pero no inicializado, preparandolo para el patron Singleton.
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code AdmTicket} instance
     */
    public static AdmTicket getAdm() // Metodo estatico y publico de esta clase que devuelve la instancia unica de esta clase, si reciï¿½n se abre la aplicaciï¿½n y reciï¿½n se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fue creada se devuelve la que ya estï¿½, manteniendo una ï¿½nica instancia siempre.
        if(adm == null)
            adm = new AdmTicket();
        return adm;
    }
    
    /** Puts a just created {@code Ticket} object in the main tickets collection */
    public void generarTicket() // Metodo Nucleo en el que se guarda el Ticket en el HashMap Principal
    {
        aumentarTicketsGenerados(1);
        tickets.put(getTicket().getId(), getTicket());
    }
    
    /** Updates an existing specified {@code Ticket} object with the modifications a user does on it, 
     * replacing the current object in collection with a one with modified information
     * @param keyToModifyReplace the {@code String} ticket key to specify to the collectin which one is being replaced
     */
    public void actualizarTicket(String keyToModifyReplace)
    {
        tickets.replace(keyToModifyReplace, ticket);
        setTicketGeneradoExitosamente(true);
    }
    
    /** Deletes an existing specified {@code Ticket} object from the main tickets collection
     * @param keyToRemove the {@code String} ticket key to specify to the collectin which one is being deleted
     */
    public void eliminarTicket(String keyToRemove)
    {
        tickets.remove(keyToRemove); // Elimino el Ticket del HashMap
    }
    
    /** Increments the generated tickets count on a given integer parameter
     * @param adicionExtra The amount that is going to be added
     */
    public void aumentarTicketsGenerados(int adicionExtra)
    {
        this.ticketsGenerados += adicionExtra;
    }
    
    /** Prepares a generated existing client {@code Cliente} object to be ready to be included as part of a new {@code Ticket} instance when generating a Ticket */
    public void prepararCliente()
    {
        tempReadyClient = admCliente.generarCliente();
    }
    
    /** Prepares a selected existing movie {@code Pelicula} object to be ready to be included as part of a new {@code Ticket} instance when generating a Ticket 
     * @param nombrePelicula Movie name to get the specified exitsting corresponding movie {@code Pelicula} object
     * @param tablaPelicula {@code JTable} object where information of selected movie would be shown
     * @param comboHorariosDisponibles {@code JComboBox} object where the available schedule times for the selected movie are going to be loaded
     */
    public void prepararPelicula(String nombrePelicula, JTable tablaPelicula, JComboBox comboHorariosDisponibles)
    {
        tempReadyPelicula = admPelicula.obtenerPelicula(nombrePelicula);
        admPelicula.llenarTablaPeliculaElegida(tempReadyPelicula.getId(), tablaPelicula, comboHorariosDisponibles);
    }
    
    /** Prepares a selected existing theater hall {@code Sala} object to be ready to be included as part of a new {@code Ticket} instance when generating a Ticket 
     * @param nombreSala Theater Hall name to get the specified exitsting corresponding theater hall {@code Sala} object
     * @param tablaSala {@code JTable} object where information of selected theater hall would be shown
     */
    public void prepararSala(String nombreSala, JTable tablaSala)
    {
        tempReadySala = admSala.obtenerSala(nombreSala);
        admSala.llenarTablaSalaElegida(tempReadySala.getId(), tablaSala);
    }
    
    /** Prepares a selected existing movie function {@code Funcion} object to be ready to be included as part of a new {@code Ticket} instance when generating a Ticket 
     * @param horarioElegido chosen movie schedule time by user
     * @param nombrePelicula movie name this function is related
     * @param funcionElegida {@code JTable} object where information of this movie fuction would be shown
     */
    public void prepararFuncion(String horarioElegido, String nombrePelicula, JTable funcionElegida)
    {
        tempReadyFuncion = admPelicula.obtenerFuncion(horarioElegido, nombrePelicula);
        llenarTablaFuncionElegida(funcionElegida); 
    }
    
    /** Prepares a ticket to be added to the main tickets collection depending on a given {@code TipoAccion} indicator.
     * <p>
     * On creation a new {@code Ticket} instance object is created and populated with the objects which contains the 
     * selected options by user in ticket generation window.
     * On update/modification the {@code elementosCine} collection in the current {@code Ticket} object is cleared to be populated with posibly
     * modified versions, the current chosen client is set on the ticket and the ticket price is recalculated with this posibly new information in the ticket.
     * @param formaProceder A {@code TipoAccion} enum constant indicator to determine what way to go: creation or modification
     * @see model.TipoAccion model.Ticket
     */
    public void prepararTicket(TipoAccion formaProceder)
    {
        switch(formaProceder)
        {
            case Creacion ->
            {   // Se crea y se prepara la Instancia de Ticket lista para agregarla al HashMap Principal
                String codigoTicket = "T-" + tempReadySala.getId() + tempReadyFuncion.getId();
                setTicket(new Ticket());
                getTicket().setId(codigoTicket);
                getTicket().setNombre("Ticket - Entrada de Cine");
                getTicket().setNumeroTicket(getTicketsGenerados() + 1);
            }
                
            case Modificacion -> ticket.getElementosCine().clear();
        }
            
            getTicket().setCliente(tempReadyClient);
            getTicket().getElementosCine().put(tempReadyPelicula.getId(), tempReadyPelicula);
            getTicket().getElementosCine().put(tempReadySala.getId(), tempReadySala);
            getTicket().getElementosCine().put(tempReadyFuncion.getId(), tempReadyFuncion);    
            getTicket().generarPrecio();
    }
    
    /** Populates a given {@code JTable} object with a specified client information
     * @param tablaCliente a given {@code JTable} object to be populated
     * @param cliente object to populate the table with its information
     */
    public void llenarTablaCliente(JTable tablaCliente, Cliente cliente)
    {   
        DefaultTableModel modeloCO = (DefaultTableModel) tablaCliente.getModel();
        DefaultTableColumnModel columnModelCO = (DefaultTableColumnModel) tablaCliente.getColumnModel();
        
        if(tablaCliente.getRowCount() == 0)
        {
            modeloCO.addRow(new Object[1]);
            common.centerTableColumns(tablaCliente); // Centers information in table            
            columnModelCO.getColumn(0).setPreferredWidth(56);
            columnModelCO.getColumn(1).setPreferredWidth(194);
            columnModelCO.getColumn(2).setPreferredWidth(10);
            columnModelCO.getColumn(3).setPreferredWidth(40);
        }
        
        tablaCliente.setValueAt(cliente.getCedula(), 0, 0);
        tablaCliente.setValueAt(cliente.getNombreCliente(), 0, 1);
        tablaCliente.setValueAt(cliente.getStrEdad(), 0, 2);
        tablaCliente.setValueAt(cliente.verGenero(), 0, 3);
    }
    
    /** Populates a given {@code JTable} object with a specified movie function information
     * @param tablaCliente a given {@code JTable} object to be populated
     */
    private void llenarTablaFuncionElegida(JTable funcionElegida)
    {
        DefaultTableModel modelFE = (DefaultTableModel) funcionElegida.getModel();
        
        if(funcionElegida.getRowCount() == 0)
        {
            modelFE.addRow(new Object[1]);
            common.centerTableColumns(funcionElegida);
        }
        
        funcionElegida.setValueAt(tempReadyFuncion.getId(), 0, 0);
        funcionElegida.setValueAt(tempReadyFuncion.getNombre(), 0, 1);
        funcionElegida.setValueAt(tempReadyFuncion.getEstrenoHabitual(), 0, 2);
    }

    /** Lists all the existing tickets in main tickets collection on a given {@code JTable} object
     * @param tablaBusqueda a given {@code JTable} object to be populated with every ticket information
     */
    public void buscarTicket(JTable tablaBusqueda) // Buscar Ticket - Lista Todos
    {   
        DefaultTableModel busquedaTodosModel = (DefaultTableModel) tablaBusqueda.getModel();
        busquedaTodosModel.setRowCount(0);
        
        int n = 1, fila = 0;
        
        for(Map.Entry<String, Ticket> t : tickets.entrySet())
        {
            llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)t.getValue(), n, fila);
            n++;
            fila++;
        }
    }
    
    /** Manages searches for tickets that meet a certain specified criteria related with cedula id and ticket price
     * @param tablaBusqueda a given {@code JTable} object to be populated with every ticket information
     * @param cedulaTicket a given {@code String} cedula (client's id) for cedula searches
     * @param precio a {@code double} ticket price for price searches
     * @param tipoBusqueda a {@code TipoFiltroSoloBusqueda} enum constant specifiying the search type to perform
     * @see model.TipoFiltroSoloBusqueda
     */
    public void buscarTicket(JTable tablaBusqueda, String cedulaTicket, double precio, TipoFiltroSoloBusqueda tipoBusqueda)
    {   // Buscar Ticket - Lista segun Id del Ticket o Cedula del Cliente
        DefaultTableModel busquedaCedulaModel = (DefaultTableModel) tablaBusqueda.getModel();
        busquedaCedulaModel.setRowCount(0); // Eliminamos todos los elementos de la Tabla para volver a llenarla con los registros que coincidan con el criterio de busqueda
        
        ArrayList<String> resultadosCedula;
        ArrayList<String> resultadosPrecio;
        int n = 1, fila = 0;
        
        switch(tipoBusqueda)
        {
            case Cedula ->
            {
                resultadosCedula = buscarPorCedula(cedulaTicket);
                
                for(int i = 0; i < resultadosCedula.size(); i++)
                {
                    llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)tickets.get(resultadosCedula.get(i)), n, fila);
                    n++;
                    fila++;
                }
            }
                
            case Precio ->
            {
                resultadosPrecio = buscarPorPrecio(precio);
                
                for(int i = 0; i < resultadosPrecio.size(); i++)
                {
                    llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)tickets.get(resultadosPrecio.get(i)), n, fila);
                    n++;
                    fila++;
                }
            }
                        
            case Cedula_y_Precio ->
            {
                resultadosCedula = buscarPorCedula(cedulaTicket);
                resultadosPrecio = buscarPorPrecio(precio);
                comparadorBusquedasCombinadasLlenarTabla(resultadosCedula, resultadosPrecio, tablaBusqueda);
            }
        }
    }
    
    /** Searches for tickets that meet a certain specified ID criteria
     * @param cedulaBuscada a given {@code String} client cedula id to be searched
     * @return A {@code ArrayList<String>} collection with matching found results
     */
    private ArrayList<String> buscarPorCedula(String cedulaBuscada)
    {
        ArrayList<String> resultadosCedula = new ArrayList<>();
        Ticket ticketBC;
        
        for(Map.Entry<String, Ticket> t : tickets.entrySet())
        {
            if(t != null)
            {
                ticketBC = t.getValue();
                
                if(ticketBC.getCliente().getCedula().startsWith(cedulaBuscada))
                    resultadosCedula.add(ticketBC.getId());
            }
        }
        
        return resultadosCedula;
    }
    
    /** Searches for tickets that meet a certain specified price criteria
     * @param precioBuscado a given {@code String} ticket price to be searched
     * @return A {@code ArrayList<String>} collection with matching found results
     */
    private ArrayList<String> buscarPorPrecio(double precioBuscado)
    {
        ArrayList<String> resultadosPrecio = new ArrayList<>();
        Ticket ticketBP;
        
        for(Map.Entry t : tickets.entrySet())
        {
            if(t != null)
            {
                ticketBP = (Ticket)t.getValue();
                
                if(ticketBP.getPrecio() >= precioBuscado)
                    resultadosPrecio.add(ticketBP.getId());
            }
        }
        
        return resultadosPrecio;
    }
    
    /** Manages searches for tickets that meet a certain specified price criteria related with client's age and gender
     * @param tablaBusqueda a given {@code JTable} object to be populated with search match found results
     * @param edadBuscada clients age
     * @param edadCriteria the age search sub-criteria selected by user
     * @param generoBuscado the searched client's gender
     * @param tipoEG a {@code TipoFiltroEdadGenero} enum constant that indicates the search type to perform
     * @see model.TipoFiltroEdadGenero
     */
    public void buscarTicket(JTable tablaBusqueda, int edadBuscada, String edadCriteria, String generoBuscado, TipoFiltroEdadGenero tipoEG)
    {   // Buscar Ticket - Lista por Edad y/o Genero
        DefaultTableModel busquedaModel = (DefaultTableModel) tablaBusqueda.getModel();
        busquedaModel.setRowCount(0); // Eliminamos todos los elementos de la Tabla para volver a llenarla con los registros que coincidan con el criterio de busqueda
        
        ArrayList<String> resultadosEdad;
        ArrayList<String> resultadosGenero;
        
        int n = 1, fila = 0; // Indice e indicador para mandar a la construccion del registro en la tabla
        
        switch(tipoEG)
        {
            case Edad ->
            {
                resultadosEdad = buscarTicketPorEdad(edadBuscada, edadCriteria);
                
                for(int i = 0; i < resultadosEdad.size(); i++)
                {
                    llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)tickets.get(resultadosEdad.get(i)), n, fila);
                    n++;
                    fila++;
                }
            }
                
            case Genero ->
            {
                resultadosGenero = buscarTicketPorGenero(generoBuscado);
                
                for(int i = 0; i < resultadosGenero.size(); i++)
                {
                    llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)tickets.get(resultadosGenero.get(i)), n, fila);
                    n++;
                    fila++;
                }
            }
                
            case Edad_y_Genero ->
            {
                resultadosEdad = buscarTicketPorEdad(edadBuscada, edadCriteria);
                resultadosGenero = buscarTicketPorGenero(generoBuscado);
                comparadorBusquedasCombinadasLlenarTabla(resultadosEdad, resultadosGenero, tablaBusqueda);
            }
        }
    }
    
    /** Searches for tickets that meet a certain specified client's age criteria
     * @param edadBuscada a given {@code int} client's age to search
     * @param edadCriteria a given {@code String} age sub-criteria perform one way or another
     * @return A {@code ArrayList<String>} collection with matching found results
     */
    public ArrayList<String> buscarTicketPorEdad(int edadBuscada, String edadCriteria)
    {   //Buscar Ticket para Modificarlo segun la edad del Cliente
        ArrayList<String> resultadosEdad = new ArrayList<>();
        
        for(Map.Entry t : tickets.entrySet())
        {
            if(t != null)
            {
                Ticket ticketFE = (Ticket)t.getValue();
                switch(edadCriteria)
                {
                    case "Clientes con..." ->
                    {
                        if(ticketFE.getCliente().getEdad() == edadBuscada)
                            resultadosEdad.add(ticketFE.getId());
                    }
                    case "Clientes mayores de..." ->
                    {
                        if(ticketFE.getCliente().getEdad() > edadBuscada)
                            resultadosEdad.add(ticketFE.getId());
                    }
                    case "Clientes menores de..." ->
                    {
                        if(ticketFE.getCliente().getEdad() < edadBuscada)
                            resultadosEdad.add(ticketFE.getId());
                    }
                }
            }
        }
        
        return resultadosEdad;
    }
    
    /** Searches for tickets that meet a certain specified client's gender criteria
     * @param generoBuscado a given {@code String} client's gender to search
     * @return A {@code ArrayList<String>} collection with matching found results
     */
    public ArrayList<String> buscarTicketPorGenero(String generoBuscado)
    {   //Buscar Ticket para Modificarlo segun el Genero del Cliente
        char generoSearched = generoBuscado.charAt(0);
        ArrayList<String> resultadosGenero = new ArrayList<>();
        
        for(Map.Entry t : tickets.entrySet())
        {
            if(t != null)
            {
                Ticket ticketFE = (Ticket)t.getValue();
                if(ticketFE.getCliente().getGenero() == generoSearched)
                    resultadosGenero.add(ticketFE.getId());
            }
        }
        
        return resultadosGenero;
    }
    
    /** Compares in a general way a pair of collections between each other, populating a given {@code JTable} object 
     * with elements that are matching results in both collections
     * @param resultados1 a given first {@code ArrayList<String>} collection to be compared
     * @param resultados2 a given second {@code ArrayList<String>} collection to be compared
     * @param tablaBusqueda a given {@code JTable} to be populated with matching results
     */
    private void comparadorBusquedasCombinadasLlenarTabla(ArrayList<String> resultados1, ArrayList<String> resultados2, JTable tablaBusqueda)
    {   // Listas Helper para generalizacion de procesos comparativos
        ArrayList<String> lista1;
        ArrayList<String> lista2;
        
        int n = 1, fila = 0; // Indicador e Indice
                
        if(resultados1.size() < resultados2.size()) // Determinamos cual es la mas pequeï¿½a para recorrer esa
        {
            lista1 = resultados1;
            lista2 = resultados2;
        }
        else
        {
            lista1 = resultados2;
            lista2 = resultados1;
        }
                
        for(int i = 0; i < lista1.size(); i++) // Nos interesan solo las claves que se repitan, dado que significa que esa cumple con ambos criterios de busqueda, y el ticket con esa clave va a ser el que mostremos
        {
            if(lista2.contains(lista1.get(i)))
            {
                llenarRegistroTablaBusqueda(tablaBusqueda, (Ticket)tickets.get(lista1.get(i)), n, fila);
                n++;
                fila++;
            }
        }
    }
    
    /** Populates only one registry on a given {@code JTable} object with the information of the specified given ticket
     * @param tablaBusqueda A given {@code JTable} to be populated
     * @param ticketEncontrado A given {@code Ticket} object to populate the table with its information
     * @param n A given {@code int} number to put in the table as row counter index for user
     * @param fila A given {@code int} number that represents the actual index in the {@code JTable} object
     */
    public void llenarRegistroTablaBusqueda(JTable tablaBusqueda, Ticket ticketEncontrado, int n, int fila)
    {
        DefaultTableModel modelTB = (DefaultTableModel) tablaBusqueda.getModel();
        modelTB.addRow(new Object[1]);
        
        tablaBusqueda.setValueAt(n, fila, 0);
        tablaBusqueda.setValueAt(ticketEncontrado.getId(), fila, 1);
        tablaBusqueda.setValueAt(ticketEncontrado.getPrecioFormatoMoneda(), fila, 2);
        tablaBusqueda.setValueAt(ticketEncontrado.getCliente().getNombreCliente(), fila, 3);
        tablaBusqueda.setValueAt(ticketEncontrado.getCliente().getCedula(), fila, 4);
        tablaBusqueda.setValueAt(ticketEncontrado.getCliente().getStrEdad(), fila, 5);
        tablaBusqueda.setValueAt(ticketEncontrado.getCliente().verGenero(), fila, 6);
        tablaBusqueda.setValueAt(ticketEncontrado.getPelicula().getNombre(), fila, 7);
        tablaBusqueda.setValueAt(ticketEncontrado.getPelicula().getGenero(), fila, 8);
        tablaBusqueda.setValueAt(ticketEncontrado.getPelicula().getIdioma(), fila, 9);
        tablaBusqueda.setValueAt(ticketEncontrado.getPelicula().getIdiomaSubtitulos(), fila, 10);
        tablaBusqueda.setValueAt(ticketEncontrado.getPelicula().obtenerDuracionFormateada(), fila, 11);
        tablaBusqueda.setValueAt(ticketEncontrado.getFuncion().getEstrenoHabitual(), fila, 12);
        tablaBusqueda.setValueAt(ticketEncontrado.getSala().getNombre(), fila, 13);
        tablaBusqueda.setValueAt(ticketEncontrado.getSala().getNumeroSala(), fila, 14);
        tablaBusqueda.setValueAt(ticketEncontrado.getSala().getTipoSala(), fila, 15);
        tablaBusqueda.setValueAt(ticketEncontrado.getSala().getAsiento(), fila, 16);
        tablaBusqueda.setValueAt(ticketEncontrado.getFuncion().getNombre(), fila, 17);
        tablaBusqueda.setValueAt(ticketEncontrado.getFuncion().getHorarioElegido(), fila, 18);
    }
    
    /** Verifies if exists created tickets that have not been saved in a Cinema Tickets file and sugests to save them.
     * <p>Returns {@code false} for the following reasons:
     * <pre>
     *   - There is nothing to save because there are not tickets created 
     *   - There is nothing to save because the current tickets have already been saved
     * </pre>
     * Returns {@code true} for the following reasons:
     * <pre>
     *   - There is at least one ticket (or more than one) that has not been saved yet
     *   - User takes suggestion and decides to save
     * </pre>
     * @return A boolean result {@code true} or {@code false} depending on the conditions mentioned before
     */
    public boolean guardianDelGuardado()
    {   
        boolean faltabaGuardarDecideGuardar = false; // Devuelve false si No había nada que guardar ya sea porque no se han generado tickets aun o porque ya se guardo y devuelve True si es que si había que guardar y el usuario decide guardar.
                
        if(tickets.size() > 0 && !isSaved())
        {   // Advertencia para Guardar
            if(JOptionPane.showConfirmDialog(null, "No ha guardado la lista de Tickets actuales, si abre otro archivo o sale de la aplicacion estos tickets se eliminaran y no se podran recuperar\n¿Desea guardarlos ahora?", "Tickets sin guardar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
            {    
                guardar();
                faltabaGuardarDecideGuardar = true;
            }
        }

        return faltabaGuardarDecideGuardar;
    }
    
    /** Saves the current tickets in main tickets collection in a Cinema Tickets file opening a {@code JFileChooser} 
     * for this task, calling the method in charge and using a certain way specified in the data class
     * @see data.DatosTickets
     */
    public void guardar()
    {
        datosTickets.guardarArchivoTicketsTexto(tickets);
        if(DatosTickets.getResult() == DatosTickets.OperationResult.Operacion_Exitosa)
            saved = true;
    }
    
    /** Saves the current user settings if is there anything to save, this is if at least one setting (or more) has been changed by user
     * @see data.DatosTickets
     */
    public void saveSettings()
    {
        datosTickets.userSettingsSaver();
    }
    
    // Getters and Setters
    
    public Cliente getTempReadyClient() {
        return tempReadyClient;
    }

    public Pelicula getTempReadyPelicula() {
        return tempReadyPelicula;
    }

    public Funcion getTempReadyFuncion() {
        return tempReadyFuncion;
    }

    public Sala getTempReadySala() {
        return tempReadySala;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getTicketsGenerados() {
        return ticketsGenerados;
    }

    public Ticket getTicket() {
        return ticket;
    }  

    public double getTempReadyPrecio() {
        return tempReadyPrecio;
    }

    public boolean isTicketGeneradoExitosamente() {
        return ticketGeneradoExitosamente;
    }

    public void setTicketGeneradoExitosamente(boolean ticketGeneradoExitosamente) {
        this.ticketGeneradoExitosamente = ticketGeneradoExitosamente;
    }

    public void setTempReadyClient(Cliente tempReadyClient) {
        this.tempReadyClient = tempReadyClient;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public HashMap<String, Ticket> getTickets()
    {
        return tickets;
    }

    public void setTickets(HashMap<String, Ticket> tickets)
    {
        this.tickets = tickets;
    }

    public AdmCliente getAdmCliente()
    {
        return admCliente;
    }

    public AdmPelicula getAdmPelicula()
    {
        return admPelicula;
    }

    public AdmSala getAdmSala()
    {
        return admSala;
    }

    public CommonlyUsedObjects getCommon()
    {
        return common;
    }

    public DatosTickets getDatosTickets()
    {
        return datosTickets;
    }
}
