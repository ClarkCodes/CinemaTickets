
package controlTesting;

import control.AdmSala;
import control.AdmSettings;
import javax.swing.JComboBox;
import javax.swing.JTable;
import model.Sala;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import visual.FrmCinemaTicketsSystem;

/** Unit Testing Class for AdmSala
 * @author ClarkCodes */
public class AdmSalaTest
{
    private static AdmSala admSala;
    
    @BeforeAll
    public static void setUp()
    {
        FrmCinemaTicketsSystem mainWindow = new FrmCinemaTicketsSystem();
        admSala = AdmSala.getAdm();
    }
    
    @Test
    public void admSalaMustNotBeNull()
    {
        Assertions.assertNotNull( admSala );
        Assertions.assertInstanceOf( AdmSala.class, admSala );
    }
    
    @Test
    public void fillTheatersCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboTheaters = new JComboBox();
        admSala.llenarComboSalas( comboTheaters );

        Assertions.assertTrue( comboTheaters.getItemCount() > 1 );
    }
    
    @Test
    public void getTheater_MustNotBeNull_And_MustBeASalaObject()
    {
        Sala theater = admSala.obtenerSala( "IMAX" );
        Assertions.assertNotNull( theater );
        Assertions.assertInstanceOf( Sala.class, theater );
    }
    
    @Test
    public void fillSelectedTheaterTable_TableDataMustBe()
    {
        Sala theater = admSala.obtenerSala( "IMAX" );
        JTable theaterTable = new JTable();
        
        // Setting the necessary table model
        theaterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                AdmSettings.getLanguageBundle().getString("lk_code"), AdmSettings.getLanguageBundle().getString("lk_theater_number"), AdmSettings.getLanguageBundle().getString("lk_cHeader_theater_type"), AdmSettings.getLanguageBundle().getString("lk_cHeader_seats")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });

        // Populating the table
        admSala.llenarTablaSalaElegida( theater.getId(), theaterTable );
        
        // Asserting the table and the comboBox content
        Assertions.assertEquals( theater.getId(), theaterTable.getValueAt( 0, 0 ) );
        Assertions.assertEquals( theater.getNumeroSala(), theaterTable.getValueAt( 0, 1 ) );
        Assertions.assertEquals( theater.getTipoSala(), theaterTable.getValueAt( 0, 2 ) );
        Assertions.assertEquals( theater.getAsiento(), theaterTable.getValueAt( 0, 3 ) );
    }
    
}
