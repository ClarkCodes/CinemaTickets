
package controlTesting;

import control.AdmCliente;
import control.AdmSettings;
import java.util.LinkedList;
import javax.swing.JComboBox;
import model.Cliente;
import control.Commons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import visual.FrmCinemaTicketsSystem;

/** Unit Testing Class for AdmCliente
 * @author ClarkCodes */
public class AdmClienteTest
{
    private static AdmCliente admCliente;
    
    @BeforeAll
    public static void setUp()
    {
        FrmCinemaTicketsSystem mainWindow = new FrmCinemaTicketsSystem();
        admCliente = AdmCliente.getAdm();
    }
    
    @Test
    public void admClienteMustNotBeNull()
    {
        Assertions.assertNotNull( admCliente );
        Assertions.assertInstanceOf( AdmCliente.class, admCliente );
    }
    
    @Test
    public void generatedClient_MustNotBeNull_And_MustBeAClienteObject()
    {
        Cliente clientObtained = admCliente.generarCliente();
        Assertions.assertNotNull( clientObtained );
        Assertions.assertInstanceOf( Cliente.class, clientObtained );
    }
    
    @Test
    public void registeredClient_MustNotBeNull_And_MustBeAClienteObject()
    {
        admCliente.registerClient( "0981234567", "Clark", 25, 'M' );
        Cliente registeredClient = admCliente.getTempClient();
        Assertions.assertNotNull( registeredClient );
        Assertions.assertInstanceOf( Cliente.class, registeredClient );
    }
    
    @Test
    public void fillClientAgeCriterias_elementsInTheComboMustBe()
    {
        JComboBox comboAgeCriterias = new JComboBox();
        admCliente.fillClientAgeCriterias( comboAgeCriterias );
        LinkedList<String> ageCriterias = new LinkedList<>();
        String[] criteriasSpanish = { "Cualquiera", "Clientes con...", "Clientes mayores de...", "Clientes menores de..." };
        String[] criteriasEnglish = { "Any", "Clients that are...", "Clients older than...", "Clients younger than..." };
        
        for ( int itemIndex = 0; itemIndex < comboAgeCriterias.getItemCount(); itemIndex++ )
        {
            if ( comboAgeCriterias.getItemAt( itemIndex ) instanceof String criteria )
                ageCriterias.add( criteria );
        }
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> Assertions.assertArrayEquals( criteriasSpanish , ageCriterias.toArray( String[]::new ) );
            case English -> Assertions.assertArrayEquals( criteriasEnglish , ageCriterias.toArray( String[]::new ) );
        }
    }
    
    @Test
    public void fillClientGenders_GendersWhenCreationMustBe()
    {
        JComboBox comboGenders = new JComboBox();
        admCliente.fillGenders( comboGenders, Commons.WindowMode.Creacion );
        LinkedList<String> genders = new LinkedList<>();
        String[] gendersSpanish = { "Femenino", "Masculino" };
        String[] gendersEnglish = { "Female", "Male" };
        
        for ( int itemIndex = 0; itemIndex < comboGenders.getItemCount(); itemIndex++ )
        {
            if ( comboGenders.getItemAt( itemIndex ) instanceof String criteria )
                genders.add( criteria );
        }
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> Assertions.assertArrayEquals( gendersSpanish , genders.toArray( String[]::new ) );
            case English -> Assertions.assertArrayEquals( gendersEnglish , genders.toArray( String[]::new ) );
        }
    }
    
    @Test
    public void fillClientGenders_GendersWhenSearchMustBe()
    {
        JComboBox comboGenders = new JComboBox();
        admCliente.fillGenders( comboGenders, Commons.WindowMode.Busqueda );
        LinkedList<String> genders = new LinkedList<>();
        String[] gendersSpanish = { "Todos", "Femenino", "Masculino" };
        String[] gendersEnglish = { "All", "Female", "Male" };
        
        for ( int itemIndex = 0; itemIndex < comboGenders.getItemCount(); itemIndex++ )
        {
            if ( comboGenders.getItemAt( itemIndex ) instanceof String criteria )
                genders.add( criteria );
        }
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> Assertions.assertArrayEquals( gendersSpanish , genders.toArray( String[]::new ) );
            case English -> Assertions.assertArrayEquals( gendersEnglish , genders.toArray( String[]::new ) );
        }
    }
    
}
