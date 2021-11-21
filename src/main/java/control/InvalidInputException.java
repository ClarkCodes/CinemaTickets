package control;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
/** Excepcion Personalizada 
 * @author Clark - ClarkCodes */
public final class InvalidInputException extends Exception
{
    InvalidInputException(String developerMessage)
    {
        super(developerMessage);
    }
}

/* Creo esta Clase, de manera muy simple, minimalista y sencilla, sin mucha cosa dentro. 
** Es la Excepcion personalizada con mi nombre que creo para facilitar la validacion de 
** Opciones ingresadas. 
**/
