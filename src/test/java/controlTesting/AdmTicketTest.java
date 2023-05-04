
package controlTesting;

import control.Commons;
import control.*;
import java.time.LocalDate;
import java.time.LocalTime;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.InjectMocks;
import visual.FrmCinemaTicketsSystem;
import visual.FrmGenerarTicket;

@Execution ( ExecutionMode.SAME_THREAD )
/** Unit Testing Class for AdmTicket
 * @author ClarkCodes */

public class AdmTicketTest
{
    private static AdmTicket admTicket;
    private static AdmCliente admCliente;
    private static AdmSala admSala;
    private static AdmPelicula admPelicula;
    private static FrmCinemaTicketsSystem mainWindow;
    @InjectMocks
    private FrmGenerarTicket generarTicketWindow;
    
    @BeforeAll
    public static void setUp()
    {
        mainWindow = new FrmCinemaTicketsSystem();
        admTicket = AdmTicket.getAdm();
        admCliente = AdmCliente.getAdm();
        admSala = AdmSala.getAdm();
        admPelicula = AdmPelicula.getAdm();
        
        // *** Testing Ticket on Creation and Generation
        //FrmGenerarTicket generarWindow = new FrmGenerarTicket( mainWindow, true, Commons.WindowMode.Creacion, "" );
        //generarWindow.setVisible( true );
    }
    
    @Test
    public void admPeliculaMustNotBeNull()
    {
        Assertions.assertNotNull( admTicket );
        Assertions.assertInstanceOf( AdmTicket.class, admTicket );
    }
    
    @Test
    public void prepararTicket_ResultShouldBe()
    {   // Preparation
        Ticket ticketTesting = new Ticket();
        Cliente clienteTesting = admCliente.generarCliente();
        Pelicula peliculaTesting = admPelicula.obtenerPelicula( "Justice League - Snyder Cut" );
        Sala salaTesting = admSala.obtenerSala( "IMAX - VIP" );
        Funcion funcionTesting = admPelicula.obtenerFuncion( "20:00", "Justice League - Snyder Cut" );
        
        admTicket.setTempReadyClient( clienteTesting );
        admTicket.setTempReadyPelicula( peliculaTesting );
        admTicket.setTempReadySala( salaTesting );
        admTicket.setTempReadyFuncion( funcionTesting );
        admTicket.setTicket( ticketTesting );
        
        admTicket.prepararTicket( Commons.WindowMode.Creacion );
        
        ticketTesting = admTicket.getTicket();
        int assignedTicketNumber = ticketTesting.getNumeroTicket();
        String actualTicketId = ticketTesting.getId(), 
                expectedTicketId = "T-" + Commons.doubleOneDigitStrFormatter( String.valueOf( ticketTesting.getNumeroTicket() ) ) + LocalDate.now().format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.FechaCompacta ) ) + Commons.doubleOneDigitStrFormatter( String.valueOf( LocalTime.now().getMinute() ) ) + Commons.doubleOneDigitStrFormatter( String.valueOf( LocalTime.now().getSecond() ) );
        
        // Verifying not null and type
        Assertions.assertNotNull( ticketTesting );
        Assertions.assertInstanceOf( Ticket.class, ticketTesting );
        
        // Verifying Ticket data
        Assertions.assertEquals( expectedTicketId.substring( 0, expectedTicketId.length() -2 ), actualTicketId.substring( 0, actualTicketId.length() - 2 ) );
        Assertions.assertEquals( 14, actualTicketId.length() );
        Assertions.assertEquals( "Ticket - " + AdmSettings.getLanguageBundle().getString( "lk_ticket_name" ) + " - " + admTicket.getTempReadySala().getTipoSala(), ticketTesting.getNombre() );
        Assertions.assertEquals( admTicket.getTicketsGenerados(), assignedTicketNumber );
        
        Assertions.assertEquals( clienteTesting, ticketTesting.getCliente() );
        Assertions.assertEquals( salaTesting, ticketTesting.getSala() );
        Assertions.assertEquals( funcionTesting, ticketTesting.getFuncion() );
        Assertions.assertEquals( peliculaTesting, ticketTesting.getPelicula() );
        
        // Testing Ticket on Edition
        //FrmGenerarTicket editarWindow = new FrmGenerarTicket( mainWindow, true, Commons.WindowMode.Edicion, ticket.getId() ); 
        //editarWindow.setVisible( true );
        //Ticket ticketEdited = admTicket.getTicket();
        
        ////
        //// *** Verifying Ticket data
