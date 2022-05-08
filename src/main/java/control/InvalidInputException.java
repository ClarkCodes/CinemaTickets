
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Customized Exception to use when very specific scenarios occur when 
 * validating data input when entering information
 * @author Clark - ClarkCodes 
 * @since 1.0
 */
public final class InvalidInputException extends Exception
{
    InvalidInputException ( String developerMessage )
    {
        super( developerMessage );
    }
}

// Creo esta Clase, de manera muy simple, minimalista y sencilla, sin mucha cosa dentro, es una Excepcion personalizada que creo para facilitar la validacion de Opciones ingresadas.
