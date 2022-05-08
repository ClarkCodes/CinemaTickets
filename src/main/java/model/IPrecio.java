package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Interface that has an important method related with Movie Price
 * @author Clark - ClarkCodes 
 * @since 1.0
 * @see model.Ticket
 */
public sealed interface IPrecio permits Ticket
{
    public void generarPrecio();
}
