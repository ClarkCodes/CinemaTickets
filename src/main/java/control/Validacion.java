
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import javax.swing.JOptionPane;

/** Class made to validate data input / Clase para validar entradas
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public final class Validacion
{
    private static boolean datoValido = true; // Propiedad de validacion para saber si el dato ingresado es valido o no.

    public Validacion ()
    {
    } // Constructor by default

    /** Enum constants to help with Strings validation for indicating what type
     *  of validation perform
     */
    public static enum TipoEntradaString
    {
        Codigo,
        Cedula_Busqueda,
        Cedula_Registro,
        Nombres,
        Correo,
        Telefono
    }

    /** Gets the validation result
     * @return {@code true} if the input data is valid, {@code false} otherwise
     * @since 1.0
     */
    public static boolean isDatoValido ()
    {   // En este caso solo necesito un getter, dado que solo se consulta el valor para saber si es valido, nunca se lo cambia desde la clase Principal, y dado que es un boolean tiene el prefijo "is", en este caso "isDatoValido".
        return datoValido;
    }

    /** Validates a decimal number, accepts a {@code String} input, parses it to
     * a {@code double} representation, returns it as number if possible
     * and shows an error message catching the exception if not
     *
     * @param entrada      {@code String} representation of a double decimal 
     *                     number to be parsed
     * @param mensajeError A {@code String} that contains a message to show if
     *                     it is not possible parsing the given {@code entrada}
     * @param tituloError  Error title if it is not possible parsing the given
     *                     {@code entrada}
     *
     * @return The {@code double} representation of the given {@code entrada} 
     * if succesfully parsed
     */
    public static double leerReal ( String entrada, String mensajeError, String tituloError )
    {
        double real = -1.0;

        try
        {
            real = Double.parseDouble( entrada );
            validarNoNegativo( real );
            datoValido = true;
        }
        
        catch ( NumberFormatException ex )
        {
            JOptionPane.showMessageDialog( null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE );
            datoValido = false;
        }
        catch ( InvalidInputException iex )
        {
            JOptionPane.showMessageDialog( null, iex.getLocalizedMessage(), AdmSettings.getLanguageBundle().getString( "lk_validation_price_less_than_zero_title" ), JOptionPane.WARNING_MESSAGE );
            datoValido = false;
            real = -1.0;
        }

        return real;
    }

    /** Validates a long number, accepts a {@code String} input, parses it to a
     * {@code long} representation, returns it as number if possible
     * and shows an error message catching the exception if not
     *
     * @param entrada      {@code String} representation of a long number to be
     *                     parsed
     * @param mensajeError A {@code String} that contains a message to show if
     *                     it is not possible parsing the given {@code entrada}
     * @param tituloError  Error title if it is not possible parsing the given
     *                     {@code entrada}

     * @return The {@code long} numeric representation if succesfully parsed
     */
    public static long leerLong ( String entrada, String mensajeError, String tituloError )
    {
        long longNumber = -1L;

        try
        {
            longNumber = Long.parseLong( entrada );
            datoValido = true;
        }
        catch ( NumberFormatException ex )
        {
            JOptionPane.showMessageDialog( null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE );
            datoValido = false;
        }

        return longNumber;
    }

    /** Validates a integer number, accepts a {@code String} input, parses it to
     * a {@code int} representation, returns it as number if possible
     * and shows an error message catching the exception if not
     *
     * @param entrada      {@code String} representation of a integer number to
     *                     be parsed
     * @param mensajeError A {@code String} that contains a message to show if
     *                     it is not possible parsing the given {@code entrada}
     * @param tituloError  Error title if it is not possible parsing the given
     *                     {@code entrada}

     * @return The {@code int} representation of the number if succesfully 
     * parsed
     */
    public static int leerEntero ( String entrada, String mensajeError, String tituloError )
    {
        int entero = -1;

        try
        {
            entero = Integer.parseInt( entrada );
            datoValido = true;
        }

        catch ( NumberFormatException ex )
        {
            JOptionPane.showMessageDialog( null, mensajeError, tituloError, JOptionPane.WARNING_MESSAGE );
            datoValido = false;
        }

        return entero;
    }

    /** Validates a {@code String} text input, and verifies if it has the right
     * composition structure, shows an error message otherwise
     *
     * @param strEntradaUsuario A {@code String} that contains the input to 
     *                          be validated
     * @param tipo              {@code TipoEntradaString enum} constant that
     *                          indicates the input type to validate it properly
     * @return                  {@code true} if the input {@code String} has a 
     *                          valid admitted text composition structure, 
     *                          {@code false} otherwise
     */
    public static boolean validarStrings ( String strEntradaUsuario, TipoEntradaString tipo )
    {
        String errorMessage = "", errorTitle = "";
        int chCounter; //Nombres de variables en ingles.
        boolean isStringInputValid = true;

        char[] entrada = strEntradaUsuario.toCharArray();
        int longitudEntrada = entrada.length;

        switch ( tipo )
        {
            case Codigo ->
            {   // This validation case maybe is not used, but it is here because it was originally developed with Validation class and it is here just in case if needed some day
                if ( entrada.length == 2 && entrada[0] == '0' && ( ( entrada[1] >= 2 && entrada[1] <= '7' ) || entrada[1] == '9' ) )
                {
                    isStringInputValid = true;
                }
                else
                {
                    isStringInputValid = false;
                    errorMessage = "Descripcion del Error: El Codigo debe ser entre 02 y 09 excepto el 08, o sea los 2 digitos, vuelva a ingresarlo de esa manera por favor.";
                    errorTitle = "Codigo no valido";
                }
            }

            case Cedula_Busqueda ->
            {
                errorMessage = AdmSettings.getLanguageBundle().getString( "lk_validation_id_search_msj" );
                errorTitle = AdmSettings.getLanguageBundle().getString( "lk_validation_invalid_id_title" );

                if ( longitudEntrada <= 10 ) // se evalua si la entrada tiene hasta 10 caracteres, puede tener menos, de ser asi esta bien y continua, pero sino, la reprueba
                {
                    for ( chCounter = 0; ( chCounter < longitudEntrada ) && isDatoValido(); chCounter++ )
                    {	    // Se recorre la cadena caracter por caracter y se evalua si el caracter No se encuentra dentro del rango ascii correspondiente a los digitos
                        if ( !( entrada[chCounter] >= 48 && entrada[chCounter] <= 57 ) ) // Notese el caracter de admiracion '!' de negación
                        {
                            isStringInputValid = false; // En este caso asignar falso el resultado, lo que significa que lo ingresado no esta dentro del rango debido por lo que no ha pasado la prueba
                            break;
                        }
                    }

                }
                else
                {
                    isStringInputValid = false;
                }
            }
            
            case Cedula_Registro ->
            {
                errorMessage = AdmSettings.getLanguageBundle().getString( "lk_validation_id_registration_msj" );
                errorTitle = AdmSettings.getLanguageBundle().getString( "lk_validation_invalid_id_title" );

                if ( longitudEntrada == 10 ) // se evalua si la entrada tiene exactamente 10 caracteres, de ser asi esta bien y continua, pero sino, la reprueba
                {
                    for ( chCounter = 0; ( chCounter < longitudEntrada ) && isDatoValido(); chCounter++ )
                    {	    // Se recorre la cadena caracter por caracter y se evalua si el caracter No se encuentra dentro del rango ascii correspondiente a los digitos
                        if ( !( entrada[chCounter] >= 48 && entrada[chCounter] <= 57 ) ) // Notese el caracter de admiracion '!' de negación
                        {
                            isStringInputValid = false; // En este caso asignar falso el resultado, lo que significa que lo ingresado no esta dentro del rango debido por lo que no ha pasado la prueba
                            break;
                        }
                    }

                }
                else
                {
                    isStringInputValid = false;
                }
            }

            case Nombres ->
            {
                for ( chCounter = 0; ( chCounter < longitudEntrada ) && isDatoValido(); chCounter++ )
                {   // Comparacion: Tabla Ascii -> Rango letras mayusculas 65-90 / Rango letras minusculas 97-122 / Espacio en blanco 32
                    if ( !( ( entrada[chCounter] >= 65 && entrada[chCounter] <= 90 ) || ( entrada[chCounter] >= 97 && entrada[chCounter] <= 122 ) || ( entrada[chCounter] == 32 ) ) )
                    {
                        isStringInputValid = false;
                        errorMessage = AdmSettings.getLanguageBundle().getString( "lk_validation_name_msj" );
                        errorTitle = AdmSettings.getLanguageBundle().getString( "lk_validation_name_title" );
                    }
                }
            }

            case Telefono ->
            {
                errorTitle = "Numero de Telefono no valido";

                if ( longitudEntrada <= 10 )
                {
                    for ( chCounter = 0; ( chCounter < longitudEntrada ) && isDatoValido(); chCounter++ )
                    {
                        if ( !( entrada[chCounter] >= 48 && entrada[chCounter] <= 57 ) )
                        {
                            isStringInputValid = false;
                            errorMessage = "Descripcion del Error: El numero telefonico solo puede contener numeros, ingreselo nuevamente.";
                        }
                    }
                }
                else
                {
                    isStringInputValid = false;
                    errorMessage = "Descripcion del Error: El numero telefonico puede maximo hasta 10 numeros, ingreselo nuevamente.";
                }
            }

            case Correo ->
            {
                int atCounter = 0, dotCounter = 0; // Sabemos que un correo debe tener un solo caracter @ y debe tener al menos un punto (pueden haber mas puntos)
                for ( chCounter = 0; chCounter < longitudEntrada; chCounter++ )
                {   // Recorriendo el vector de la cadena
                    if ( entrada[chCounter] == 64 ) // 64: Codigo Ascii para el caracter arroba '@'
                        atCounter++; // Contador del @

                    if ( entrada[chCounter] == 46 ) // 46: Codigo Ascii para el caracter del punto '.'
                        dotCounter++; // Contador del .
                }
                if ( !( ( atCounter == 1 ) && ( dotCounter >= 1 ) ) )
                {   // Validacion tal cual, comparando si existen las cantidades adecuadas del '@' y del '.', sino, se reprueba
                    isStringInputValid = false;
                    errorMessage = "Descripcion del Error: La direccion de correo electronico debe contener 1 unico si�mbolo arroba('@') y al menos 1 punto('.'), ingreselo nuevamente.";
                    errorTitle = "Correo Electronico no valido";
                }
            }
        }

        if ( !isStringInputValid )
            JOptionPane.showMessageDialog( null, errorMessage, errorTitle, JOptionPane.WARNING_MESSAGE );

        return isStringInputValid;
    }
    
    /** Validates a client age by calling and trying the method in charge, 
     * the age must be greater than 0
     * 
     * @param edad A client age to validate
     * @return     {@code true} if the age is valid, {@code false} otherwise
     * @since 1.6
     */
    public static boolean validarEdad( int edad )
    {
        boolean isAgeValid = true;
        try
        {
            evaluarEdad( edad );
        }
        catch( InvalidInputException invalidInputEx )
        {
            JOptionPane.showMessageDialog( null, invalidInputEx.getMessage(), AdmSettings.getLanguageBundle().getString( "lk_validation_age_title" ), JOptionPane.WARNING_MESSAGE );
            isAgeValid = false;
        }
        return isAgeValid;
    }
 
    /** Validates an age number following a defined criteria, the criteria in
     * this case is that age cannot be equals to 0
     * 
     * @param edad An {@code int} number to validate as an age
     * 
     * @throws InvalidInputException If the age number is 0
     * 
     * @since 1.6
     * @see control.InvalidInputException
     */
    private static void evaluarEdad( int edad ) throws InvalidInputException
    {
        if( edad == 0 )
            throw new InvalidInputException("\n" + AdmSettings.getLanguageBundle().getString( "lk_validation_age_msj" ) );
    }
    
    /** Validates if a {@code Double} or {@code Integer} number is not lesser
     * than 0, for example: a currency price number
     * 
     * @param number A {@code Double} or {@code Integer} number to be validated
     * 
     * @return {@code true} only if the number is 0 or greater, throws an 
     * exception otherwise
     * 
     * @throws InvalidInputException If the number is lesser than 0
     * 
     * @since 1.6
     * @see control.InvalidInputException
     */
    private static <T extends Double, Integer> boolean validarNoNegativo ( T number ) throws InvalidInputException
    {
        if ( number < 0 )
            throw new InvalidInputException("\n" + AdmSettings.getLanguageBundle().getString( "lk_validation_price_less_than_zero_msj" ) );

        return true;
    }

}