//        Assertions.assertEquals( expectedTicketId, ticketEdited.getId().substring( 0, actualTicketId.length() - 2 ) );
//        Assertions.assertEquals( 14, ticketEdited.getId().length() );
//        Assertions.assertEquals( "Ticket - " + AdmSettings.getLanguageBundle().getString( "lk_ticket_name" ) + " - " + admTicket.getTempReadySala().getTipoSala(), ticketEdited.getNombre() );
//        Assertions.assertEquals( assignedTicketNumber, ticketEdited.getNumeroTicket() );
//        
//        Assertions.assertEquals( admCliente.getTempClient(), ticket.getCliente() );
//        Assertions.assertEquals( admTicket.getTempReadySala(), ticket.getSala() );
//        Assertions.assertEquals( admTicket.getTempReadyFuncion(), ticket.getFuncion() );
//        Assertions.assertEquals( admTicket.getTempReadyPelicula(), ticket.getPelicula() );
    }
    
    @Execution ( ExecutionMode.SAME_THREAD )
    @Test
    public void generarTicket_ResultShouldBe()
    {
        Ticket newTicket = admTicket.getTicket();
        newTicket.setId( admTicket.getTicket().getId().substring( 0, admTicket.getTicket().getId().length() - 2 ) + "02" );
        
        admTicket.setTicket( newTicket );
        admTicket.generarTicket();
        
        Assertions.assertEquals( 2, admTicket.getTickets().size() );
        Assertions.assertEquals( 2, admTicket.getTicketsGenerados() );
        
        newTicket.setId( newTicket.getId().substring( 0, newTicket.getId().length() - 1 ) + "3" );
        
        admTicket.setTicket( newTicket );
        admTicket.generarTicket();
        
        Assertions.assertEquals( 3, admTicket.getTickets().size() );
        Assertions.assertEquals( 3, admTicket.getTicketsGenerados() );
        
        newTicket.setId( newTicket.getId().substring( 0, newTicket.getId().length() - 1 ) + "4" );
        
        admTicket.setTicket( newTicket );
        admTicket.generarTicket();
        
        Assertions.assertEquals( 4, admTicket.getTickets().size() );
        Assertions.assertEquals( 4, admTicket.getTicketsGenerados() );
        
        newTicket.setId( newTicket.getId().substring( 0, newTicket.getId().length() - 1 ) + "5" );
        
        admTicket.setTicket( newTicket );
        admTicket.generarTicket();
        
        Assertions.assertEquals( 5, admTicket.getTickets().size() );
        Assertions.assertEquals( 5, admTicket.getTicketsGenerados() );
        
        newTicket.setId( newTicket.getId().substring( 0, newTicket.getId().length() - 1 ) + "6" );
        
        admTicket.setTicket( newTicket );
        admTicket.generarTicket();
        
        Assertions.assertEquals( 6, admTicket.getTickets().size() );
        Assertions.assertEquals( 6, admTicket.getTicketsGenerados() );
    }
    
    @Test
    public void actualizarTicket_ResultShouldBe()
    {
        Ticket baseTicket = admTicket.getTicket();
        Ticket editedTicket1 = baseTicket;
        Ticket editedTicket2 = baseTicket;
        
        ////
        //// *** Ticket1
        
        Cliente newCliente = admCliente.generarCliente();
        editedTicket1.setCliente( newCliente );
        editedTicket1.setNombre( "Nombre Editado para el Ticket" );
        
        admTicket.setTicket( editedTicket1 );
        admTicket.actualizarTicket( editedTicket1.getId() );
        
        // Verifying Ticket data Ticket 1
        Assertions.assertEquals( "Nombre Editado para el Ticket", admTicket.getTickets().get( editedTicket1.getId() ).getNombre() );
        Assertions.assertEquals( baseTicket.getNumeroTicket(), admTicket.getTickets().get( editedTicket1.getId() ).getNumeroTicket() );
        
        Assertions.assertEquals( newCliente, admTicket.getTickets().get( editedTicket1.getId() ).getCliente() );
        Assertions.assertEquals( baseTicket.getSala(), admTicket.getTickets().get( editedTicket1.getId() ).getSala() );
        Assertions.assertEquals( baseTicket.getFuncion(), admTicket.getTickets().get( editedTicket1.getId() ).getFuncion() );
        Assertions.assertEquals( baseTicket.getPelicula(), admTicket.getTickets().get( editedTicket1.getId() ).getPelicula() );
        Assertions.assertEquals( baseTicket.getPrecio(), admTicket.getTickets().get( editedTicket1.getId() ).getPrecio() );
        Assertions.assertEquals( baseTicket.getPrecioFormatoMoneda(), admTicket.getTickets().get( editedTicket1.getId() ).getPrecioFormatoMoneda());
        
        ////
        //// *** Ticket2
        
        editedTicket2.setId( baseTicket.getId().substring( 0, baseTicket.getId().length() - 2 ) + "02" );
        editedTicket2.setNumeroTicket( editedTicket1.getNumeroTicket() + 1 );
        Ticket baseTicket2 = editedTicket2;
        admTicket.setTicket( baseTicket2 );
        admTicket.generarTicket();
        
        newCliente = admCliente.generarCliente();
        editedTicket2.setCliente( newCliente );
        editedTicket2.setNombre( "Nombre Editado #2" );
        Pelicula pelicula2 = admPelicula.obtenerPelicula( "The Edge of Tomorrow" );
        Funcion funcion2 = admPelicula.obtenerFuncion( "12:45", "The Edge of Tomorrow" );
        
        String keyPeliculaAnterior2 = "", keyFuncionAnterior2 = "";
        
        for ( ElementoCine elemento : editedTicket2.getElementosCine().values() )
        {
            if ( elemento instanceof Pelicula peliculaEncontrada )
                keyPeliculaAnterior2 = peliculaEncontrada.getId();
            
            if ( elemento instanceof Funcion funcionEncontrada )
                keyFuncionAnterior2 = funcionEncontrada.getId();
        }
        
        editedTicket2.getElementosCine().remove( keyPeliculaAnterior2 );
        editedTicket2.getElementosCine().remove( keyFuncionAnterior2 );
        
        editedTicket2.getElementosCine().put( pelicula2.getId(), pelicula2);
        editedTicket2.getElementosCine().put( funcion2.getId(), funcion2);
        
        admTicket.setTicket( editedTicket2 );
        admTicket.actualizarTicket( editedTicket1.getId() );
        
        // Verifying Ticket data Ticket 2
        Assertions.assertEquals( "Nombre Editado #2", admTicket.getTickets().get( editedTicket2.getId() ).getNombre() );
        Assertions.assertEquals( baseTicket.getNumeroTicket(), admTicket.getTickets().get( editedTicket2.getId() ).getNumeroTicket() );
        
        Assertions.assertEquals( newCliente, admTicket.getTickets().get( editedTicket2.getId() ).getCliente() );
        Assertions.assertEquals( baseTicket.getSala(), admTicket.getTickets().get( editedTicket2.getId() ).getSala() );
        Assertions.assertEquals( funcion2, admTicket.getTickets().get( editedTicket2.getId() ).getFuncion() );
        Assertions.assertEquals( pelicula2, admTicket.getTickets().get( editedTicket2.getId() ).getPelicula() );
        Assertions.assertEquals( baseTicket.getPrecio(), admTicket.getTickets().get( editedTicket2.getId() ).getPrecio() );
        Assertions.assertEquals( baseTicket.getPrecioFormatoMoneda(), admTicket.getTickets().get( editedTicket2.getId() ).getPrecioFormatoMoneda());
        
        ////
        //// *** Ticket3
        
        newCliente = admCliente.generarCliente();
        editedTicket2.setCliente( newCliente );
        editedTicket2.setNombre( "Nombre Editado para el Ticket #3 - Definitivo" );
        Pelicula pelicula3 = admPelicula.obtenerPelicula( "Justice League - Snyder Cut" );
        Funcion funcion3 = admPelicula.obtenerFuncion( "20:00", "Justice League - Snyder Cut" );
        Sala sala3 = admSala.obtenerSala( "IMAX - VIP" );

        editedTicket2.getElementosCine().clear();
        
        editedTicket2.getElementosCine().put( pelicula3.getId(), pelicula3 );
        editedTicket2.getElementosCine().put( funcion3.getId(), funcion3 );
        editedTicket2.getElementosCine().put( sala3.getId(), sala3 );
        editedTicket2.generarPrecio();
        admTicket.setTicket( editedTicket2 );
        admTicket.actualizarTicket( editedTicket2.getId() );
        
        // Verifying Ticket data Ticket 3
        Assertions.assertEquals( "Nombre Editado para el Ticket #3 - Definitivo", admTicket.getTickets().get( editedTicket2.getId() ).getNombre() );
        Assertions.assertEquals( editedTicket2.getNumeroTicket(), admTicket.getTickets().get( editedTicket2.getId() ).getNumeroTicket() );
        
        Assertions.assertEquals( newCliente, admTicket.getTickets().get( editedTicket2.getId() ).getCliente() );
        Assertions.assertEquals( sala3, admTicket.getTickets().get( editedTicket2.getId() ).getSala() );
        Assertions.assertEquals( funcion3, admTicket.getTickets().get( editedTicket2.getId() ).getFuncion() );
        Assertions.assertEquals( pelicula3, admTicket.getTickets().get( editedTicket2.getId() ).getPelicula() );
        Assertions.assertEquals( editedTicket2.getPrecio(), admTicket.getTickets().get( editedTicket2.getId() ).getPrecio() );
        Assertions.assertEquals( editedTicket2.getPrecioFormatoMoneda(), admTicket.getTickets().get( editedTicket2.getId() ).getPrecioFormatoMoneda());
    }
    
    
}
