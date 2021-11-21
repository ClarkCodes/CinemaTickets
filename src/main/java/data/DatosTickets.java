package data;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import control.Validacion;
import model.Cliente;
import model.CommonlyUsedObjects;
import model.ElementoCine;
import model.Pelicula;
import model.Sala;
import model.Funcion;
import model.Ticket;
import model.TipoFuncion;
import visual.FrmOpenSaveFrame;

/** Class for the Application Data Management, to open and save Cinema Tickets files, 
 * and also for loading and saving user settings.
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class DatosTickets
{   // Adms
    private AdmSettings admSettings = AdmSettings.getAdmSettings();
    //Propiedades y Campos
    private Ticket ticket = null; // El Ticket mismo que se usara en ambos metodos tanto Abrir como Guardar para ir tomando los valores de los diferentes tickets y poder escribirlos en el archivos o asignarlos al HashMap Principal segun corresponda
    private File ruta = null;
    private int i = 0;
    private boolean userSettingsChanged = false;

    // Properties Object for User Settings
    private Properties userProperties = null;

    // JFileChooser para Abrir y Guardar archivos, uno solo de manera generalizada y estática para mayor comodidad y un JFrame para al JFileChooser y que así pueda agarrar el icono mas que todo
    private static final JFileChooser dialogoAbrirGuardarComo = new JFileChooser();
    private static final FrmOpenSaveFrame openSaveFrame = new FrmOpenSaveFrame(); // Frame unicamente existente para pasarselo como parametro al Open and Save Dialog

    // Colecciones involucradas - Se usa al abrir tickets - Aplicado el singleton también a este ArrayList
    private static final ArrayList<LocalTime> horariosDisponibles = new ArrayList<>();

    // Enum y su Variable Enum de Resultado para saber si el guardado o la apertura salieron bien.
    public static enum OperationResult
    {
        Operacion_Exitosa,
        Operacion_Fallida,
        CanceladoPorElUsuario
    }

    private static OperationResult result = OperationResult.Operacion_Fallida;

    // Patron de Disenio Singleton para tener una sola instancia de la Clase
    private static DatosTickets datosTickets = null;

    private DatosTickets() // Constructor
    {
        dialogoAbrirGuardarComo. setPreferredSize(new Dimension(900, 600)); // Adecuacion general del Cuadro de Dialogo Abrir y Guardar, dimensiones y filtro de archivo
        dialogoAbrirGuardarComo.setFileFilter(new FileNameExtensionFilter("Archivo de Tickets: \" *.ckn \"", "ckn"));
        dialogoAbrirGuardarComo.setLocale(Locale.getDefault());
    }
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code DatosTickets} instance
     */
    public static DatosTickets getDatosTickets()
    {
        if (datosTickets == null)
            datosTickets = new DatosTickets();
        return datosTickets;
    }

    /** Saves a Cinema Tickets text file with a certain structure, same that is used to open Cinema Tickets files
     * @param tickets A HashMap collection of type {@code HashMap<String, Ticket>} which contains the current tickets to be saved
     */
    public void guardarArchivoTicketsTexto(HashMap<String, Ticket> tickets)
    {
        ticket = null;
        ruta = null;
        FileWriter escribir = null;
        boolean proceed = true;

        // Adecuacion del Cuadro de Dialogo
        openSaveFrame.setIconImage(admSettings.getSaveIconForSaveDialog().getImage());
        dialogoAbrirGuardarComo.setApproveButtonText("Guardar");
        dialogoAbrirGuardarComo.setApproveButtonToolTipText("Guarde los Tickets actuales en un Archivo de Cinema Tickets");
        dialogoAbrirGuardarComo.setDialogTitle("Guardar como...");

        if (dialogoAbrirGuardarComo.showSaveDialog(openSaveFrame) == JFileChooser.APPROVE_OPTION)
        {
            ruta = dialogoAbrirGuardarComo.getSelectedFile();

            try
            {
                if (ruta != null)
                {
                    if (ruta.exists())
                        if (JOptionPane.showConfirmDialog(null, "El archivo ya existe con este nombre.\n¿Desea sobreescribir el archivo?", "Archivo ya existente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.OK_OPTION)
                            proceed = false;

                    if (proceed)
                    {
                        escribir = new FileWriter(ruta + (!ruta.getAbsolutePath().endsWith(".ckn") ? ".ckn" : ""), false);

                        for (Map.Entry<String, Ticket> t : tickets.entrySet())
                        {
                            ticket = t.getValue();

                            // Ticket data
                            escribir.write(ticket.getId() + "\n");
                            escribir.write(ticket.getNombre() + "\n");
                            escribir.write(ticket.getNumeroTicket() + "\n");
                            escribir.write(ticket.getPrecio() + "\n");
                            escribir.write(ticket.getFechaGeneracion().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)) + "\n");

                            // Cliente
                            escribir.write(ticket.getCliente().getCedula() + "\n");
                            escribir.write(ticket.getCliente().getNombreCliente() + "\n");
                            escribir.write(ticket.getCliente().getEdad() + "\n");
                            escribir.write(ticket.getCliente().getGenero() + "\n");

                            // Pelicula
                            escribir.write(ticket.getPelicula().getId() + "\n");
                            escribir.write(ticket.getPelicula().getNombre() + "\n");
                            escribir.write(ticket.getPelicula().getGenero() + "\n");
                            escribir.write(ticket.getPelicula().getIdioma() + "\n");
                            escribir.write((ticket.getPelicula().isTieneSubtitulos() ? "1" : "0") + "\n"); // Si tiene subtitulos es 1
                            escribir.write(ticket.getPelicula().getIdiomaSubtitulos() + "\n");
                            escribir.write(ticket.getPelicula().getDuracion().toSeconds() + "\n"); // To Seconds devuelve un Long

                            // Los horarios disponibles pueden ser muchos o pocos, no son fijos, por ende debo hacer un for para escribirlos y poner un identificador cuando terminen
                            for (i = 0; i < ticket.getPelicula().getHorariosDisponibles().size(); i++)
                            {
                                escribir.write(ticket.getPelicula().getHorariosDisponibles().get(i).format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos)) + "\n");
                            }
                            escribir.write("hdends\n"); // Identificador de que los horarios disponibles han terminado

                            escribir.write(ticket.getPelicula().getFechaEstreno().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)) + "\n");

                            // Sala
                            escribir.write(ticket.getSala().getId() + "\n");
                            escribir.write(ticket.getSala().getNombre() + "\n");
                            escribir.write(ticket.getSala().getNumeroSala() + "\n");
                            escribir.write(ticket.getSala().getTipoSala() + "\n");
                            escribir.write(ticket.getSala().getAsiento() + "\n");

                            // Funcion
                            escribir.write(ticket.getFuncion().getId() + "\n");
                            escribir.write(ticket.getFuncion().getNombre() + "\n");
                            escribir.write(ticket.getFuncion().getHorarioElegido().format(CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos)) + "\n");
                            escribir.write(ticket.getFuncion().getEstrenoHabitual() + "\n");
                            escribir.write(ticket.getFuncion().getTipoFuncion().toString() + "\n");
                        }

                        escribir.write("---ctfEnd---");

                        result = OperationResult.Operacion_Exitosa;
                        JOptionPane.showMessageDialog(null, "Tickets guardados con exito.\nGuardado en: " + ruta, "Tickets Guardados", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        result = OperationResult.CanceladoPorElUsuario;
                }
                else
                    result = OperationResult.CanceladoPorElUsuario;
            }
            catch (IOException ioex)
            {
                result = OperationResult.Operacion_Fallida;
                JOptionPane.showMessageDialog(null, result.toString() + ": " + ioex.getMessage(), "Error de Apertura", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (escribir != null)
                    {
                        escribir.close();
                    }
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            result = OperationResult.CanceladoPorElUsuario;
    }

    /** Opens a Cinema Tickets text file with a certain structure, same that is used to save Cinema Tickets files
     * @return A HashMap collection of type {@code HashMap<String, Ticket>} which contains the opened tickets from a Cinema Tickets file
     */
    public HashMap<String, Ticket> abrirArchivoTicketsTexto()
    {   // HashMap de Tickets que vamos recopilando para luego entregarlo con todos los tickets guardados en el archivo.
        HashMap<String, Ticket> ticketsRecopilados = null;
        HashMap<String, ElementoCine> elementosCineRecopilados;

        // Objetos temporales para ir agregando al Ticket y al HashMap posteriormente
        Cliente cliente;
        Pelicula pelicula;
        Sala sala;
        Funcion funcion;

        // Adecuacion del Cuadro de Dialogo
        openSaveFrame.setIconImage(admSettings.getSourceOpenIconForOpenDialog().getImage());
        dialogoAbrirGuardarComo.setApproveButtonText("Abrir");
        dialogoAbrirGuardarComo.setMultiSelectionEnabled(false);
        dialogoAbrirGuardarComo.setApproveButtonToolTipText("Abra un Archivo de Cinema Tickets");
        dialogoAbrirGuardarComo.setDialogTitle("Abrir archivo de Tickets");

        ruta = null;
        FileReader lectura = null;
        BufferedReader entrada = null;
        String ticketID = "", horarioHelper = "";

        if (dialogoAbrirGuardarComo.showOpenDialog(openSaveFrame) == JFileChooser.APPROVE_OPTION)
        {
            ruta = dialogoAbrirGuardarComo.getSelectedFile();

            try
            {
                if (ruta != null)
                {
                    ticketsRecopilados = new HashMap<>();
                    lectura = new FileReader(ruta);
                    entrada = new BufferedReader(lectura);

                    while (!(ticketID = entrada.readLine()).equalsIgnoreCase("---ctfEnd---"))
                    {
                        ticket = new Ticket();
                        elementosCineRecopilados = new HashMap<>();

                        ticket.setId(ticketID.trim());
                        ticket.setNombre(entrada.readLine().trim());
                        ticket.setNumeroTicket(Validacion.leerEntero(entrada.readLine().trim(), "Datos numericos incorrectos, el archivo esta corrupto o ha sido daniado. No se garantiza la integridad de los datos. Se recomienda no abrir este archivo.", "Numero no valido"));
                        ticket.setPrecio(Validacion.leerReal(entrada.readLine().trim(), "Datos numericos incorrectos, el archivo esta corrupto o ha sido daniado. No se garantiza la integridad de los datos. Se recomienda no abrir este archivo.", "Numero no valido"));
                        ticket.setFechaGeneracion(LocalDate.parse(entrada.readLine().trim(), CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));

                        // Cliente
                        cliente = new Cliente("", "", 0, ' ');
                        cliente.setCedula(entrada.readLine().trim());
                        cliente.setNombreCliente(entrada.readLine().trim());
                        cliente.setEdad(Validacion.leerEntero(entrada.readLine().trim(), "Datos numericos incorrectos, el archivo esta corrupto o ha sido daniado. No se garantiza la integridad de los datos. Se recomienda no abrir este archivo.", "Numero no valido"));
                        cliente.setGenero(entrada.readLine().charAt(0));
                        ticket.setCliente(cliente);

                        // Pelicula
                        pelicula = new Pelicula("", "", "", "", false, "", null, null, null);
                        pelicula.setId(entrada.readLine().trim());
                        pelicula.setNombre(entrada.readLine().trim());
                        pelicula.setGenero(entrada.readLine().trim());
                        pelicula.setIdioma(entrada.readLine().trim());
                        pelicula.setTieneSubtitulos(entrada.readLine().charAt(0) == '1'); // Si tiene subtitulos es 1, por ende es verdadero sino es false
                        pelicula.setIdiomaSubtitulos(entrada.readLine().trim());
                        pelicula.setDuracion(Duration.ofSeconds(Validacion.leerLong(entrada.readLine().trim(), "Datos numericos incorrectos, el archivo esta corrupto o ha sido daniado. No se garantiza la integridad de los datos. Se recomienda no abrir este archivo.", "Numero no valido"))); // Se valida y se devuelve un Long a Duration

                        // Los horarios disponibles pueden ser muchos o pocos, no son fijos, por ende debo hacer un for para escribirlos y poner un identificador cuando terminen
                        while (!(horarioHelper = entrada.readLine().trim()).equalsIgnoreCase("hdends"))
                        {
                            getHorariosDisponibles().add(LocalTime.parse(horarioHelper.trim(), CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos)));
                        }
                        pelicula.setHorariosDisponibles(getHorariosDisponibles());
                        pelicula.setFechaEstreno(LocalDate.parse(entrada.readLine().trim(), CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.FechaCorta)));
                        elementosCineRecopilados.put(pelicula.getId(), pelicula);

                        // Sala
                        sala = new Sala("", "", 0, "", "");
                        sala.setId(entrada.readLine().trim());
                        sala.setNombre(entrada.readLine().trim());
                        sala.setNumeroSala(Validacion.leerEntero(entrada.readLine().trim(), "Datos numericos incorrectos, el archivo esta corrupto o ha sido daniado. No se garantiza la integridad de los datos. Se recomienda no abrir este archivo.", "Numero no valido"));
                        sala.setTipoSala(entrada.readLine().trim());
                        sala.setAsiento(entrada.readLine().trim());
                        elementosCineRecopilados.put(sala.getId(), sala);

                        // Funcion
                        funcion = new Funcion("", "", null, false);
                        funcion.setId(entrada.readLine().trim());
                        funcion.setNombre(entrada.readLine().trim());
                        funcion.setHorarioElegido(LocalTime.parse(entrada.readLine().trim(), CommonlyUsedObjects.getFormatoDateTime(CommonlyUsedObjects.TypeFormatoDateTime.HorasMinutos)));
                        funcion.setEstreno(entrada.readLine().trim().equalsIgnoreCase("estreno"));
                        funcion.setTipoFuncion(TipoFuncion.valueOf(entrada.readLine().trim()));
                        elementosCineRecopilados.put(funcion.getId(), funcion);

                        // Agregamos el HashMap elementosCine al Ticket
                        ticket.setElementosCine(elementosCineRecopilados);

                        // Agregamos el Ticket al HashMap
                        ticketsRecopilados.put(ticket.getId(), ticket);
                    }

                    result = OperationResult.Operacion_Exitosa;
                }
                else
                    result = OperationResult.CanceladoPorElUsuario;
            }
            catch (IOException ioex)
            {
                result = OperationResult.Operacion_Fallida;
                JOptionPane.showMessageDialog(null, result.toString() + ": " + ioex.getMessage(), "Error de Apertura", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (entrada != null)
                        entrada.close();
                    if (lectura != null)
                        lectura.close();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            result = OperationResult.CanceladoPorElUsuario;
        
        return ticketsRecopilados;
    }
    
    /** Verifies settings by default, if a Default Settings file doesn't exist yet, it is created with generic starting values */
    public void defaultSettingsVerifier()
    {   
        FileOutputStream writer = null;
        File defaultSettingsFile = new File("defaultSettings.ctKnSettings");

        if (!defaultSettingsFile.exists())
        {
            try
            {
                // Setting the dafault Properties
                Properties defaultProperties = new Properties();
                defaultProperties.setProperty("dataInputMode", "stored");
                defaultProperties.setProperty("currentGuiLafTheme", "Flat Dark");

                // Saving the default Properties
                writer = new FileOutputStream(defaultSettingsFile, false);
                defaultProperties.store(writer, "-- CinemaTickets Default Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE");
            }
            catch (FileNotFoundException fnfex)
            {
                JOptionPane.showMessageDialog(null, fnfex.getMessage(), "Error al guardar las Preferencias predeterminadas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, fnfex);
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(null, ioex.getMessage(), "Error de Escritura de archivo", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (writer != null)
                        writer.close();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /** Verifies user settings, if User Settings file doesn't exist yet, it is created just as a copy with same values than default settings */
    public void userSettingsVerifier()
    {
        FileOutputStream settingsWriter = null;
        FileInputStream settingsReader = null;
        File userSettingsFile = new File("userSettings.ctKnSettings");

        if (!userSettingsFile.exists())
        {
            try
            {
                // Setting the User Properties from scratch loading the default Properties into it
                userProperties = new Properties();
                settingsReader = new FileInputStream("defaultSettings.ctKnSettings");
                userProperties.load(settingsReader);

                // Saving the User Properties now
                settingsWriter = new FileOutputStream(userSettingsFile, false);
                userProperties.store(settingsWriter, "-- CinemaTickets Default Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE");
                userProperties = null;
            }
            catch (FileNotFoundException fnfex)
            {
                JOptionPane.showMessageDialog(null, fnfex.getMessage(), "Error al guardar o abrir las Preferencias predeterminadas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, fnfex);
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(null, ioex.getMessage(), "Error de Lectura/Escritura de archivo", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (settingsReader != null)
                        settingsReader.close();
                    if (settingsWriter != null)
                        settingsWriter.close();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /** Loads user settings only if User Settings file exists, it is created just as a copy with same values than default settings */
    public void userSettingsLoader()
    {
        FileInputStream settingsReader = null;
        File userSettingsFile = new File("userSettings.ctKnSettings");

        if (userSettingsFile.exists())
        {
            try
            {
                // Setting the User Properties from the saved User Properties File
                userProperties = new Properties();
                settingsReader = new FileInputStream(userSettingsFile);
                userProperties.load(settingsReader);
            }
            catch (FileNotFoundException fnfex)
            {
                JOptionPane.showMessageDialog(null, fnfex.getMessage(), "Error al abrir las Preferencias predeterminadas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, fnfex);
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(null, ioex.getMessage(), "Error de Lectura de archivo", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (settingsReader != null)
                        settingsReader.close();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /** Saves user settings only if User Settings have changed, using a boolean helper attribute */
    public void userSettingsSaver()
    {
        FileOutputStream settingsWriter = null;
        File userSettingsFile = new File("userSettings.ctKnSettings");

        if (isUserSettingsChanged())
        {
            try
            {
                // Saving the User Properties at the Application Closing
                settingsWriter = new FileOutputStream(userSettingsFile, false);
                userProperties.store(settingsWriter, "-- CinemaTickets User Properties -- WARNING: THIS IS AN APPLICATION SYSTEM PROPERTIES FILE. DO NOT CHANGE OR MODIFY THIS FILE");
            }
            catch (FileNotFoundException fnfex)
            {
                JOptionPane.showMessageDialog(null, fnfex.getMessage(), "Error al guardar las Preferencias predeterminadas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, fnfex);
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(null, ioex.getMessage(), "Error de Escritura de archivo", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    if (settingsWriter != null)
                        settingsWriter.close();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(DatosTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /** Updates the Open and Save file dialog GUI, mostly used when a Look and Feel is set, to properly update the {@code JFileChooser} / 
     * Actualiza la GUI del Cuadro de Dialogo usado para Abrir y Guardar y setea el aspecto visual acorde al Tema actual de Look and Feel.
     */
    public static void updateSaveOpenDlg()
    {
        dialogoAbrirGuardarComo.updateUI();
    }
    
    // Getters and Setters
    public static OperationResult getResult()
    {
        return result;
    }

    private static ArrayList<LocalTime> getHorariosDisponibles()
    {
        return horariosDisponibles;
    }

    public boolean isUserSettingsChanged()
    {
        return userSettingsChanged;
    }

    public void setUserSettingsChanged(boolean userSettingsChanged)
    {
        this.userSettingsChanged = userSettingsChanged;
    }

    public Properties getUserProperties()
    {
        return userProperties;
    }
    
}
