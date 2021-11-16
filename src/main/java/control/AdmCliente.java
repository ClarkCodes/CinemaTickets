package control;
// Imports
import java.util.HashMap;
import java.util.ArrayList;
import model.Cliente;
import java.util.Random;

/** Client Mamagement Class, hosts tasks and important things related to it.
 * @author Clark
 * @since 1.0
 */
public class AdmCliente
{   // Attribs - Fields
    private HashMap<String, Cliente> clientes = null; // Clients Main HashMap Collection where client objects are meant to be
    private ArrayList<String> clientIds = null;
    
    private static AdmCliente adm = null; 
    
    /** Sole Constructor which loads the {@code AdmCliente} unique instance following Singleton Design Pattern */
    private AdmCliente()
    {
        this.clientes = new HashMap<>();
        this.clientIds = new ArrayList<>();
        initClients();
    }
    
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code AdmCliente} instance
     */
    public static AdmCliente getAdm()
    {   // An instance of this class is created, but if there is already one created, that one is returned, keeping always only one instance, following Sinlgeton Pattern
        if(adm == null)
            adm = new AdmCliente();
        return adm;
    }
    
    /** Initializes 10 predefined clients for stored mode */
    private void initClients()
    {   // Clients Objects Initialization
        Cliente tempClient = new Cliente("0901234567", "Juan Ramiro Gonzales Gurumendi", 21, 'M');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0931234567", "Maria Antonieta de las Rosas Jimenes", 18, 'F');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0931234567", "Jose Antonio Calicuchi Caicedo", 35, 'M');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0931234567", "Lara-El", 54, 'F');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0931234567", "Jor-El", 55, 'M');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0951234567", "Kara Zor-El", 21, 'F');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0951234567", "Chloe Alexa Decker Silvers", 14, 'F');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0981234567", "Clark Joseph Kal-El Kent", 30, 'M');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0981234567", "Michael Angelo Batio", 45, 'M');
        clientes.put(tempClient.getCedula(), tempClient);
        tempClient = new Cliente("0981234567", "Sara Avendanio", 17, 'F');
        clientes.put(tempClient.getCedula(), tempClient);
        
        clientes.entrySet().forEach(c ->
        {
            clientIds.add((String)c.getKey());
        });
    }
    
    /** Generates a new Client Object from a list of 10 predefined clients with 4 attributes:
     * <p>- {@code cedula}: The Client/Person ID (Numero de Cedula)
     * <p>- {@code nombreCliente}: Client's name
     * <p>- {@code edad}: Client's Age
     * <p>- {@code genero}: Client's gender either male or female (as a char 'M' or 'F')
     * @return An existent Client Object with its 4 attributes
     * @see model.Cliente
     */
    public Cliente generarCliente()
    {   // Se que resulta complicado de leer, pero me resulto interesante hiper-anonimizar este metodo en una sola linea
        return clientes.get(clientIds.get((new Random()).nextInt(clientIds.size())));
    }
}