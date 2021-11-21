package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;

/** Hosts pretty common used objects and code to not repeat them and avoid boilerplate code
 * @author Clark - ClarkCodes
 * @since 1.5
 */
public class CommonlyUsedObjects
{   // String for DateTime Formatting
    private static String strFormatoDateTime;
    // Formatter for Hours, Dates, Duration, etc / Formateador para las Horas y Fechas
    private static DateTimeFormatter formatoDateTime;
    // Cell Center Renderer
    private static final DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(); // Creamos un Renderizador de Celdas para Centrar el contenido de cada celda horizontal y verticalmente

    /** Enum Constants for indicating the DateTime format required */
    public static enum TypeFormatoDateTime
    {
        FechaCorta,
        FechaLarga,
        FechaCompacta,
        HorasMinutos,
        Duracion
    }
    // Singleton Design Pattern
    private static CommonlyUsedObjects adm = null;
    private CommonlyUsedObjects()
    {
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr.setVerticalAlignment(SwingConstants.CENTER);
    }
    
    /** 
     * Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code CommonlyUsedObjects} instance
     */
    public static CommonlyUsedObjects getAdm() // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre
        if(adm == null)
            adm = new CommonlyUsedObjects();
        return adm;
    }
    
    /** Gets the respective {@code DateTimeFormatter} object with the proper formatter string set following a given enum 
     * constant indicator, to make formats over other {@code DateTime} objects
     * @param tipoFormato A specified format enum indicator to set properly the formatter and return in consequence the right formatter set
     * @return The {@code DateTimeFormatter} object with the proper format set
     */
    public static DateTimeFormatter getFormatoDateTime(TypeFormatoDateTime tipoFormato)
    {
        strFormatoDateTime = switch(tipoFormato)
        {
            case FechaCorta -> { yield "d/MM/yyyy"; }
            case FechaLarga -> { yield "d 'de' MMMM 'del' yyyy"; }
            case FechaCompacta -> { yield "yyMMdd"; }
            case HorasMinutos -> { yield "HH:mm"; }
            case Duracion -> { yield "h:mm"; }
        };
        
        formatoDateTime = DateTimeFormatter.ofPattern(strFormatoDateTime);
        return formatoDateTime;
    }
    
    /** Centers a given {@code JTable} object with its {@code DefaultTableColumnModel} 
     * and setting a {@code DefaultTableCellRenderer} to it
     * @param table The given {@code JTable} object to be centered
     */
    public void centerTableColumns(JTable table)
    {
        DefaultTableColumnModel columnModel = (DefaultTableColumnModel) table.getColumnModel();
        for (int i = 0; i < table.getColumnCount(); i++)
            columnModel.getColumn(i).setCellRenderer(tcr);
    }

}
