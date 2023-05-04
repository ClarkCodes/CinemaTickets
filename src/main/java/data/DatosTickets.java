
package data;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import control.Validacion;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Cliente;
import control.Commons;
import model.ElementoCine;
import model.Funcion;
import model.Pelicula;
import model.Sala;
import model.Ticket;
import visual.FrmOpenSaveFrame;

/** Class for the Application Data Management, to open and save Cinema Tickets
 * files, and also for loading and saving user settings.
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class DatosTickets
{   // Adms
    private final AdmSettings admSettings;
    //Propiedades y Campos
    private Ticket ticket = null; // El Ticket mismo que se usara en ambos metodos tanto Abrir como Guardar para ir tomando los valores de los diferentes tickets y poder escribirlos en el archivos o asignarlos al HashMap Principal segun corresponda
    private File ruta = null;
    private int i = 0;
    private boolean userSettingsChanged = false;
    private Commons.FileType fileType = null; // Helper to determine what kind of file it has to work with on open and save operations.

    // Properties Object for User Settings
    private Properties userProperties = null;

    // JFileChooser para Abrir y Guardar archivos, uno solo de manera generalizada y estática para mayor comodidad y un JFrame para al JFileChooser y que así pueda agarrar el icono mas que todo
    private static final JFileChooser dialogoAbrirGuardarComo = new JFileChooser();
    private static final FrmOpenSaveFrame openSaveFrame = new FrmOpenSaveFrame(); // Frame unicamente existente para pasarselo como parametro al Open and Save Dialog
//    private FrmDialogWaitingMessenger openingSavingWaitingMessenger; IMPLEMENTATION PENDING TO next version 1.7
    
    // Colecciones involucradas - Se usa al abrir tickets - Aplicado el singleton también a este ArrayList
    private static final ArrayList<LocalTime> horariosDisponibles = new ArrayList<>();

    // Enums
    
    /** Enum constants to specify the criteria used to determine the file type
     *  that is being used in an open or save operation to call the proper 
     *  method
     */
    private enum FileTypeDetermination
    {
        FromProperties,
        Inspector
    }
    
// IMPLEMENTATION PENDING TO next version 1.7
//    public enum WaitingType
//    {
//        Opening,
//        Saving
//    }
    
    // Enum y su Variable Enum de Resultado para saber si el guardado o la apertura salieron bien.
    /** Enum constants to specify the result of an open or save operation */
    public static enum OperationResult
    {
        Operacion_Exitosa,
        Operacion_Fallida,
        CanceladoPorElUsuario
    }

    private static OperationResult result = OperationResult.Operacion_Fallida;

    // Patron de Disenio Singleton para tener una sola instancia de la Clase
    private static DatosTickets datosTickets = null;

    /** Sole constructor as part of a Singleton pattern
     */
    private DatosTickets () // Constructor
    {
        admSettings = AdmSettings.getAdmSettings();
        defaultSettingsVerifier();
        userSettingsVerifier();
        userSettingsLoader();
        dialogoAbrirGuardarComo.setPreferredSize( new Dimension( 900, 600 ) ); // Adecuacion general del Cuadro de Dialogo Abrir y Guardar, dimensiones y filtro de archivo
    }

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code DatosTickets} instance
     */
    public static DatosTickets getDatosTickets ()
    {
        if ( datosTickets == null )
            datosTickets = new DatosTickets();
        return datosTickets;
    }
    
    // IMPLEMENTATION PENDING TO next version 1.7
