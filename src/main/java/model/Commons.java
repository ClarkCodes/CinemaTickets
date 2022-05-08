
package model;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;

/** Hosts pretty common used objects and methods code to not repeat them and avoid
 * boilerplate code as well as the code atomicity principle
 *
 * @author Clark - ClarkCodes
 * @since 1.5
 */
public final class Commons
{   // Commonly Used Objects for common tasks to centralize its declaration, declare them once, use them anywhere.
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

    /**Enum Constants for indicating search criteria
     * @author Clark - ClarkCodes
     * @since 1.6
     */
    public static enum Filters
    {
        Cedula, 
        Precio, 
        Cedula_y_Precio,
        Edad,
        GeneroCliente,
        Edad_y_Genero,
        NombrePelicula,
        GeneroPelicula,
        IdiomaPelicula,
        SubtitulosPelicula,
        Gen_e_Idiom_Pelicula,
        Gen_y_Sub_Pelicula,
        Idiom_y_Sub_Pelicula,
        Gen_Idiom_Sub_Pelicula
    }
    
    /** Enum Constants for indicating movie function type / Enumerable del Tipo de Funcion: Normal o Vermouth
     * @author Clark - ClarkCodes 
     */
    public static enum TipoFuncion 
    {
        Normal,
        Vermouth
    }
    
    /** Enum Constants for indicating the open mode of some windows 
     * @author Clark - ClarkCodes 
     * @since 1.6
     */
    public static enum WindowMode 
    {
        Creacion,
        Busqueda,
        Edicion,
        Eliminacion
    }
    
    /**Enum Constants for indicating File type on open an save operations
     * @author Clark - ClarkCodes
     * @since 1.6
     * @see control.AdmSettings
     */
    public static enum FileType
    {
        Text ( "lk_settings_file_type_text" ),
        Binary ( "lk_settings_file_type_binary" );
        
        private final String lk_key;
        
        /** This Enum Constructor for its constants parameters */
        FileType( String lk_key )
        {
            this.lk_key = lk_key;
        }

        /** Gets the corresponding {@code String} that contains the localized
         * language key asociated to its corresponding {@code enum} constant
         * 
         * @return The asociated {@code String} language key
         * @since 1.6
         */
        public String getLangKey()
        {
            return lk_key;
        }
        
        /** Parses a {@code String} to its corresponding {@code FileType enum}
         * constant
         * @param str A specified {@code String} that contains a shown
         *            {@code FileType} text in the current application language
         * @return    The {@code FileType enum} constant that matches with the
         *            given str
         * @since 1.6
         * @see control.AdmTicket
         */
        public static FileType valueOfLocalizedString ( String str )
        {
            FileType result = null;
            
            for ( FileType c : values() )
            {
                if ( str.equalsIgnoreCase( AdmSettings.getLanguageBundle().getString( c.getLangKey() ) ) )
                {
                    result = c;
                    break;
                }
            }
            
            return result;
        }
    }

    /** Enum Constants for indicating the criteria to use in a client age search
     * @since 1.6
     */
    public static enum ClientCriterias
    {
        Clientes_con( "lk_search_clients_with" ),
        Clientes_mayores_de( "lk_search_clients_older_than" ),
        Clientes_menores_de( "lk_search_clients_younger_than" );
        
        private final String lk_key;
        
        /** This Enum Constructor for its constants parameters */
        ClientCriterias( String lk_key )
        {
            this.lk_key = lk_key;
        }
        
        /** Gets the corresponding {@code String} that contains the localized
         * language key asociated to its corresponding {@code enum} constant
         * 
         * @return The asociated {@code String} language key
         * @since 1.6
         */
        public String getLangKey()
        {
            return lk_key;
        }

        /** Parses a {@code String} to its corresponding 
         * {@code ClientCriterias enum} constant
         * @param str A specified {@code String} that contains a shown
         *            {@code ClientCriterias} text in the current application 
         *            language
         * @return    The {@code ClientCriterias enum} constant that matches with the
         *            given str
         * @since 1.6
         * @see control.AdmTicket
         */
        public static ClientCriterias valueOfLocalizedString ( String str )
        {
            ClientCriterias result = null;
            
            for ( ClientCriterias c : values() )
            {
                if ( str.equalsIgnoreCase( AdmSettings.getLanguageBundle().getString( c.getLangKey() ) ) )
                {
                    result = c;
                    break;
                }
            }
            
            return result;
        }
    }
    
    
    // Singleton Design Pattern
    private static Commons adm = null;
    
    /** Sole Constructor
     */
    private Commons ()
    {
        tcr.setHorizontalAlignment( SwingConstants.CENTER );
        tcr.setVerticalAlignment( SwingConstants.CENTER );
    }

    /**
     * Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code Commons} instance
     */
    public static Commons getAdm () // Método estático y público de esta clase que devuelve la instancia única de esta clase, si recién se abre la aplicación y recién se van a agregar datos 
    {                                    //se crea la instancia de esta clase, pero si ya fué creada se devuelve la que ya está, manteniendo una única instancia siempre
        if ( adm == null )
            adm = new Commons();
        return adm;
    }

    /** Gets the respective {@code DateTimeFormatter} object with the proper
     * formatter string set, following a given enum constant indicator, to make 
     * formats over other objects related with dates or time
     *
     * @param tipoFormato A specified format enum indicator to set properly the
     *                    formatter and return in consequence the right
     *                    formatter set
     *
     * @return The {@code DateTimeFormatter} object with the proper format set
     */
    public static DateTimeFormatter getFormatoDateTime ( TypeFormatoDateTime tipoFormato )
    {
        String strFormatoDateTime = ""; // String for DateTime Formatting
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español ->
            {
                strFormatoDateTime = switch ( tipoFormato )
                {
                    case FechaCorta -> "d/MM/yyyy";
                    case FechaLarga -> "d 'de' MMMM 'del' yyyy";
                    case FechaCompacta -> "yyMMdd";
                    case HorasMinutos -> "HH:mm";
                    case Duracion -> "h'h 'mm'm'";
                };
            }

            case English ->
            {
                strFormatoDateTime = switch ( tipoFormato )
                {
                    case FechaCorta -> "M/d/yyyy";
                    case FechaLarga -> "MMMM d ', ' yyyy";
                    case FechaCompacta -> "MMddyy";
                    case HorasMinutos -> "HH:mm";
                    case Duracion -> "h'h 'mm'm'";
                };
            }
        }
        // Formatter for Hours, Dates, Duration, etc / Formateador para las Horas y Fechas
        return DateTimeFormatter.ofPattern( strFormatoDateTime ); 
    }

    /** Centers a given {@code JTable} object with its 
     * {@code DefaultTableColumnModel} and sets a 
     * {@code DefaultTableCellRenderer} to it
     *
     * @param table The given {@code JTable} object to be centered
     */
    public void centerTableColumns ( JTable table )
    {
        DefaultTableColumnModel columnModel = ( DefaultTableColumnModel ) table.getColumnModel();
        for ( int i = 0; i < table.getColumnCount(); i++ )
            columnModel.getColumn( i ).setCellRenderer( tcr );
    }
    
    /** Gets the proper and unique {@code DateTimeFormatter} object for parsing
     * operations used mostly in open and save procedures
     * 
     * @return The specific {@code DateTimeFormatter} determined for parsing 
     *         operations
     * @since 1.6
     */
    public static DateTimeFormatter getParsingDateFormatter()
    {
        return DateTimeFormatter.ofPattern( "d/MM/yyyy" );
    }

}
