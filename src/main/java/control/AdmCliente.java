
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JComboBox;
import model.Cliente;

/** Client Management Class, hosts tasks and important things related to it.
 *
 * @author Clark
 * @since 1.0
 */
public final class AdmCliente
{   // Attribs - Fields
    private HashMap<String, Cliente> clientes = null; // Clients Main HashMap Collection where client objects are meant to be
    private ArrayList<String> clientsIds = null;
    private Cliente tempClient = null;
    
    private static AdmCliente adm = null;
    
    /** Sole Constructor which loads the {@code AdmCliente} unique instance
     * following Singleton Design Pattern */
    private AdmCliente ()
    {
        this.clientes = new HashMap<>();
        this.clientsIds = new ArrayList<>();
        initClients();
    }

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code AdmCliente} instance
     */
    public static AdmCliente getAdm ()
    {   // An instance of this class is created, but if there is already one created, that one is returned, keeping always only one instance, following Sinlgeton Pattern
        if ( adm == null )
            adm = new AdmCliente();
        return adm;
    }

    /** Gets the temporary client helper object
     * 
     * @return A {@code Cliente} helper object that contain a manually 
     * registered client
     * 
     * @since 1.6
     */
    public Cliente getTempClient ()
    {
        return tempClient;
    }

    /** Initializes 10 predefined clients for stored mode
     * @see model.Cliente
     */
    private void initClients ()
    {   // Clients Objects Initialization
        registerClient( "0901234567", "Juan Ramiro Gonzales Gurumendi", 21, 'M' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0931234567", "Maria Antonieta de las Rosas Jimenes", 18, 'F' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0931234567", "Jose Antonio Calicuchi Caicedo", 35, 'M' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0931234567", "Lara-El", 54, 'F' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0931234567", "Jor-El", 55, 'M' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0951234567", "Kara Zor-El", 21, 'F' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0951234567", "Chloe Alexa Decker Silvers", 14, 'F' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0981234567", "Clark Joseph Kal-El Kent", 30, 'M' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0981234567", "Michael Angelo Batio", 45, 'M' );
        clientes.put( tempClient.getCedula(), tempClient );
        registerClient( "0981234567", "Sara Avendanio", 17, 'F' );
        clientes.put( tempClient.getCedula(), tempClient );

        LinkedList<String> keys = new LinkedList<>();
        clientes.keySet().forEach( k -> keys.add( k ) );
        clientsIds.addAll( keys );
    }
    
    /** Fills a given {@code JComboBox} object with the sorted predefined client
     * genders
     *
     * @param cmbGender The given {@code JComboBox} object to be filled
     * 
     * @param mode      The specified window mode to work, given this method is 
     *                  used to fill the client gender {@code JComboBox} in both
     *                  Search and Register Client windows, with the diference
     *                  that in the first one it has to add the All word at the
     *                  beginning, so this parameter is used to determine that 
     *                  difference and do what corresponds adding that word when
     *                  needed
     * 
     * @since 1.6
     */
    public void fillGenders ( JComboBox cmbGender, Commons.WindowMode mode )
    {   
        if ( mode.equals( Commons.WindowMode.Busqueda ) )
            cmbGender.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_all" ) );

        cmbGender.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_female" ) );
        cmbGender.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_male" ) );
    }
    
    /** Fills a {@code JComboBox} object with the client age searching criterias
     * 
     * @param cmbClientAgeCriterias The {@code JComboBox} object to be filled 
     * 
     * @since 1.6
     */
    public void fillClientAgeCriterias ( JComboBox cmbClientAgeCriterias )
    {   
        cmbClientAgeCriterias.addItem( AdmSettings.getLanguageBundle().getString( "lk_search_any" ) );
        
        for ( Commons.ClientCriterias criteria : Commons.ClientCriterias.values() )
            cmbClientAgeCriterias.addItem( AdmSettings.getLanguageBundle().getString( criteria.getLangKey() ) );
    }
    
    /** Registers a new client using the {@code Cliente} helper object, setting 
     * its attributes with the received ones
     * 
     * @param id Client/Person ID (Numero de Cedula)
     * 
     * @param name Client name
     * 
     * @param age Client Age
     * 
     * @param gender Client gender as a char: Male -> 'M' or Female -> 'F'
     *
     * @since 1.6
     * @see model.Cliente
     */
    public void registerClient ( String id, String name, int age, char gender )
    {
        tempClient = new Cliente( id, name, age, gender );
    }

    /** Gets in a pseudo-randomly way a new {@code Cliente} object from a list 
     * of 10 predefined stored clients using the {@code Random} class
     *
     * @return An existing {@code Cliente} object pseudo-randomly choosed
     * @see model.Cliente
     */
    public Cliente generarCliente ()
    {   // Se que resulta complicado de leer, pero me resulto interesante hiper-anonimizar este metodo en una sola linea
        return clientes.get( clientsIds.get( ( new Random() ).nextInt( clientsIds.size() ) ) );
    }

}
