
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sala;

/** Theater Hall Management Class, hosts tasks and important things related to
 * it
 *
 * @author Clark - ClarkCodes - Grupo #6
 * @since 1.0
 */
public final class AdmSala
{   // Atributos - Propiedades
    private static AdmSala adm = null; // Objeto estático de esta misma clase declarado pero no inicializado, preparandolo para el patrón Singleton.
    private Commons common = null;
    private HashMap<String, Sala> salas = null; // Colección HashMap Principal donde estarán almacenados los registros primordiales como objetos, en este caso de Salas.
    private HashMap<String, String> nombresSalas = null;
    private LinkedList<String> sortedListForCombo = null;
    private Sala tempSala = null;

    /** Sole Constructor which loads the {@code AdmSala} unique instance
     * following Singleton Design Pattern */
    private AdmSala () // Constructor por defecto puesto como privado, el cuál inicializa las colecciones
    {
        this.salas = new HashMap<>();
        this.nombresSalas = new HashMap<>();
        this.sortedListForCombo = new LinkedList<>();
        this.common = Commons.getAdm();
        initSalas();
    }

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code AdmSala} instance
     */
    public static AdmSala getAdm () // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                              //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre.
        if ( adm == null )
            adm = new AdmSala();
        return adm;
    }

    /** Initializes and sorts 10 predefined movie theaters for stored mode
     * @see model.Sala
     */
    private void initSalas ()
    {
        registerTheater( "S-001", "IMAX", 1, "Normal", "H6" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-002", "Real 3D", 2, "3D", "A7" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-003", "3D XD", 3, "3D", "G5" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-004", "4D E-Motion", 4, "4D", "C3" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-005", "Normal", 5, "Normal", "B4" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-006", "VIP", 6, "VIP", "E1" );
        salas.put( tempSala.getId(), tempSala );
        registerTheater( "S-007", "IMAX - VIP", 7, "VIP", "F2" );
        salas.put( tempSala.getId(), tempSala );

        salas.forEach( ( salaKey, sala ) ->
        {
            nombresSalas.put( sala.getNombre(), salaKey );
            sortedListForCombo.add( sala.getNombre() );
        } );

        Collections.sort( sortedListForCombo );
    }
    
    /** Registers a new theater using the {@code Sala} helper object setting 
     * its attributes with the received ones
     * 
     * @param id         A {@code String} with this theater's id
     * @param nombre     A {@code String} with this theater's name
     * @param numeroSala A {@code int} data indicating this theater's number
     * @param tipoSala   A {@code String} with this theater's type
     * @param asiento    A {@code String} with this theater's seat/s
     * 
     * @since 1.6
     * @see model.Sala
     */
    private void registerTheater( String id, String nombre, int numeroSala, String tipoSala, String asiento )
    {
        tempSala = new Sala(id, nombre, numeroSala, tipoSala, asiento );
    }

    /** Fills the given Theater Hall {@code JComboBox} with the theaters list
     *
     * @param comboSalas A given {@code JComboBox} to be filled
     */
    public void llenarComboSalas ( JComboBox comboSalas )
    {   // Función Lambda en esquema funcional, pero parecido a un for sin indice, en este caso un forEach del combo // ns: Nombre Sala: cada elemento del LinkedList sortedListForCombo
        sortedListForCombo.forEach( ns -> comboSalas.addItem( ns ) );
    }

    /** Fills the given Theater Hall {@code JTable}
     *
     * @param key       A given {@code String} key that corresponds to the
     *                  respective theater id
     * @param tablaSala A given {@code JTable} which shall show the respective
     *                  theater information
     *
     * @see control.Commons
     */
    public void llenarTablaSalaElegida ( String key, JTable tablaSala )
    {
        DefaultTableModel modelTS = ( DefaultTableModel ) tablaSala.getModel(); //TS: Tabla Salas

        if ( tablaSala.getRowCount() == 0 )
        {
            modelTS.addRow( new Object[1] );
            common.centerTableColumns( tablaSala );
        }

        tablaSala.setValueAt( salas.get( key ).getId(), 0, 0 );
        tablaSala.setValueAt( salas.get( key ).getNumeroSala(), 0, 1 );
        tablaSala.setValueAt( salas.get( key ).getTipoSala(), 0, 2 );
        tablaSala.setValueAt( salas.get( key ).getAsiento(), 0, 3 );
    }

    /** Gets the respective theater hall with a given theater name
     * @param nombreSala A given {@code String} that contains a theater name to
     *                   get the respective {@code Sala} theater object to use 
     *                   its information
     * @return A {@code Sala} object that matches with the given theater name
     * @see model.Sala
     */
    public Sala obtenerSala ( String nombreSala )
    {
        return salas.get( nombresSalas.get( nombreSala ) );
    }

}
