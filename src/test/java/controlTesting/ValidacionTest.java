
package controlTesting;

import control.Validacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import visual.FrmCinemaTicketsSystem;

/** Unit Testing Class for Validacion
 * @author ClarkCodes */
public class ValidacionTest
{   
    @BeforeAll
    public static void setUp()
    {
        FrmCinemaTicketsSystem mainWindow = new FrmCinemaTicketsSystem();
    }
    
    @Test
    public void leerReal_ResultMustBe()
    {   // Casos en los que la conversión debería ser correcta
        Assertions.assertEquals( 2.0, Validacion.leerReal( "2.0", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 3.7, Validacion.leerReal( "3.7", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 7.35, Validacion.leerReal( "7.35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 4.50, Validacion.leerReal( "4.50", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 3.1415926, Validacion.leerReal( "3.1415926", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        
        // Casos en los que la conversion deberia se no válida
        Assertions.assertEquals( -1.0, Validacion.leerReal( "7.35a", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "3.35_", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "b3.35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "abc7.35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "7,35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "2,25_", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "a8,50", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        
        // Casos en los que la conversion deberia se no válida por número negativo y comas (,)
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-8,50", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-3,35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-105,25", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-8.50", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-3.35", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1.0, Validacion.leerReal( "-105.25", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
    }
    
    @Test
    public void leerEntero_ResultMustBe()
    {   // Conversiones que deberian ser correctas
        Assertions.assertEquals( 2, Validacion.leerEntero( "2", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 7, Validacion.leerEntero( "7", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 525, Validacion.leerEntero( "525", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 100, Validacion.leerEntero( "100", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 2000, Validacion.leerEntero( "2000", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        
        // Conversiones que deben ser no válidas
        Assertions.assertEquals( -1, Validacion.leerEntero( "7a", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "abc7", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "3_", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "325_", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "abc2000", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "Hola", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "Error", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerEntero( "Err0r", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
    }
    
    @Test
    public void leerLong_ResultMustBe()
    {   // Conversiones que deberian ser correctas
        Assertions.assertEquals( 2, Validacion.leerLong( "2", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 7, Validacion.leerLong( "7", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 525, Validacion.leerLong( "525", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 100, Validacion.leerLong( "100", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        Assertions.assertEquals( 2000, Validacion.leerLong( "2000", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertTrue( Validacion.isDatoValido() );
        
        // Conversiones que deben ser no válidas
        Assertions.assertEquals( -1, Validacion.leerLong( "7a", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "abc7L", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "3_L", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "325_", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "abc2000", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "LHola", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "ErrorL", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
        Assertions.assertEquals( -1, Validacion.leerLong( "Err0r", "Mensaje de Error", "Titulo de Error" ) );
        Assertions.assertFalse( Validacion.isDatoValido() );
    }
    
    @Test
    public void validarStrings_CedulaBusqueda_ResultShouldBe()
    {   // Busqueda por Cédula, el inicio de una cédula, que puede ser entre 1 y 10 dígitos
        // Casos en los que la cadena enviada debería ser válida
        Assertions.assertTrue( Validacion.validarStrings( "0", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "1", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "2", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "3", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "4", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "5", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "6", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "7", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "8", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "9", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "09", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "091", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "092", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "093", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "081", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "082", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "083", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "0931", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "09312", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "093123", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "0931234", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "09312345", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "093123456", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "0931234567", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "0123456789", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertTrue( Validacion.validarStrings( "1234567890", Validacion.TipoEntradaString.Cedula_Busqueda) );
        
        // Casos en los que la entrada de la cédula debería ser no válida
        Assertions.assertFalse( Validacion.validarStrings( "a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "b", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "abc", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a0", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "0a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a09", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "09a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a091", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "ab092", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "abc093", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "092ab", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "093abc", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091_", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a091_", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092_", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092__", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092093a", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092093_", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "091092093a_", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "09109_0930", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "09109a0930", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "_9109209309", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "_910920930", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a9109209309", Validacion.TipoEntradaString.Cedula_Busqueda) );
        Assertions.assertFalse( Validacion.validarStrings( "a910920930", Validacion.TipoEntradaString.Cedula_Busqueda) );        
    }
    
    @Test
    public void validarStrings_CedulaRegistro_ResultShouldBe()
    {   // Registro de Cédula de un cliente, la cédula deben ser 10 dígitos numéricos
        // Casos en los que la cadena enviada debería ser válida
        Assertions.assertTrue( Validacion.validarStrings( "0910920930", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertTrue( Validacion.validarStrings( "0910910910", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertTrue( Validacion.validarStrings( "0000000000", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertTrue( Validacion.validarStrings( "1234567890", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertTrue( Validacion.validarStrings( "0123456789", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertTrue( Validacion.validarStrings( "1111111111", Validacion.TipoEntradaString.Cedula_Registro) );
        
        // Casos en los que la cadena enviada debería ser no válida
        Assertions.assertFalse( Validacion.validarStrings( "0", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "0a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a0", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a09", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "091a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "092", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a093", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093b", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "0930", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093092", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "0930920", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309209", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093092091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093092091a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "093092091_", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309a2091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309_2091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a093092091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "_093092091", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "_000000000", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "_111111111", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a000000000", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a111111111", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "000000000_", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "000000000a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "111111111_", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "111111111a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "11111111111", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "11111111112", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309209109", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "0930920910_", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "0930920910a", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "_0930920910", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "a0930920910", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309_20910", Validacion.TipoEntradaString.Cedula_Registro) );
        Assertions.assertFalse( Validacion.validarStrings( "09309a20910", Validacion.TipoEntradaString.Cedula_Registro) );
    }
    
    @Test
    public void validarStrings_NombresApellidos_ResultShouldBe()
    {   // Casos en los que el nombre es válido
        Assertions.assertTrue( Validacion.validarStrings( "Clark", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Clark Kent", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Kal El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Lara El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Jor El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Kelly Clarkson", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Sara Avendanio", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertTrue( Validacion.validarStrings( "Luisa Suarez", Validacion.TipoEntradaString.Nombres ) );
        
        // Casos en los que el nombre debe ser no válido
        Assertions.assertFalse( Validacion.validarStrings( "Kal-El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Jor-El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Lara-El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Cl@rk", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark.", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark_", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark7", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "_Clark", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "7Clark", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark;", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark_Kent", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Clark_Kent;", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "Cl@rk Kent", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "L@ra El", Validacion.TipoEntradaString.Nombres ) );
        Assertions.assertFalse( Validacion.validarStrings( "L@ra-El", Validacion.TipoEntradaString.Nombres ) );
    }
    
    @Test
    public void validarEdad_ResultShouldBe()
    {   // Casos donde la edad es válida
        Assertions.assertTrue( Validacion.validarEdad( 1 ) );
        Assertions.assertTrue( Validacion.validarEdad( 3 ) );
        Assertions.assertTrue( Validacion.validarEdad( 10 ) );
        Assertions.assertTrue( Validacion.validarEdad( 15 ) );
        Assertions.assertTrue( Validacion.validarEdad( 20 ) );
        Assertions.assertTrue( Validacion.validarEdad( 50 ) );
        Assertions.assertTrue( Validacion.validarEdad( 75 ) );
        Assertions.assertTrue( Validacion.validarEdad( 80 ) );
        Assertions.assertTrue( Validacion.validarEdad( 90 ) );
        Assertions.assertTrue( Validacion.validarEdad( 100 ) );
        
        // Casos donde la edad no es valida
        Assertions.assertFalse( Validacion.validarEdad( 0 ) );
    }
}
