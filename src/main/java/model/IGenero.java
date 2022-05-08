package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Interface that has an important method related with the client gender
 * @author Clark - ClarkCodes 
 * @since 1.0
 * @see model.Cliente
 */
public sealed interface IGenero permits Cliente
{
    public String verGenero();
}
