package control;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.util.ArrayList;
import model.Sala;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CommonlyUsedObjects;

/** Theater Hall Mamagement Class, hosts tasks and important things related to it
 * @author Clark - ClarkCodes - Grupo #6
 * @since 1.0
 */
public class AdmSala
{   // Atributos - Propiedades
    private static AdmSala adm = null; // Objeto estático de esta misma clase declarado pero no inicializado, preparandolo para el patrón Singleton.
    private CommonlyUsedObjects common = null;
    private HashMap<String, Sala> salas = null; // Colección HashMap Principal donde estarán almacenados los registros primordiales como objetos, en este caso de Salas.
    private HashMap<String, String> nombresSalas = null;
    private ArrayList<String> sortedListForCombo = null;
    
    /** Sole Constructor which loads the {@code AdmSala} unique instance following Singleton Design Pattern */
    private AdmSala() // Constructor por defecto puesto como privado, el cuál inicializa las colecciones
    {
        this.salas = new HashMap<>();
        this.nombresSalas = new HashMap<>();
        this.sortedListForCombo = new ArrayList<>();
        this.common = CommonlyUsedObjects.getAdm();
        initSalas();
    }
    
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code AdmSala} instance
     */
    public static AdmSala getAdm() // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                              //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre.
        if(adm == null)
            adm = new AdmSala();
        return adm;
    }

    /** Initializes and sorts 10 predefined movie theaters for stored mode */
    private void initSalas()
    {
        Sala tempSala = new Sala("S-001", "IMAX", 1, "Normal", "H6");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-002", "Real 3D", 2, "3D", "A7");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-003", "3D XD", 3, "3D", "G5");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-004", "4D E-Motion", 4, "4D", "C3");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-005", "Normal", 5, "Normal", "B4");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-006", "VIP", 6, "VIP", "E1");
        salas.put(tempSala.getId(), tempSala);
        tempSala = new Sala("S-007", "IMAX - VIP", 7, "VIP", "F2");
        salas.put(tempSala.getId(), tempSala);
        
        for(Map.Entry s : salas.entrySet())
        {
            String nombreSala = ((Sala)s.getValue()).getNombre();
            nombresSalas.put(nombreSala, (String)s.getKey());
            sortedListForCombo.add(nombreSala);
        }
        sortedListForCombo.sort(null);
    }
    
    /** Fills the given Theater Hall {@code JComboBox}
     * @param combito A given JComboBox which corresponds to the available theaters list
     */
    public void llenarComboSalas(JComboBox combito)
    {   // Función Lambda en esquema funcional, pero parecido a un for sin indice, en este caso un forEach del combo // ns: Nombre Sala: cada elemento del ArrayList sortedListForCombo
        sortedListForCombo.forEach(ns -> { combito.addItem(ns); });
    }
    
    /** Fills the given Theater Hall {@code JTable}
     * @param key A given {@code String} key which corresponds to the respective theater
     * @param tablaSala The given {@code JTable} which shows the respective theater information
     * @see model.CommonlyUsedObjects
     */
    public void llenarTablaSalaElegida(String key, JTable tablaSala)
    {
        DefaultTableModel modelTS = (DefaultTableModel) tablaSala.getModel(); //TS: Tabla Salas
        
        if(tablaSala.getRowCount() == 0)
        {
            modelTS.addRow(new Object[1]);
            common.centerTableColumns(tablaSala);
        }
        
        tablaSala.setValueAt(((Sala)salas.get(key)).getId(), 0, 0);
        tablaSala.setValueAt(((Sala)salas.get(key)).getNumeroSala(), 0, 1);
        tablaSala.setValueAt(((Sala)salas.get(key)).getTipoSala(), 0, 2);
        tablaSala.setValueAt(((Sala)salas.get(key)).getAsiento(), 0, 3);
    }
    
    /** Gets the respective theater hall with a given theater name
     * @param nombreSala A given {@code String} theater name to get the respective theater
     * @return A {@code Sala} object that matches with the given theater name
     * @see model.Sala
     */
    public Sala obtenerSala(String nombreSala)
    {   
        return salas.get((String)nombresSalas.get(nombreSala));
    }
}
