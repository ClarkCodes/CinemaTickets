package control;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import javax.swing.JOptionPane;

/** Clase para validar entradas
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Validacion 
{
    private static boolean datoValido = true; // Propiedad de validación para saber si el dato ingresado es válido o no.
    
    public Validacion() {} // Constructor by default

    public static enum TipoEntradaString
    {
        Codigo,
        Cedula,
        Nombres,
        Correo,
        Telefono
    }
    
    public static boolean isDatoValido() 
    {   // En este caso solo necesito un getter, dado que solo se consulta el valor para saber si es válido, nunca se lo cambia desde la clase Principal, y dado que es un boolean tiene el prefijo "is", en este caso "isDatoValido".
        return datoValido;
    }

    /** Validates a decimal number, accepts a {@code String} input, parses it to a {@code double} representation, returns it as number if possible
     * and shows an error message catching the exception if not 
     * @param entrada {@code String} representation of a decimal number to be parsed
     * @param mensajeError Message to show if it is not possible to parse the given {@code String} input
     * @param tituloError Error title if it is not possible to parse the given {@code String} input
     * @return The {@code double} representation of the number if succesfully parsed
     */
    public static double leerReal(String entrada, String mensajeError, String tituloError)
    {
        double real = 0.0;
        
        try
        {
            real = Double.parseDouble(entrada);
            datoValido = true;
        }
        catch(NumberFormatException ex)
        {   
            JOptionPane.showMessageDialog(null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE);
            datoValido = false;
        }

        return real;
    }
    
    /** Validates a long number, accepts a {@code String} input, parses it to a {@code long} representation, returns it as number if possible
     * and shows an error message catching the exception if not 
     * @param entrada {@code String} representation of a number to be parsed
     * @param mensajeError Message to show if it is not possible to parse the given {@code String} input
     * @param tituloError Error title if it is not possible to parse the given {@code String} input
     * @return The {@code long} representation of the number if succesfully parsed
     */
    public static long leerLong(String entrada, String mensajeError, String tituloError)
    {
        long longNumber = 0L;

        try
        {
            longNumber = Long.parseLong(entrada);
            datoValido = true;
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE);
            datoValido = false;
        }

        return longNumber;
    }
    
    /** Validates a integer number, accepts a {@code String} input, parses it to a {@code int} representation, returns it as number if possible
     * and shows an error message catching the exception if not 
     * @param entrada {@code String} representation of a integer number to be parsed
     * @param mensajeError Message to show if it is not possible to parse the given {@code String} input
     * @param tituloError Error title if it is not possible to parse the given {@code String} input
     * @return The {@code int} representation of the number if succesfully parsed
     */
    public static int leerEntero(String entrada, String mensajeError, String tituloError)
    {
        int entero = 0;

        try
        {
            entero = Integer.parseInt(entrada);
            datoValido = true;   
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE);
            datoValido = false;
        }

        return entero;
    }

    /** Validates a {@code String} text input, and verifies if it has the right structure or composition, shows an error message otherwise
     * @param strEntradaUsuario {@code String} input to be validated
     * @param tipo {@code TipoEntradaString} enum constant to indicate the input type to validate properly
     * @return The {@code String} input again if it has a right composition/structure
     */
    public static String validarStrings(String strEntradaUsuario, TipoEntradaString tipo)
    {
        String errorMessage = "", errorTitle = "";
        int chCounter = 0; //Nombres de variables en ingles.
        datoValido = true;

        char []entrada = strEntradaUsuario.toCharArray();
        int longitudEntrada = entrada.length;

        switch(tipo)
        {
            case Codigo ->
            {
                if(entrada.length == 2 && entrada[0] == '0' && ((entrada[1] >= 2 && entrada[1] <= '7') || entrada[1] == '9'))
                {
                    datoValido = true;
                }
                else
                {
                    datoValido = false;
                    errorMessage = "Descripcion del Error: El Codigo debe ser entre 02 y 09 excepto el 08, o sea los 2 digitos, vuelva a ingresarlo de esa manera por favor.";
                    errorTitle = "Codigo no valido";
                }
            }

            case Cedula ->
            {
                errorMessage = "Descripcion del Error: Caracteres no validos en la Cedula ingresada. No puede pasar de 10 di�gitos numericos contiguos sin espacios al inicio, al final o intermedios, sin guiones ni caracteres especiales, ingresela nuevamente.";
                errorTitle = "Cedula no valida";

                if(longitudEntrada <= 10) // se evalua si la entrada tiene exactamente 10 caracteres, de ser asi esta bien y continua, pero sino, la reprueba
                {
                    for(chCounter = 0; (chCounter < longitudEntrada) && isDatoValido(); chCounter++)
                    {	    // Se recorre la cadena caracter por caracter y se evalua si el caracter No se encuentra dentro del rango ascii correspondiente a los digitos
                        if(!(entrada[chCounter] >= 48 && entrada[chCounter] <= 57)) // Notese el caracter de admiracion '!' de negación
                            datoValido = false; // En este caso asignar falso el resultado, lo que significa que lo ingresado no esta dentro del rango debido por lo que no ha pasado la prueba
                    }
                }
                else
                {
                    datoValido = false;
                }
            }

            case Nombres ->
            {
                for(chCounter = 0; (chCounter < longitudEntrada) && isDatoValido(); chCounter++)
                {   // Comparacion: Tabla Ascii -> Rango letras mayusculas 65-90 / Rango letras minusculas 97-122 / Espacio en blanco 32
                    if(!( (entrada[chCounter] >= 65 && entrada[chCounter] <= 90) || (entrada[chCounter] >= 97 && entrada[chCounter] <= 122) || (entrada[chCounter] == 32) ))
                    {    
                        datoValido = false;
                        errorMessage = "Descripcion del error: Sus nombres y apellidos deben contener solo letras, ingreselo nuevamente.";
                        errorTitle = "Nombre/Apellido no valido";
                    }
                }
            }

            case Telefono ->
            {
                errorTitle = "Numero de Telefono no valido";

                if(longitudEntrada <= 10)
                {
                    for(chCounter = 0; (chCounter < longitudEntrada) && isDatoValido(); chCounter++)
                    {
                        if(!(entrada[chCounter] >= 48 && entrada[chCounter] <= 57))
                        {
                            datoValido = false;
                            errorMessage = "Descripcion del Error: El numero telefonico solo puede contener numeros, ingreselo nuevamente.";            
                        }
                    }
                }
                else
                {
                    datoValido = false;
                    errorMessage = "Descripcion del Error: El numero telefonico puede maximo hasta 10 numeros, ingreselo nuevamente.";
                }
            }

            case Correo ->
            {
                int atCounter = 0, dotCounter = 0; // Sabemos que un correo debe tener un solo caracter @ y debe tener al menos un punto (pueden haber mas puntos)
                for(chCounter = 0; chCounter < longitudEntrada; chCounter++)
                {   // Recorriendo el vector de la cadena
                    if( entrada[chCounter] == 64) // 64: Codigo Ascii para el caracter arroba '@'
                        atCounter++; // Contador del @
                    
                    if( entrada[chCounter] == 46) // 46: Codigo Ascii para el caracter del punto '.'
                        dotCounter++; // Contador del .
                }
                if(!( (atCounter == 1) && (dotCounter >= 1) ))
                {   // Validacion tal cual, comparando si existen las cantidades adecuadas del '@' y del '.', sino, se reprueba
                    datoValido = false;
                    errorMessage = "Descripcion del Error: La direccion de correo electronico debe contener 1 unico si�mbolo arroba('@') y al menos 1 punto('.'), ingreselo nuevamente.";
                    errorTitle = "Correo Electronico no valido";
                }
            }
        }            

        if(!Validacion.isDatoValido())
            JOptionPane.showMessageDialog(null, errorMessage, errorTitle, JOptionPane.WARNING_MESSAGE);
        
        return strEntradaUsuario;
    }
// Historical - for reference / para referencia
//    private static void readGenero(char genero, char x, char y) throws InvalidInputExceptionFEVM
//    {
//        if(!(genero == x || genero == y))
//            throw new InvalidInputExceptionFEVM("\nGenero no valido. Debe ingresar un genero valido M - Masculino o F - Femenino, vuelva a ingresarlo.");
//    }
    
}