//    class OpenSaveWaitingThread extends Thread 
//    {
//        WaitingType waitingType;
//        OpenSaveWaitingThread ( WaitingType waitingType )
//        {
//            this.waitingType = waitingType;
//        }
//        
//        @Override
//        public void run ()
//        {
//            super.run();
//            openingSavingWaitingMessenger = new FrmDialogWaitingMessenger( openSaveFrame, true, waitingType );
//            openingSavingWaitingMessenger.setVisible( true );
//        }
//    }
    
    /** Manages the saving of a Cinema Tickets file, it shows a save file
     * dialog and calls the proper method based on the file type specified in 
     * user settings/properties, either text or binary type to save the file 
     * following that setting
     *
     * @param tickets A {@code HashMap<String, Ticket>} collection which 
     *                contains the current tickets to save in a Cinema Tickets 
     *                file
     * 
     * @since 1.6
     * @see model.Ticket
     */
    public final void saveTicketsFile( HashMap<String, Ticket> tickets )
    {
        ticket = null;
        ruta = null;
        boolean proceed = true;

        // Adecuacion del Cuadro de Dialogo
        openSaveFrame.setIconImage( admSettings.getSaveIconForSaveDialog().getImage() ); //Preparo el Frame el cual le voy a pasar al cuadro de dialogo para que herede sus características como icono, tema laf de la aplicación y coincida con esta.
        dialogoAbrirGuardarComo.setApproveButtonText( AdmSettings.getLanguageBundle().getString( "lk_save" ) );
        dialogoAbrirGuardarComo.setApproveButtonToolTipText( AdmSettings.getLanguageBundle().getString( "lk_data_save_tooltiptext" ) );
        dialogoAbrirGuardarComo.setDialogTitle( AdmSettings.getLanguageBundle().getString( "lk_save_as" ) );
        dialogoAbrirGuardarComo.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
        dialogoAbrirGuardarComo.setFileFilter( new FileNameExtensionFilter( AdmSettings.getLanguageBundle().getString( "lk_data_tickets_file" ) + "( *.ckn )", "ckn" ) );

        if ( dialogoAbrirGuardarComo.showSaveDialog( openSaveFrame ) == JFileChooser.APPROVE_OPTION )
        {
            ruta = dialogoAbrirGuardarComo.getSelectedFile();
            
            if ( ruta != null )
            {
                if ( ruta.exists() )
                    if ( JOptionPane.showConfirmDialog( null, AdmSettings.getLanguageBundle().getString("lk_save_file_already_exists_msj") + "\n" + AdmSettings.getLanguageBundle().getString("lk_save_file_replace_confirmation_msj"), AdmSettings.getLanguageBundle().getString("lk_save_file_already_exists_title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ) != JOptionPane.OK_OPTION )
                        proceed = false;

                if ( proceed )
                {
                    getFileType( FileTypeDetermination.FromProperties );
                    
                    // Showing Waiting Dialog to inform the user - IMPLEMENTATION PENDING TO next version 1.7
//                    Thread waitingThread;
//                    waitingThread = new Thread( new OpenSaveWaitingThread( WaitingType.Saving ) );
//                    waitingThread.start();
                    
                    switch ( fileType )
                    {
                        case Text -> guardarArchivoTicketsTexto ( tickets );
                        case Binary -> saveTicketsFileBinary ( tickets );
                    }
                    
//                    waitingThread.interrupt(); - IMPLEMENTATION PENDING TO next version 1.7
                }
                else
                    result = OperationResult.CanceladoPorElUsuario;
            }
            else
                result = OperationResult.CanceladoPorElUsuario;
        }
        else
            result = OperationResult.CanceladoPorElUsuario;
    }

    /** Saves a Cinema Tickets text file with its certain structure
     *
     * @param tickets A {@code HashMap<String, Ticket>} collection which 
     *                contains the current tickets to be saved
     * @since 1.0
     */
    private final void guardarArchivoTicketsTexto ( HashMap<String, Ticket> tickets )
    {
        FileWriter escribir = null;

        try
        {
            escribir = new FileWriter( ruta + ( !ruta.getAbsolutePath().endsWith( ".ckn" ) ? ".ckn" : "" ), false );

            for ( Map.Entry<String, Ticket> t : tickets.entrySet() )
            {
                ticket = t.getValue();

                // Ticket data
                escribir.write( ticket.getId() + "\n" );
                escribir.write( ticket.getNombre() + "\n" );
                escribir.write( ticket.getNumeroTicket() + "\n" );
                escribir.write( ticket.getPrecio() + "\n" );
                escribir.write( ticket.getFechaGeneracion().format( Commons.getParsingDateFormatter() ) + "\n" );

                // Cliente
                escribir.write( ticket.getCliente().getCedula() + "\n" );
                escribir.write( ticket.getCliente().getNombreCliente() + "\n" );
                escribir.write( ticket.getCliente().getEdad() + "\n" );
                escribir.write( ticket.getCliente().getGenero() + "\n" );

                // Pelicula
                escribir.write( ticket.getPelicula().getId() + "\n" );
                escribir.write( ticket.getPelicula().getNombre() + "\n" );
                escribir.write( ticket.getPelicula().getGenero().getLangKey() + "\n" );
                escribir.write( ticket.getPelicula().getIdioma() + "\n" );
                escribir.write( ( ticket.getPelicula().isTieneSubtitulos() ? "1" : "0" ) + "\n" ); // Si tiene subtitulos es 1
                escribir.write( ticket.getPelicula().getIdiomaSubtitulos() + "\n" );
                escribir.write( ticket.getPelicula().getDuracion().toSeconds() + "\n" ); // To Seconds devuelve un Long

                // Los horarios disponibles pueden ser muchos o pocos, no son fijos, por ende debo hacer un for para escribirlos y poner un identificador cuando terminen
                for ( i = 0; i < ticket.getPelicula().getHorariosDisponibles().size(); i++ )
                {
                    escribir.write(ticket.getPelicula().getHorariosDisponibles().get( i ).format( Commons.getFormatoDateTime(Commons.TypeFormatoDateTime.HorasMinutos ) ) + "\n" );
                }
                escribir.write( "hdends\n" ); // Identificador de que los horarios disponibles han terminado

                escribir.write(ticket.getPelicula().getFechaEstreno().format( Commons.getParsingDateFormatter() ) + "\n" );

                // Sala
                escribir.write( ticket.getSala().getId() + "\n" );
                escribir.write( ticket.getSala().getNombre() + "\n" );
                escribir.write( ticket.getSala().getNumeroSala() + "\n" );
                escribir.write( ticket.getSala().getTipoSala() + "\n" );
                escribir.write( ticket.getSala().getAsiento() + "\n" );

                // Funcion
                escribir.write( ticket.getFuncion().getId() + "\n" );
                escribir.write( ticket.getFuncion().getNombre() + "\n" );
                escribir.write(ticket.getFuncion().getHorarioElegido().format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) ) + "\n" );
                escribir.write( ticket.getFuncion().getEstrenoHabitual() + "\n" );
                escribir.write( ticket.getFuncion().getTipoFuncion().toString() + "\n" );
            }

            escribir.write( "---ctfEnd---" );

            result = OperationResult.Operacion_Exitosa;
            JOptionPane.showMessageDialog( null, AdmSettings.getLanguageBundle().getString("lk_save_successful_msj") + "\n" + AdmSettings.getLanguageBundle().getString("lk_save_file_saved_on") + ruta, AdmSettings.getLanguageBundle().getString("lk_save_successful_title"), JOptionPane.INFORMATION_MESSAGE );
            
        }
        catch ( IOException ioex )
        {
            result = OperationResult.Operacion_Fallida;
            JOptionPane.showMessageDialog( null, result.toString() + ": " + ioex.getMessage() + "\nClass: " + ioex.getClass() + "\nStack Trace: " + Arrays.toString( ioex.getStackTrace() ), AdmSettings.getLanguageBundle().getString( "lk_save_error" ), JOptionPane.ERROR_MESSAGE );
        }
        finally
        {
            try
            {
                if ( escribir != null )
                    escribir.close();
            }
            catch ( IOException ex )
            {
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }

    }
    
    /** Saves a Cinema Tickets binary file with its certain structure
     *
     * @param tickets A {@code HashMap<String, Ticket>} collection which 
     *                contains the current tickets to be saved
     * 
     * @since 1.6
     */
    private final void saveTicketsFileBinary ( HashMap<String, Ticket> tickets )
    {
        FileOutputStream objFileSetter = null;
        ObjectOutputStream objWriter = null;

        try
        {
            objFileSetter = new FileOutputStream( ruta + ( !ruta.getAbsolutePath().endsWith( ".ckn" ) ? ".ckn" : "" ), false );
            objWriter = new ObjectOutputStream( objFileSetter );

            objWriter.writeInt( tickets.size() ); // Escribo primero cuantos tickets hay para cuando se abra este archivo leer exactamente ese número de veces
            
            for ( Ticket t : tickets.values() ) // Se escriben los Objetos del Ticket, no se escribe todo el ticket directamente porque hay objetos de tipo ResourceBundle dentro de muchos de ellos por motivos de internacionalización de idiomas y este bundle no se puede serializar y lanza una excepcion al intentarlo
            {
                // Ticket data
                objWriter.writeObject( t.getId() );
                objWriter.writeObject( t.getNombre() );
                objWriter.writeInt( t.getNumeroTicket() );
                objWriter.writeDouble( t.getPrecio() );
                objWriter.writeObject( t.getFechaGeneracion() );

                // Cliente
                objWriter.writeObject( t.getCliente().getCedula() );
                objWriter.writeObject( t.getCliente().getNombreCliente() );
                objWriter.writeInt( t.getCliente().getEdad() );
                objWriter.writeChar( t.getCliente().getGenero() );

                // Pelicula
                objWriter.writeObject( t.getPelicula().getId() );
                objWriter.writeObject( t.getPelicula().getNombre() );
                objWriter.writeObject( t.getPelicula().getGenero() );
                objWriter.writeObject( t.getPelicula().getIdioma() );
                objWriter.writeBoolean( t.getPelicula().isTieneSubtitulos() );
                objWriter.writeObject( t.getPelicula().getIdiomaSubtitulos() );
                objWriter.writeObject( t.getPelicula().getDuracion() );
                objWriter.writeObject( t.getPelicula().getHorariosDisponibles() );
                objWriter.writeObject( t.getPelicula().getFechaEstreno() );

                // Sala
                objWriter.writeObject( t.getSala().getId() );
                objWriter.writeObject( t.getSala().getNombre() );
                objWriter.writeInt( t.getSala().getNumeroSala() );
                objWriter.writeObject( t.getSala().getTipoSala() );
                objWriter.writeObject( t.getSala().getAsiento() );

                // Funcion
                objWriter.writeObject( t.getFuncion().getId() );
                objWriter.writeObject( t.getFuncion().getNombre() );
                objWriter.writeObject(t.getFuncion().getHorarioElegido() );
                objWriter.writeBoolean( t.getFuncion().isEstreno() );
                objWriter.writeObject( t.getFuncion().getTipoFuncion() );
            }

            result = OperationResult.Operacion_Exitosa;
            JOptionPane.showMessageDialog( null, AdmSettings.getLanguageBundle().getString("lk_save_successful_msj") + "\n" + AdmSettings.getLanguageBundle().getString("lk_save_file_saved_on") + ruta, AdmSettings.getLanguageBundle().getString("lk_save_successful_title"), JOptionPane.INFORMATION_MESSAGE );
            
        }
        catch ( IOException ioex )
        {
            result = OperationResult.Operacion_Fallida;
            JOptionPane.showMessageDialog( null, result.toString() + ": " + ioex.getMessage() + "\nClass: " + ioex.getClass() + "\nStack Trace: " + Arrays.toString( ioex.getStackTrace() ), AdmSettings.getLanguageBundle().getString("lk_save_error"), JOptionPane.ERROR_MESSAGE );
        }
        finally
        {
            try
            {
                if ( objWriter != null )
                    objWriter.close();
                
                if( objFileSetter != null )
                    objFileSetter.close();
            }
            catch ( IOException ex )
            {
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }
    }

    /** Manages the opening of a Cinema Tickets file, it shows an open file
     * dialog and calls the proper method based on the determined file type, 
     * either text or binary to read the file in the right way and show its 
     * content
     *
     * @return A {@code HashMap<String, Ticket>} collection which contains the 
     *         opened read tickets from a Cinema Tickets file
     * 
     * @since 1.6
     */
    public final HashMap<String, Ticket> openTicketsFile ()
    {   // Adecuacion del Cuadro de Dialogo
        openSaveFrame.setIconImage( admSettings.getSourceOpenIconForOpenDialog().getImage() );
        dialogoAbrirGuardarComo.setMultiSelectionEnabled( false );
        dialogoAbrirGuardarComo.setFileSelectionMode( JFileChooser.FILES_ONLY );
        dialogoAbrirGuardarComo.setApproveButtonText( AdmSettings.getLanguageBundle().getString( "lk_data_open" ) );
        dialogoAbrirGuardarComo.setApproveButtonToolTipText( AdmSettings.getLanguageBundle().getString( "lk_data_open_tooltiptext" ) );
        dialogoAbrirGuardarComo.setDialogTitle( AdmSettings.getLanguageBundle().getString( "lk_data_open_title" ) );
        dialogoAbrirGuardarComo.setFileFilter( new FileNameExtensionFilter( AdmSettings.getLanguageBundle().getString( "lk_data_tickets_file" ) + "( *.ckn )", "ckn" ) );
        
        ruta = null;

        if ( dialogoAbrirGuardarComo.showOpenDialog( openSaveFrame ) == JFileChooser.APPROVE_OPTION )
        {
            ruta = dialogoAbrirGuardarComo.getSelectedFile();

            if ( ruta != null )
            {
                getFileType( FileTypeDetermination.Inspector );

                return switch( fileType )
                {
                    case Text -> abrirArchivoTicketsTexto ();
                    case Binary -> openTicketsFileBinary ();
                };
            }
            else
                result = OperationResult.CanceladoPorElUsuario;
        }
        else
            result = OperationResult.CanceladoPorElUsuario;
            
        return null;
    }

    /** Opens a Cinema Tickets text file with its certain structure
     *
     * @return A {@code HashMap<String, Ticket>} collection which contains the 
     *         opened tickets from a Cinema Tickets text file
     * 
     * @since 1.6
     */
    private final HashMap<String, Ticket> abrirArchivoTicketsTexto ()
    {   // Showing Waiting Dialog to inform the user - IMPLEMENTATION PENDING TO next version 1.7
//        Thread waitingThread;
//        waitingThread = new Thread( new OpenSaveWaitingThread( WaitingType.Saving ) );
//        waitingThread.start();
        
        // HashMap de Tickets que vamos recopilando para luego entregarlo con todos los tickets guardados en el archivo.
        HashMap<String, Ticket> ticketsRecopilados = null;
        HashMap<String, ElementoCine> elementosCineRecopilados = null;

        // Objetos temporales para ir agregando al Ticket y al HashMap posteriormente
        Cliente cliente;
        Pelicula pelicula;
        Sala sala;
        Funcion funcion;

        FileReader lectura = null;
        BufferedReader entrada = null;
        String ticketID = "", horarioHelper = "";

        try
        {
            ticketsRecopilados = new HashMap<>();
            lectura = new FileReader( ruta );
            entrada = new BufferedReader( lectura );

            while ( !( ticketID = entrada.readLine() ).equalsIgnoreCase( "---ctfEnd---" ) )
            {
                ticket = new Ticket();
                elementosCineRecopilados = new HashMap<>();

                ticket.setId( ticketID.trim() );
                ticket.setNombre( entrada.readLine().trim() );
                ticket.setNumeroTicket( Validacion.leerEntero( entrada.readLine().trim(), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_title" ) ) );
                ticket.setPrecio( Validacion.leerReal( entrada.readLine().trim(), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_title" ) ) );
                ticket.setFechaGeneracion( LocalDate.parse( entrada.readLine().trim(), Commons.getParsingDateFormatter() ) );

                // Cliente
                cliente = new Cliente();
                cliente.setCedula( entrada.readLine().trim() );
                cliente.setNombreCliente( entrada.readLine().trim() );
                cliente.setEdad( Validacion.leerEntero( entrada.readLine().trim(), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_title" ) ) );
                cliente.setGenero( entrada.readLine().charAt( 0 ) );
                ticket.setCliente( cliente );

                // Pelicula
                pelicula = new Pelicula();
                pelicula.setId( entrada.readLine().trim() );
                pelicula.setNombre( entrada.readLine().trim() );
                pelicula.setGenero( control.AdmPelicula.MovieGenres.valueOfLangKey( entrada.readLine().trim() ) );
                pelicula.setIdioma( entrada.readLine().trim() );
                pelicula.setTieneSubtitulos( entrada.readLine().charAt( 0 ) == '1' ); // Si tiene subtitulos es 1, por ende es verdadero sino es false
                pelicula.setIdiomaSubtitulos( entrada.readLine().trim() );
                pelicula.setDuracion( Duration.ofSeconds( Validacion.leerLong( entrada.readLine().trim(), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_title" ) ) ) ); // Se valida y se devuelve un Long a Duration

                // Los horarios disponibles pueden ser muchos o pocos, no son fijos, por ende debo hacer un while para leerlos hasta que se llegue al identificador de terminacion
                while ( !( horarioHelper = entrada.readLine().trim() ).equalsIgnoreCase( "hdends" ) )
                {
                    getHorariosDisponibles().add( LocalTime.parse( horarioHelper.trim(), Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) ) );
                }
                pelicula.setHorariosDisponibles( getHorariosDisponibles() );
                pelicula.setFechaEstreno( LocalDate.parse( entrada.readLine().trim(), Commons.getParsingDateFormatter() ) );
                elementosCineRecopilados.put( pelicula.getId(), pelicula );

                // Sala
                sala = new Sala();
                sala.setId( entrada.readLine().trim() );
                sala.setNombre( entrada.readLine().trim() );
                sala.setNumeroSala( Validacion.leerEntero( entrada.readLine().trim(), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_open_numeric_validation_error_title" ) ) );
                sala.setTipoSala( entrada.readLine().trim() );
                sala.setAsiento( entrada.readLine().trim() );
                elementosCineRecopilados.put( sala.getId(), sala );

                // Funcion
                funcion = new Funcion();
                funcion.setId( entrada.readLine().trim() );
                funcion.setNombre( entrada.readLine().trim() );
                funcion.setHorarioElegido( LocalTime.parse( entrada.readLine().trim(), Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) ) );
                funcion.setEstreno( entrada.readLine().trim().equalsIgnoreCase( "estreno" ) );
                funcion.setTipoFuncion( Commons.TipoFuncion.valueOf( entrada.readLine().trim() ) );
                elementosCineRecopilados.put( funcion.getId(), funcion );

                // Agregamos el HashMap elementosCine al Ticket
                ticket.setElementosCine( elementosCineRecopilados );

                // Agregamos el Ticket al HashMap
                ticketsRecopilados.put( ticket.getId(), ticket );
            }

            result = OperationResult.Operacion_Exitosa;

        }
        catch ( IOException ioex )
        {
            result = OperationResult.Operacion_Fallida;
            JOptionPane.showMessageDialog( null, result.toString() + ": " + ioex.getMessage() + "\nClass: " + ioex.getClass() + "\nStack Trace: " + Arrays.toString( ioex.getStackTrace() ), AdmSettings.getLanguageBundle().getString( "lk_open_error_title" ), JOptionPane.ERROR_MESSAGE );
        }
        finally
        {
            try
            {
                if ( entrada != null )
                    entrada.close();
                if ( lectura != null )
                    lectura.close();
                
//                waitingThread.interrupt(); IMPLEMENTATION PENDING TO next version 1.7
            }
            catch ( IOException ex )
            {
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }

        return ticketsRecopilados;
    }

    /** Opens a Cinema Tickets binary file with its corresponding certain 
     * structure
     *
     * @return A {@code HashMap<String, Ticket>} collection which contains the 
     *         opened read tickets from the specified Cinema Tickets binary file
     * 
     * @since 1.6
     */
    private final HashMap<String, Ticket> openTicketsFileBinary ()
    {   // Showing Waiting Dialog to inform the user - IMPLEMENTATION PENDING TO next version 1.7
//        Thread waitingThread;
//        waitingThread = new Thread( new OpenSaveWaitingThread( WaitingType.Saving ) );
//        waitingThread.start();
        
        // HashMap de Tickets que vamos recopilando para luego entregarlo con todos los tickets guardados en el archivo.
        HashMap<String, Ticket> ticketsRecopilados = new HashMap<>();
        HashMap<String, ElementoCine> elementosCineRecopilados;
        int cantTickets = 0;

        // Objetos temporales para ir agregando al Ticket y al HashMap posteriormente
        Cliente cliente;
        Pelicula pelicula;
        Sala sala;
        Funcion funcion;
        
        FileInputStream objFileSetter = null;
        ObjectInputStream objReader = null;

        try
        {   
            objFileSetter = new FileInputStream( ruta );
            objReader = new ObjectInputStream( objFileSetter );

            cantTickets = objReader.readInt();
            
            for ( i = 0; i < cantTickets; i++ )
            {
                ticket = new Ticket();
                elementosCineRecopilados = new HashMap<>();

                // Ticket data
                ticket.setId( objReader.readObject().toString() );
                ticket.setNombre( objReader.readObject().toString() );
                ticket.setNumeroTicket( objReader.readInt() );
                ticket.setPrecio( objReader.readDouble() );
                ticket.setFechaGeneracion( ( LocalDate ) objReader.readObject() );

                // Cliente
                cliente = new Cliente();
                cliente.setCedula( objReader.readObject().toString() );
                cliente.setNombreCliente( objReader.readObject().toString() );
                cliente.setEdad( objReader.readInt() );
                cliente.setGenero( objReader.readChar() );
                ticket.setCliente( cliente );

                // Pelicula
                pelicula = new Pelicula();
                pelicula.setId( objReader.readObject().toString() );
                pelicula.setNombre( objReader.readObject().toString() );
                pelicula.setGenero( ( control.AdmPelicula.MovieGenres ) objReader.readObject() );
                pelicula.setIdioma( objReader.readObject().toString() );
                pelicula.setTieneSubtitulos( objReader.readBoolean() );
                pelicula.setIdiomaSubtitulos( objReader.readObject().toString() );
                pelicula.setDuracion( ( Duration ) objReader.readObject() );
                pelicula.setHorariosDisponibles( ( ArrayList<LocalTime> ) objReader.readObject() );
                pelicula.setFechaEstreno( ( LocalDate ) objReader.readObject() );
                elementosCineRecopilados.put( pelicula.getId(), pelicula );

                // Sala
                sala = new Sala();
                sala.setId( objReader.readObject().toString() );
                sala.setNombre( objReader.readObject().toString() );
                sala.setNumeroSala( objReader.readInt() );
                sala.setTipoSala( objReader.readObject().toString() );
                sala.setAsiento( objReader.readObject().toString() );
                elementosCineRecopilados.put( sala.getId(), sala );

                // Funcion
                funcion = new Funcion();
                funcion.setId( objReader.readObject().toString() );
                funcion.setNombre( objReader.readObject().toString() );
                funcion.setHorarioElegido( ( LocalTime ) objReader.readObject() );
                funcion.setEstreno( objReader.readBoolean() );
                funcion.setTipoFuncion( ( Commons.TipoFuncion ) objReader.readObject() );
                elementosCineRecopilados.put( funcion.getId(), funcion );
                
                // Agregamos el HashMap elementosCine al Ticket
                ticket.setElementosCine( elementosCineRecopilados );

                // Agregamos el Ticket al HashMap
                ticketsRecopilados.put( ticket.getId(), ticket );
            }

            result = OperationResult.Operacion_Exitosa;

        }
        catch ( EOFException eofex ) // Esta excepción es especial en un archivo binario, dado que siempre que se llega al final de un archivo binario se lanza esta excepción, por lo tanto es en este catch donde tenemos que devolver la coleccion de tickets o en otras palabras lo que hemos leido del archivo.
        {
            if( ticketsRecopilados.size() == cantTickets )
            {
                result = OperationResult.Operacion_Exitosa;
                return ticketsRecopilados;
            }
        }
        catch ( ClassNotFoundException | IOException cnfioex )
        {
            result = OperationResult.Operacion_Fallida;
            JOptionPane.showMessageDialog( null, result.toString() + ": " + cnfioex.getMessage() + "\nClass: " + cnfioex.getClass() + "\nStack Trace: " + Arrays.toString( cnfioex.getStackTrace() ), AdmSettings.getLanguageBundle().getString( "lk_open_error_title" ), JOptionPane.ERROR_MESSAGE );
        }
        finally
        {
            try
            {
                if ( objReader != null )
                    objReader.close();
                if ( objFileSetter != null )
                    objFileSetter.close();
                
//                waitingThread.interrupt(); IMPLEMENTATION PENDING TO next version 1.7
            }
            catch ( IOException ex )
            {
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }

        return ticketsRecopilados;
    }
    
    /** Manages the determination of a Cinema Tickets file type and sets it to 
     * the respective attribute, following the specified determination criteria 
     * in order to save or open a Cinema Tickets file with the right file format
     * 
     * @param determinationMethod A {@code FileTypeDetermination enum} constant 
     *                            to indicate the way to perform the file type 
     *                            determination, this could be the file type 
     *                            used to save Cinema Tickets files specified 
     *                            user settings or by inspecting a specified 
     *                            file by the user in order to open it in the 
     *                            right way by calling the proper method, this 
     *                            is if the specified file is a text or a binary
     *                            file
     * @since 1.6
     */
    private void getFileType( FileTypeDetermination determinationMethod )
    {
        fileType = switch( determinationMethod )
        {
            case FromProperties -> switch( getUserProperties().getProperty( "fileTypeToSave" ) )
                {
                    case "binary" -> Commons.FileType.Binary;
                    default -> Commons.FileType.Text;
                };
            
            case Inspector -> fileTypeInspector();
        };
    }
    
    /** Inspects a specified file to determine its type, using an own method to
     * know if it is a binary or a text Cinema Tickets file.
     * 
     * @return A {@code Commons.FileType enum} constant with the corresponding 
     *         value representation for either binary or text
     * 
     * @since 1.6
     */
    private Commons.FileType fileTypeInspector()
    {
        FileInputStream objFileSetter = null;
        ObjectInputStream objReader = null;
        
        try
        {// Se trata de leer el primer objeto de un archivo binario de Cinema Tickets, si es posible leerlo y no salta una excepción significa que en efecto es un un archivo binario
            objFileSetter = new FileInputStream( ruta );
            objReader = new ObjectInputStream( objFileSetter );
            
            objReader.readInt();
        }
        catch ( IOException ioex )
        {// De lo contrario si salta la excepción entonces se deduce y se determina que se trata de un archivo de texto
            return Commons.FileType.Text;
        }
        finally
        {
            try
            {
                if ( objReader != null )
                    objReader.close();
                if ( objFileSetter != null )
                    objFileSetter.close();
            }
            catch ( IOException ex )
            {
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }
        
        return Commons.FileType.Binary;
    }
    
    /** Sets the save or open dialog starting folder following the user settings
     * @since 1.6
     * @see control.AdmSettings
     */
    public final void dialogDirectorySetter()
    {
        if ( admSettings.getStartingFolder().equalsIgnoreCase( "default" ) )
        {
            dialogoAbrirGuardarComo.setCurrentDirectory( null );
        }
        else
        {   
            dialogoAbrirGuardarComo.setCurrentDirectory( new File( admSettings.getStartingFolder() ) );
        }
    }

    /** Verifies settings by default, if Default Settings file doesn't exist
     * yet, it is created with generic starting values 
     * @since 1.4
     */
    public final void defaultSettingsVerifier ()
    {
        FileOutputStream writer = null;
        File defaultSettingsFile = new File( "defaultSettings.ctKnSettings" );

        if ( !defaultSettingsFile.exists() )
        {
            try
            {
                // Setting the dafault Properties
                Properties defaultProperties = new Properties();
                defaultProperties.setProperty( "clientDataMode", "stored" );
                defaultProperties.setProperty( "appDataMode", "stored" );
                defaultProperties.setProperty( "currentGuiLafTheme", "Night Owl (Material)" );
                defaultProperties.setProperty( "appLocale", "es_EC" );
                defaultProperties.setProperty( "fileTypeToSave", "text" );
                defaultProperties.setProperty( "startingFolder", "default" );

                // Saving the default Properties
                writer = new FileOutputStream( defaultSettingsFile, false );
                defaultProperties.store( writer, "-- CinemaTickets Default Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE" );
            }
            catch ( FileNotFoundException fnfex )
            {
                JOptionPane.showMessageDialog( null, fnfex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_fof_exception" ) + "\nDefaultSettingsVerifier", JOptionPane.ERROR_MESSAGE );
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, fnfex );
            }
            catch ( IOException ioex )
            {
                JOptionPane.showMessageDialog( null, ioex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_io_exception" ) + "\nDefaultSettingsVerifier", JOptionPane.ERROR_MESSAGE );
            }
            finally
            {
                try
                {
                    if ( writer != null )
                        writer.close();
                }
                catch ( IOException ex )
                {
                    Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
                }
            }
        }

    }

    /** Verifies user settings, if User Settings file doesn't exist yet, it is
     * created just as a copy with same values as default settings 
     * @since 1.4
     */
    public final void userSettingsVerifier ()
    {
        FileOutputStream settingsWriter = null;
        FileInputStream settingsReader = null;
        File userSettingsFile = new File( "userSettings.ctKnSettings" );

        if ( !userSettingsFile.exists() )
        {
            try
            {
                // Setting the User Properties from scratch loading the default Properties into it
                userProperties = new Properties();
                settingsReader = new FileInputStream( "defaultSettings.ctKnSettings" );
                userProperties.load( settingsReader );

                // Saving the User Properties now
                settingsWriter = new FileOutputStream( userSettingsFile, false );
                userProperties.store( settingsWriter, "-- CinemaTickets Default Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE" );
                userProperties = null;
            }
            catch ( FileNotFoundException fnfex )
            {
                JOptionPane.showMessageDialog( null, fnfex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_fof_exception" ) + "\nUserSettingsVerifier", JOptionPane.ERROR_MESSAGE );
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, fnfex );
            }
            catch ( IOException ioex )
            {
                JOptionPane.showMessageDialog( null, ioex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_io_exception" ) + "\nUserSettingsVerifier", JOptionPane.ERROR_MESSAGE );
            }
            finally
            {
                try
                {
                    if ( settingsReader != null )
                        settingsReader.close();
                    if ( settingsWriter != null )
                        settingsWriter.close();
                }
                catch ( IOException ex )
                {
                    Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
                }
            }
        }
    }

    /** Loads user settings only if User Settings file exists
     * @since 1.4
     * @see control.AdmSettings
     */
    public final void userSettingsLoader ()
    {
        FileInputStream settingsReader = null;
        File userSettingsFile = new File( "userSettings.ctKnSettings" );

        if ( userSettingsFile.exists() )
        {
            try
            {
                // Setting the User Properties from the saved User Properties File
                userProperties = new Properties();
                settingsReader = new FileInputStream( userSettingsFile );
                userProperties.load( settingsReader );

                // Applying saved settings to app
                admSettings.applyThemeManager( getUserProperties().getProperty( "currentGuiLafTheme" ) ); // Making the Call to apply the Laf theme saved in User Settings
                admSettings.colorOnIconsManager( AdmSettings.ColorSetType.Startup ); // Applying Colors on Icons
                // Setting App Language saved in User Settings
                admSettings.loadLanguageFromPreferences( getUserProperties().getProperty( "appLocale" ) );
                admSettings.setClientDataMode( getUserProperties().getProperty( "clientDataMode" ) );
                admSettings.setAppDataMode( getUserProperties().getProperty( "appDataMode" ) );
                admSettings.setFileTypeToSave( getUserProperties().getProperty( "fileTypeToSave" ) );
                admSettings.setStartingFolder( getUserProperties().getProperty( "startingFolder" ) );
                admSettings.setCurrentSelectedGuiLafTheme( getUserProperties().getProperty( "currentGuiLafTheme" ) );
                admSettings.setCurrentAppliedGuiLafTheme( admSettings.getCurrentSelectedGuiLafTheme() );
                admSettings.setApplyingThemePending( false );
                dialogDirectorySetter();
            }
            catch ( FileNotFoundException fnfex )
            {
                JOptionPane.showMessageDialog( null, fnfex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_fof_exception" ) + "\nUserSettingsLoader", JOptionPane.ERROR_MESSAGE );
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, fnfex );
            }
            catch ( IOException ioex )
            {
                JOptionPane.showMessageDialog( null, ioex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_io_exception" ) + "\nUserSettingsLoader", JOptionPane.ERROR_MESSAGE );
            }
            finally
            {
                try
                {
                    if ( settingsReader != null )
                        settingsReader.close();
                }
                catch ( IOException ex )
                {
                    Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
                }
            }
        }
    }

    /** Saves user settings only if User Settings have changed, using a boolean
     * helper attribute 
     * 
     * @since 1.4
     */
    public final void userSettingsSaver ()
    {
        FileOutputStream settingsWriter = null;
        File userSettingsFile = new File( "userSettings.ctKnSettings" );

        if ( isUserSettingsChanged() )
        {
            try
            {   // Saving the User Properties at the Application Closing
                settingsWriter = new FileOutputStream( userSettingsFile, false );
                userProperties.store( settingsWriter, "-- CinemaTickets User Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE" );
            }
            catch ( FileNotFoundException fnfex )
            {
                JOptionPane.showMessageDialog( null, fnfex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_fof_exception" ) + "\nUserSettingsSaver", JOptionPane.ERROR_MESSAGE );
                Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, fnfex );
            }
            catch ( IOException ioex )
            {
                JOptionPane.showMessageDialog( null, ioex.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_settings_error_io_exception" ) + "\nUserSettingsSaver", JOptionPane.ERROR_MESSAGE );
            }
            finally
            {
                try
                {
                    if ( settingsWriter != null )
                        settingsWriter.close();
                }
                catch ( IOException ex )
                {
                    Logger.getLogger( DatosTickets.class.getName() ).log( Level.SEVERE, null, ex );
                }
            }
        }
    }

    /** Verifies if a user setting has ben changed compared with the saved user
     * setting stored in the respective {@code Properties} object
     *
     * @see data.DatosTickets
     * @since 1.4
     */
    public final void settingsChangeVerifier ()
    {   // Setting the Property to store the Properties object later on App Close
        if ( ( !getUserProperties().getProperty( "appLocale" ).equalsIgnoreCase( AdmSettings.getAppLanguage().getLocale().toLanguageTag().replace( "-", "_") )
                | !getUserProperties().getProperty( "clientDataMode" ).equalsIgnoreCase( admSettings.getClientDataMode().toString() )
                | !getUserProperties().getProperty( "appDataMode" ).equalsIgnoreCase( admSettings.getAppDataMode().toString() )
                | !getUserProperties().getProperty( "fileTypeToSave" ).equalsIgnoreCase( admSettings.getFileTypeToSave().toString().toLowerCase() )
                | !getUserProperties().getProperty( "startingFolder" ).equalsIgnoreCase( admSettings.getStartingFolder() )
                | !getUserProperties().getProperty( "currentGuiLafTheme" ).equalsIgnoreCase( admSettings.getCurrentSelectedGuiLafTheme() ) )
                && !isUserSettingsChanged() )
        {
            setUserSettingsChanged( true );
        }
    }

    /** Updates the Open and Save file dialog, this method is mostly used 
     * when a Look and Feel is set, to properly update the {@code JFileChooser}
     * to match with the current theme
     * @since 1.4
     */
    public static void updateSaveOpenDlg ()
    {
        dialogoAbrirGuardarComo.updateUI();
    }

    // Getters and Setters
    /** Gets the result of a open or save operation
     * @return The {@code OperationResult enum} resulting constant
     */
    public static OperationResult getResult ()
    {
        return result;
    }
    /** Gets the available movie showtimes collection
     * @return A {@code ArrayList<LocalTime>} helper temporary collection with 
     * the available movie showtimes used in open or save operations
     */
    private static ArrayList<LocalTime> getHorariosDisponibles ()
    {
        return horariosDisponibles;
    }
    /** Gets the user settings changed indicator
     * @return {@code true} if a user setting has changed, {@code false} 
     * otherwise
     * @since 1.4
     */
    public boolean isUserSettingsChanged ()
    {
        return userSettingsChanged;
    }
    /** Sets the user settings changed indicator
     * @param userSettingsChanged A {@code boolean} that indicates the change of
     *                            a user setting, it should be {@code true} if a
     *                            setting has changed and {@code false} if not
     * @since 1.4
     */
    public void setUserSettingsChanged ( boolean userSettingsChanged )
    {
        this.userSettingsChanged = userSettingsChanged;
    }
    /** Gets the user Properties
     * @return A {@code Properties} object that corresponds to user settings
     * @since 1.4
     */
    public Properties getUserProperties ()
    {
        return userProperties;
    }
    /** Gets a {@code JFrame} used to show the open/save dialog
     * @return A {@code JFrame FrmOpenSaveFrame} object that is a window where 
     * the open/save dialog inherits
     */
    public static FrmOpenSaveFrame getOpenSaveFrame ()
    {
        return openSaveFrame;
    }

}
