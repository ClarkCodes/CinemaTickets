package model;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */

/** Interface that has an important method related with the client gender
 * <p>
 * verGenero: Returns the gender of a Client male or female as a 
 * {@code String}, for example: "Masculino", for male or "Femenino" for female
 * @author Clark - ClarkCodes 
 * @since 1.0
 * @see model.Cliente
 */
public interface IGenero 
{
    /** Gets a {@code String} representation of this Client's gender either male or female which word corresponds
     * @return A {@code String} word representation with this Client's gender
     */
    public String verGenero();
}
